#imort functionality
import torch
import torch.optim as optim
import torch.nn as nn
import torch.nn.functional as F

import os
import random 
import pickle

import models
from DataLoader import *
from BatchDivider import *

import sys
# setup parameters

print(torch.cuda.device_count())
print(torch.cuda.current_device())

SEED = 1234
DATA_DIR = 'data'
DATASET = 'preprocessed_code'
EMBEDDING_DIM = 128
DROPOUT = 0.25
BATCH_SIZE = 1024
CHUNKS = 10
MAX_LENGTH = 200
LOG_EVERY = 100 #print log of results after every LOG_EVERY batches
N_EPOCHS = 5
LOG_DIR = 'logs'
SAVE_DIR = 'checkpoints'
LOG_PATH = os.path.join(LOG_DIR, f'{DATASET}-log.txt')
MODEL_SAVE_PATH = os.path.join(SAVE_DIR, f'{DATASET}-model.pt')
LOAD = False #set true if you want to load model from MODEL_SAVE_PATH
printBatch = False
printName = False
printTemp = False
printMask = False
# set random seeds for reproducability

random.seed(SEED)
torch.manual_seed(SEED)
torch.cuda.manual_seed(SEED)
torch.backends.cudnn.deterministic = True

def calculate_accuracy(fx, y):
    """
    Calculate top-1 accuracy

    fx = [batch size, output dim]
     y = [batch size]
    """
    pred_idxs = fx.max(1, keepdim=True)[1]
    correct = pred_idxs.eq(y.view_as(pred_idxs)).sum()
    acc = correct.float()/pred_idxs.shape[0]
    return acc


def calculate_f1(fx, y):
    """
    Calculate precision, recall and F1 score
    - Takes top-1 predictions
    - Converts to strings
    - Splits into sub-tokens
    - Calculates TP, FP and FN
    - Calculates precision, recall and F1 score

    fx = [batch size, output dim]
    fx = [batch size, output dim]
     y = [batch size]
    """
    pred_idxs = fx.max(1, keepdim=True)[1]

    pred_labels = [idx2target[i.item()] for i in pred_idxs]

    original_labels = [idx2target[i.item()] for i in y]
    cnt = 0
    true_positive, false_positive, true_negative, false_negative = 0, 0, 0, 0
    for p, o in zip(pred_labels, original_labels):
        print (fx[cnt])
        print("p = " + p + "; o = " + o)
        cnt=cnt+1;
        if p==o:
            if p=='1':
                true_positive += 1
                #print("true positive")
            else:
                true_negative += 1
                #print("true negative")
        else:
            if p == '1':
                false_positive += 1
                #print("false positive")
            else:
                false_negative += 1
                #print("false negative")
    try:
        print("true_positives: " + str(true_positive) + "; false_positive: " + str(false_positive))
        print("true_negative: " + str(true_negative) + "; false_negative: " + str(false_negative) )
        precision = true_positive / (true_positive + false_positive)
        recall = true_positive / (true_positive + false_negative)
        f1 = 2 * precision * recall / (precision + recall)
    except ZeroDivisionError:
        precision, recall, f1 = 0, 0, 0
    return precision, recall, f1

def get_metrics(tensor_n, tensor_l, tensor_p, tensor_r, model, criterion, optimizer=None):
    """
    Takes inputs, calculates loss, accuracy and other metrics, then calculates gradients and updates parameters

    if optimizer is None, then we are doing evaluation so no gradients are calculated and no parameters are updated
    """

    if optimizer is not None:
        optimizer.zero_grad()

    ##the output layer
    BatchOut = model(tensor_l, tensor_p, tensor_r)

    loss = criterion(BatchOut, tensor_n)

    acc = calculate_accuracy(BatchOut, tensor_n)
    precision, recall, f1 = calculate_f1(BatchOut, tensor_n)
    torch.cuda.empty_cache()
    if optimizer is not None:
        torch.cuda.empty_cache()
        loss.backward()
        torch.cuda.empty_cache()
        optimizer.step()

    return loss.item(), acc.item(), precision, recall, f1

