import pickle
import random
import string

import progressbar
import torch
from nltk import word_tokenize

from base import BaseDataLoader
from torch.utils.data.dataset import Dataset
import random
import numpy as np

from utils.code2vec_utils import numericalize, file_iterator


class CodeCharDataLoader(BaseDataLoader):
    def __init__(self, filename, batch_size, test_filename, shuffle=True, validation_split=0.0, num_workers=1,
                 training=True):
        self.dataset = CodeCharDataset(filename)
        super().__init__(self.dataset, batch_size, shuffle, validation_split, num_workers)


class CodeWordDataLoader(BaseDataLoader):
    def __init__(self, filename, batch_size, test_filename, shuffle=True, validation_split=0.0, num_workers=1,
                 training=True):
        self.dataset = CodeWordDataset(filename)
        super().__init__(self.dataset, batch_size, shuffle, validation_split, num_workers)


class CodeCharDataset(Dataset):
    CODE_DIR = "../result/"
    all_letters = string.printable + " .,;'"
    n_letters = len(all_letters)
    max_chars = 0

    def __init__(self, filename):
        self.data = []
        self.labels = []
        functions = []
        signature = ""
        d = open(self.CODE_DIR + filename, "r", encoding="utf-8")
        for ind, elem in enumerate(d):
            if ind % 3 == 0:
                signature = elem
            elif ind % 3 == 1:
                functions.append(signature + elem)
            else:
                self.labels.append(torch.tensor(int(elem)))

        self.length = min(len(functions), len(self.labels))
        self.max_chars = len(max(functions, key=len))

        print("Before one hot encoding")

        widgets = [progressbar.SimpleProgress(), ' ', progressbar.Bar(),
                   ' ', progressbar.ETA()]

        bar = progressbar.ProgressBar(widgets=widgets, maxval=len(functions)).start()
        for ind, elem in enumerate(functions):
            self.data.append(self.line_to_tensor(elem))
            bar.update(ind)
        bar.finish()

    def __getitem__(self, index):
        return self.data[index][0], self.labels[index], self.data[index][1]

    def __len__(self):
        return self.length

    def line_to_tensor(self, line):
        tensor = torch.zeros(self.max_chars, dtype=torch.long)
        for li, letter in enumerate(line):
            tensor[li] = self.all_letters.find(letter) + 1
        return tensor, torch.tensor(len(line) - 1)


class CodeWordDataset(Dataset):
    CODE_DIR = "../result/"
    max_chars = 0
    word_dict = []

    def __init__(self, filename):
        self.data = []
        self.labels = []

        with open(self.CODE_DIR + 'vocabulary.pickle', 'rb') as handle:
            self.vocabulary = list(pickle.load(handle))

        functions = []
        lengths = []

        signature = ""
        d = open(self.CODE_DIR + filename, "r", encoding="utf-8")
        for ind, elem in enumerate(d):
            if ind % 3 == 0:
                signature = elem
            elif ind % 3 == 1:
                functions.append(signature + elem)
                lengths.append(len(word_tokenize(signature + elem)))

            else:
                self.labels.append(torch.tensor(int(elem)))

        self.length = min(len(functions), len(self.labels))

        self.max_chars = max(lengths)

        print("Before one hot encoding")

        widgets = [progressbar.SimpleProgress(), ' ', progressbar.Bar(),
                   ' ', progressbar.ETA()]

        bar = progressbar.ProgressBar(widgets=widgets, maxval=len(functions)).start()
        for ind, elem in enumerate(functions):
            self.data.append(self.line_to_tensor(elem))
            bar.update(ind)
        bar.finish()

    def __getitem__(self, index):
        return self.data[index][0], self.labels[index], self.data[index][1]

    def __len__(self):
        return self.length

    def line_to_tensor(self, line):
        tensor = torch.zeros(self.max_chars, dtype=torch.long)
        words = word_tokenize(line)
        for li, word in enumerate(words):
            tensor[li] = self.get_index(word) + 1
        return tensor, torch.tensor(len(words) - 1)

    def get_index(self, word):
        if word in self.vocabulary:
            return self.vocabulary.index(word)
        return -1


class Code2VecDataLoader(BaseDataLoader):
    def __init__(self, filename, batch_size, test_filename, shuffle=True, validation_split=0.0, num_workers=1,
                 training=True):
        self.dataset = Code2VecDataset(filename)
        super().__init__(self.dataset, batch_size, shuffle, validation_split, num_workers)


