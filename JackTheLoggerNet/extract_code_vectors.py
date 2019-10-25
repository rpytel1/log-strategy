import os
import json
import argparse
import torch
from tqdm import tqdm
import data_loader.data_loaders as module_data
import model.loss as module_loss
import model.metric as module_metric
from train import get_instance
import numpy as np

from Sample import Sample
import Persistence
import model.model as m


def main(config, resume, file):
    # setup data_loader instances
    data_loader = getattr(module_data, config['data_loader']['type'])(
        file,
        batch_size=100,
        shuffle=False,
        validation_split=0.0,
        training=False,
        num_workers=0,
        test_filename='hackyPlaceholder'
    )

    # build model architecture
    model = m.Code2VecTrained(nodes_dim=config['arch']['args']['nodes_dim'], paths_dim=config['arch']['args']["paths_dim"],
                            embedding_dim=config['arch']['args']["embedding_dim"], output_dim=config['arch']['args']["output_dim"],
                            dropout=config['arch']['args']["dropout"])
    print(model)

    # Show how many parameters
    model_parameters = filter(lambda p: p.requires_grad, model.parameters())
    params = sum([np.prod(p.size()) for p in model_parameters])
    print("Number of trainable parameters:" + str(params))

    # get function handles of loss and metrics
    loss_fn = getattr(module_loss, config['loss'])
    metric_fns = [getattr(module_metric, met) for met in config['metrics']]

    # load state dict
    checkpoint = torch.load(resume)
    state_dict = checkpoint['state_dict']
    if config['n_gpu'] > 1:
        model = torch.nn.DataParallel(model)
    model.load_state_dict(state_dict)

    # prepare model for testing
    device = torch.device('cuda' if torch.cuda.is_available() else 'cpu')
    model = model.to(device)
    model.eval()

    samples = []
    with torch.no_grad():
        for i, (data, target, lengths) in enumerate(tqdm(data_loader)):
            data[0] = data[0].to(device)
            data[1] = data[1].to(device)
            data[2] = data[2].to(device)
            target = target.to(device)

            output = model(data, lengths)
            for i in range(output.size()[0]):
                sample = Sample("abcds", target[i], output[i])
            samples.append(sample)

        Persistence.write(samples, "jan_train5.txt")


if __name__ == '__main__':
    parser = argparse.ArgumentParser(description='PyTorch Template')

    parser.add_argument('-r', '--resume', default=None, type=str,
                        help='path to latest checkpoint (default: None)')
    parser.add_argument('-d', '--device', default=None, type=str,
                        help='indices of GPUs to enable (default: all)')
    parser.add_argument('-f', '--file', default=None, type=str,
                        help='Path to files being procesed')

    args = parser.parse_args()

    if args.resume:
        config = torch.load(args.resume)['config']
    if args.device:
        os.environ["CUDA_VISIBLE_DEVICES"] = args.device

    main(config, args.resume, args.file)