def train(model, file_path, optimizer, criterion):
    """
    Training loop for the model
    Dataset is too large to fit in memory, so we stream it
    Get BATCH_SIZE * CHUNKS examples at a time (default = 1024 * 10 = 10,240)
    Shuffle the BATCH_SIZE * CHUNKS examples
    Convert raw string examples into numericalized tensors
    Get metrics and update model parameters

    Once we near end of file, may have less than BATCH_SIZE * CHUNKS examples left, but still want to use
    So we calculate number of remaining whole batches (len(examples)//BATCH_SIZE) then do that many updates
    """

    n_batches = 0

    epoch_loss = 0
    epoch_acc = 0
    epoch_r = 0
    epoch_p = 0
    epoch_f1 = 0

    model.train()

    examples = []

    #get every function_name, functions_tree, and function_length frome preprocessed c2v file
    for example_name, example_body, example_length in file_iterator(file_path, MAX_LENGTH):

        examples.append((example_name, example_body, example_length))

        if len(examples) >= (BATCH_SIZE * CHUNKS):

            random.shuffle(examples)

            #tensor_lab is a
            for tensor_lab, tensor_l, tensor_p, tensor_r, mask in numericalize(examples, CHUNKS,BATCH_SIZE,MAX_LENGTH,node2idx,path2idx,target2idx):

                #place on gpu

                tensor_lab = tensor_lab.to(device)
                tensor_l = tensor_l.to(device)
                tensor_p = tensor_p.to(device)
                tensor_r = tensor_r.to(device)

                #put into model
                loss, acc, p, r, f1 = get_metrics(tensor_lab, tensor_l, tensor_p, tensor_r, model, criterion, optimizer)

                epoch_loss += loss
                epoch_acc += acc
                epoch_p += p
                epoch_r += r
                epoch_f1 += f1

                n_batches += 1

                if n_batches % LOG_EVERY == 0:

                    loss = epoch_loss / n_batches
                    acc = epoch_acc / n_batches
                    precision = epoch_p / n_batches
                    recall = epoch_r / n_batches
                    f1 = epoch_f1 / n_batches

                    log = f'\t| Batches: {n_batches} | Completion: {((n_batches*BATCH_SIZE)/n_training_examples)*100:03.3f}% |\n'
                    log += f'\t| Loss: {loss:02.3f} | Acc.: {acc:.3f} | P: {precision:.3f} | R: {recall:.3f} | F1: {f1:.3f}'
                    with open(LOG_PATH, 'a+') as f:
                        f.write(log+'\n')
                    print(log)
            examples = []

        else:
            pass

    #outside of `file_iterator`, but will probably still have some examples left over
    random.shuffle(examples)

    #get amount of batches we have left
    n = len(examples)//BATCH_SIZE

    #train with remaining batches
    for tensor_lab, tensor_l, tensor_p, tensor_r, mask in numericalize(examples, n,BATCH_SIZE,MAX_LENGTH,node2idx,path2idx,target2idx):

        #place on gpu

        tensor_lab = tensor_lab.to(device)
        tensor_l = tensor_l.to(device)
        tensor_p = tensor_p.to(device)
        tensor_r = tensor_r.to(device)

        #put into model

        loss, acc, p, r, f1 = get_metrics(tensor_lab, tensor_l, tensor_p, tensor_r, model, criterion, optimizer)

        epoch_loss += loss
        epoch_acc += acc
        epoch_p += p
        epoch_r += r
        epoch_f1 += f1

        n_batches += 1

    return epoch_loss / n_batches, epoch_acc / n_batches, epoch_p / n_batches, epoch_r / n_batches, epoch_f1 / n_batches

def evaluate(model, file_path, criterion):
    """
    Similar to training loop, but we do not pass optimizer to get_metrics
    Also wrap get_metrics in `torch.no_grad` to avoid calculating gradients
    """

    n_batches = 0

    epoch_loss = 0
    epoch_acc = 0
    epoch_r = 0
    epoch_p = 0
    epoch_f1 = 0

    model.eval()

    examples = []

    for example_name, example_body, example_length in file_iterator(file_path,MAX_LENGTH):

        examples.append((example_name, example_body, example_length))

        if len(examples) >= (BATCH_SIZE * CHUNKS):

            random.shuffle(examples)

            for tensor_n, tensor_l, tensor_p, tensor_r, mask in numericalize(examples, CHUNKS,BATCH_SIZE,MAX_LENGTH,node2idx,path2idx,target2idx):

                #place on gpu

                tensor_n = tensor_n.to(device)
                tensor_l = tensor_l.to(device)
                tensor_p = tensor_p.to(device)
                tensor_r = tensor_r.to(device)

                #put into model
                with torch.no_grad():
                    loss, acc, p, r, f1 = get_metrics(tensor_n, tensor_l, tensor_p, tensor_r, model, criterion)

                epoch_loss += loss
                epoch_acc += acc
                epoch_p += p
                epoch_r += r
                epoch_f1 += f1

                n_batches += 1

                if n_batches % LOG_EVERY == 0:

                    loss = epoch_loss / n_batches
                    acc = epoch_acc / n_batches
                    precision = epoch_p / n_batches
                    recall = epoch_r / n_batches
                    f1 = epoch_f1 / n_batches

                    log = f'\t| Batches: {n_batches} |\n'
                    log += f'\t| Loss: {loss:02.3f} | Acc.: {acc:.3f} | P: {precision:.3f} | R: {recall:.3f} | F1: {f1:.3f}'
                    with open(LOG_PATH, 'a+') as f:
                        f.write(log+'\n')
                    print(log)

            examples = []

        else:
            pass

    #outside of for line in f, but will still have some examples left over

    random.shuffle(examples)

    n = len(examples)//BATCH_SIZE

    for tensor_n, tensor_l, tensor_p, tensor_r, mask in numericalize(examples, n,BATCH_SIZE,MAX_LENGTH,node2idx,path2idx,target2idx):

        #place on gpu

        tensor_n = tensor_n.to(device)
        tensor_l = tensor_l.to(device)
        tensor_p = tensor_p.to(device)
        tensor_r = tensor_r.to(device)

        #put into model
        with torch.no_grad():
            loss, acc, p, r, f1 = get_metrics(tensor_n, tensor_l, tensor_p, tensor_r, model, criterion)

        epoch_loss += loss
        epoch_acc += acc
        epoch_p += p
        epoch_r += r
        epoch_f1 += f1

        n_batches += 1

    return epoch_loss / n_batches, epoch_acc / n_batches, epoch_p / n_batches, epoch_r / n_batches, epoch_f1 / n_batches