class Code2VecDataset(Dataset):
    DATA_DIR = 'data'
    DATASET = 'preprocessed_code'
    EMBEDDING_DIM = 128
    DROPOUT = 0.25
    BATCH_SIZE = 1024
    CHUNKS = 10
    MAX_LENGTH = 200

    def __init__(self, filename):

        with open(f'{self.DATA_DIR}/preprocessed_code/{self.DATASET}.dict.c2v', 'rb') as file:
            node2count = pickle.load(file)

            path2count = pickle.load(file)

            target2count = pickle.load(file)

            n_training_examples = pickle.load(file)

        # create vocabularies, initialized with unk and pad tokens

        node2idx = {'<unk>': 0, '<pad>': 1}
        path2idx = {'<unk>': 0, '<pad>': 1}
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

        print("Node dim: " + str(len(node2idx)))
        print("Path dim: " + str(len(path2idx)))
        print("Target dim: " + str(len(target2idx)))

        ###########################################
        examples = []
        self.data = []
        self.labels = []

        for example_name, example_body, example_length in file_iterator(
                f'{self.DATA_DIR}/{self.DATASET}/{filename}', self.MAX_LENGTH):

            examples.append((example_name, example_body, example_length))
            if len(examples) >= (self.BATCH_SIZE * self.CHUNKS):

                random.shuffle(examples)

                # tensor_lab is a
                for tensor_lab, tensor_l, tensor_p, tensor_r, mask in numericalize(examples, self.CHUNKS,
                                                                                   self.BATCH_SIZE, self.MAX_LENGTH,
                                                                                   node2idx, path2idx, target2idx):
                    for i in range(self.BATCH_SIZE):
                        self.data.append((tensor_l[i], tensor_p[i], tensor_r[i]))
                        self.labels.append(tensor_lab[i])

                examples = []

    def __getitem__(self, index):
        return self.data[index], self.labels[index], "CODE2VEC"

    def __len__(self):
        return len(self.data)


class Code2VecPreLoader(BaseDataLoader):
    def __init__(self, filename, batch_size, test_filename, relativeNrNoLogFunctions=1, shuffle=True,
                 validation_split=0.0, num_workers=1, training=True):
        self.dataset = Code2VecPreDataset(filename, relativeNrNoLogFunctions, training)
        super().__init__(self.dataset, batch_size, shuffle, validation_split, num_workers)


class Code2VecPreData:
    funcname = ''
    label = -1
    vector = []

    def __init__(self):
        funcname = ''
        label = -1
        vector = []


class Code2VecPreDataset:
    def __init__(self, filename, relativeNrNoLogFunctions, training):
        self.inputDataslog = []
        self.inputDatasnolog = []
        self.balancedInputDatas = []
        self.logcount = 0

        self.readFile(filename)
        self.relativeNrNoLogFunctions = relativeNrNoLogFunctions
        random.shuffle(self.inputDatasnolog)
        if (training):
            for j in range(relativeNrNoLogFunctions * self.logcount):
                self.balancedInputDatas.append(self.inputDatasnolog[j])
                if (j < self.logcount):
                    self.balancedInputDatas.append(self.inputDataslog[j])
            random.shuffle(self.balancedInputDatas)
        else:
            self.balancedInputDatas.extend(self.inputDatasnolog)
            self.balancedInputDatas.extend(self.inputDataslog)
        self.inputDataslog.clear()
        self.inputDatasnolog.clear()

    def __getitem__(self, index):
        return torch.tensor(self.balancedInputDatas[index].vector), self.balancedInputDatas[index].label, -1

    def __len__(self):
        return len(self.balancedInputDatas)

    def readFile(self, filepath):
        inputData = Code2VecPreData()
        inputData.vector = []
        f = open(filepath)
        lines = f.readlines()
        f.close()

        counter = 0

        for l in lines:
            if (counter == 0):
                inputData.funcname = l
                counter += 1
            elif (counter == 1):
                inputData.label = int(l)
                counter += 1
            elif (counter == 2):
                l = l[1:]
                arr = np.array(l.split())
                inputData.vector.extend(arr.astype(np.float))
                counter += 1
            elif (counter == 3):
                if (l[-2] == ']'):
                    counter = 0
                    l = l[:-2]
                    arr = np.array(l.split())
                    inputData.vector.extend(arr.astype(np.float))

                    if (inputData.label == 0):
                        self.inputDatasnolog.append(inputData)

                    else:
                        self.logcount += 1
                        self.inputDataslog.append(inputData)

                    # reset
                    del inputData
                    inputData = Code2VecPreData()
                    inputData.vector = []
                else:
                    arr = np.array(l.split())
                    inputData.vector.extend(arr.astype(np.float))
