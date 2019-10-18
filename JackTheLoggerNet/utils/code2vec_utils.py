import torch

import os


def parse_line(line):
    """
    Takes a string 'x y1,p1,z1 y2,p2,z2 ... yn,pn,zn and splits into name (x) and tree [[y1,p1,z1], ...]
    """
    name, *tree = line.split(' ')
    tree = [t.split(',') for t in tree if t != '' and t != '\n']

    return name, tree


def file_iterator(file_path, MAX_LENGTH):
    """
    Takes a file path and creates and iterator
    For each line in the file, parse into a name and tree
    Pad tree to maximum length
    Yields example:
    - example_name = 'target'
    - example_body = [['left_node','path','right_node'], ...]
    """

    with open(file_path, 'r') as f:
        for line in f:
            # each line is an example

            # each example is made of the function name and then a sequence of triplets
            # the triplets are (node, path, node)

            example_name, example_body = parse_line(line)

            # max length set while preprocessing, make sure none longer

            example_length = len(example_body)

            assert example_length <= MAX_LENGTH

            # need to pad all to maximum length

            example_body += [['<pad>', '<pad>', '<pad>']] * (MAX_LENGTH - example_length)

            assert len(example_body) == MAX_LENGTH

            yield example_name, example_body, example_length


def numericalize(examples, n, BATCH_SIZE, MAX_LENGTH, node2idx, path2idx, target2idx):
    """
    Examples are a list of list of lists, i.e. examples[0] = [['left_node','path','right_node'], ...]
    n is how many batches we are getting our of `examples`
    Get a batch of raw (still strings) examples
    Create tensors to store them all
    Numericalize each raw example within the batch and convert whole batch tensor
    Yield tensor batch
    """
    global printBatch
    assert n * BATCH_SIZE <= len(examples)

    for i in range(n):

        # get the raw data

        raw_batch_label, raw_batch_body, batch_lengths = zip(*examples[BATCH_SIZE * i:BATCH_SIZE * (i + 1)])

        # create a tensor to store the batch

        tensor_lab = torch.zeros(BATCH_SIZE).long()  # name
        tensor_l = torch.zeros((BATCH_SIZE, MAX_LENGTH)).long()  # left node
        tensor_p = torch.zeros((BATCH_SIZE, MAX_LENGTH)).long()  # path
        tensor_r = torch.zeros((BATCH_SIZE, MAX_LENGTH)).long()  # right node
        mask = torch.ones((BATCH_SIZE, MAX_LENGTH)).float()  # mask

        # for each example in our raw data
        for j, (label, body, length) in enumerate(zip(raw_batch_label, raw_batch_body, batch_lengths)):
            # convert to idxs using vocab
            # use <unk> tokens if item doesn't exist inside vocab
            label = label[-1:]

            temp_lab = target2idx.get(label, target2idx['0'])
            # temporary left, path and right idx vectors
            temp_l, temp_p, temp_r = zip(*[(node2idx.get(l, node2idx['<unk>']), path2idx.get(p, path2idx['<unk>']),
                                            node2idx.get(r, node2idx['<unk>'])) for l, p, r in body])

            # store idxs inside tensors
            tensor_lab[j] = temp_lab
            tensor_l[j, :] = torch.LongTensor(temp_l)
            tensor_p[j, :] = torch.LongTensor(temp_p)
            tensor_r[j, :] = torch.LongTensor(temp_r)

            # create masks
            mask[j, length:] = 0

        yield tensor_lab, tensor_l, tensor_p, tensor_r, mask