#load counts of each token in dataset
os.environ['CUDA_VISIBLE_DEVICES'] = '2'
with open(f'{DATASET}.dict.c2v', 'rb') as file:
    node2count = pickle.load(file)

    path2count = pickle.load(file)

    target2count = pickle.load(file)

    n_training_examples = pickle.load(file)

# create vocabularies, initialized with unk and pad tokens

node2idx = {'<unk>': 0, '<pad>': 1}
path2idx = {'<unk>': 0, '<pad>': 1 }
target2idx = {'0': 0, '1': 1}

idx2word = {}
idx2path = {}
idx2target = {}

for w in node2count.keys():
    node2idx[w] = len(node2idx)

for k, v in node2idx.items():
    idx2word[v] = k

for p in path2count.keys():
    path2idx[p] = len(path2idx)
    
for k, v in path2idx.items():
    idx2path[v] = k
    
for t in target2count.keys():
    target2idx[t] = len(target2idx)
    
for k, v in target2idx.items():
    idx2target[v] = k


model = models.Code2Vec(len(node2idx), len(path2idx), EMBEDDING_DIM, len(target2idx), DROPOUT)

if LOAD:
    print(f'Loading model from {MODEL_SAVE_PATH}')
    model.load_state_dict(torch.load(MODEL_SAVE_PATH))

optimizer = optim.Adam(model.parameters())

criterion = nn.CrossEntropyLoss()

device = torch.device('cuda:0')

model = model.to(device)
criterion = criterion.to(device)



best_valid_loss = float('inf')

if not os.path.isdir(f'{SAVE_DIR}'):
    os.makedirs(f'{SAVE_DIR}')

if not os.path.isdir(f'{LOG_DIR}'):
    os.makedirs(f'{LOG_DIR}')

if os.path.exists(LOG_PATH):
    os.remove(LOG_PATH)

for epoch in range(N_EPOCHS):
    torch.cuda.empty_cache()
    log = f'Epoch: {epoch+1:02} - Training'
    with open(LOG_PATH, 'a+') as f:
        f.write(log+'\n')
    torch.cuda.empty_cache()
    train_loss, train_acc, train_p, train_r, train_f1 = train(model, f'{DATA_DIR}/{DATASET}/{DATASET}.train.c2v', optimizer, criterion)

    log = f'Epoch: {epoch+1:02} - Validation'
    with open(LOG_PATH, 'a+') as f:
        f.write(log+'\n')

    
    valid_loss, valid_acc, valid_p, valid_r, valid_f1 = evaluate(model, f'{DATA_DIR}/{DATASET}/{DATASET}.val.c2v', criterion)
    
    if valid_loss < best_valid_loss:
        best_valid_loss = valid_loss
        torch.save(model.state_dict(), MODEL_SAVE_PATH)
    
    log = f'| Epoch: {epoch+1:02} |\n'
    log += f'| Train Loss: {train_loss:.3f} | Train Precision: {train_p:.3f} | Train Recall: {train_r:.3f} | Train F1: {train_f1:.3f} | Train Acc: {train_acc*100:.2f}% |\n'
    log += f'| Val. Loss: {valid_loss:.3f} | Val. Precision: {valid_p:.3f} | Val. Recall: {valid_r:.3f} | Val. F1: {valid_f1:.3f} | Val. Acc: {valid_acc*100:.2f}% |'
    with open(LOG_PATH, 'a+') as f:
        f.write(log+'\n')

log = 'Testing'
with open(LOG_PATH, 'a+') as f:
    f.write(log+'\n')

model.load_state_dict(torch.load(MODEL_SAVE_PATH))

test_loss, test_acc, test_p, test_r, test_f1 = evaluate(model, f'{DATASET}/{DATASET}/{DATASET}.test.c2v', criterion)

log = f'| Test Loss: {test_loss:.3f} | Test Precision: {test_p:.3f} | Test Recall: {test_r:.3f} | Test F1: {test_f1:.3f} | Test Acc: {test_acc*100:.2f}% |'
with open(LOG_PATH, 'a+') as f:
    f.write(log+'\n')
