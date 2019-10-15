import pickle
import string

import torch
import torch.nn as nn
from torch.autograd import Variable
import torch.nn.functional as F
import numpy as np


class CodeRNN(nn.Module):
    def __init__(self, batch_size, output_size=2, nb_lstm_layers=1, nb_lstm_units=10, bidirectionality=False,
                 embedding_size=len(string.printable + " .,;'"),
                 use_cuda=False):
        super(CodeRNN, self).__init__()

        self.use_cuda = use_cuda
        self.nb_lstm_layers = nb_lstm_layers
        self.nb_lstm_units = nb_lstm_units
        self.batch_size = batch_size
        self.vocabulary = string.printable + " .,;'"

        ## +1 bc of unkown sign
        self.embedding = nn.Embedding(len(self.vocabulary) + 1, embedding_size)

        self.get_linear_input(bidirectionality)
        # design LSTM
        self.lstm = nn.LSTM(
            input_size=embedding_size,
            hidden_size=self.nb_lstm_units,
            num_layers=self.nb_lstm_layers,
            batch_first=True,
            bidirectional=bidirectionality
        )

        self.linear = nn.Linear(self.nb_lstm_units * self.linear_multiplier, 100)

        self.linear2 = nn.Linear(100, output_size)


    def get_linear_input(self, bidirectional):
        self.multiplier = self.nb_lstm_layers
        self.linear_multiplier = 1
        if bidirectional:
            self.multiplier *= 2
            self.linear_multiplier = 2

    def forward(self, X, lengths):
        total_length = X.shape[1]
        batch_size, seq_len = X.size()
        self.hidden = self.init_hidden(batch_size)
        X = self.embedding(X)

        torch.as_tensor(lengths, dtype=torch.int64)
        X = torch.nn.utils.rnn.pack_padded_sequence(X, lengths, batch_first=True, enforce_sorted=False)
        # now run through LSTM
        X, self.hidden = self.lstm(X, self.hidden)
        # undo the packing operation
        X, _ = torch.nn.utils.rnn.pad_packed_sequence(X, batch_first=True, total_length=total_length)

        n = [X[i, n, :] for i, n in enumerate(list(lengths))]

        k = torch.cat(n).view(batch_size, -1)
        X = F.relu(self.linear(k))
        X = self.linear2(X)

        Y_hat = X

        return Y_hat

    def init_hidden(self, batch_size):
        h0 = torch.zeros(self.multiplier, batch_size, self.nb_lstm_units)
        c0 = torch.zeros(self.multiplier, batch_size, self.nb_lstm_units)

        if self.use_cuda and torch.cuda.is_available():
            h0 = h0.cuda()
            c0 = c0.cuda()

        h0 = Variable(h0)
        c0 = Variable(c0)

        return (h0, c0)


class WordRNN(CodeRNN):
    CODE_DIR = "../result/"

    def __init__(self, batch_size, output_size=2, nb_lstm_layers=1, nb_lstm_units=10, bidirectionality=False,
                 embedding_size=10, use_cuda=False):
        super(CodeRNN, self).__init__()

        self.use_cuda = use_cuda
        self.nb_lstm_layers = nb_lstm_layers
        self.nb_lstm_units = nb_lstm_units
        self.batch_size = batch_size

        with open(self.CODE_DIR + 'vocabulary.pickle', 'rb') as handle:
            self.vocabulary = list(pickle.load(handle))

        ## +1 bc of unkown sign
        self.embedding = nn.Embedding(len(self.vocabulary) + 1, embedding_size)

        self.get_linear_input(bidirectionality)
        # design LSTM
        self.lstm = nn.LSTM(
            input_size=embedding_size,
            hidden_size=self.nb_lstm_units,
            num_layers=self.nb_lstm_layers,
            batch_first=True,
            bidirectional=bidirectionality
        )

        self.linear = nn.Linear(self.nb_lstm_units * self.linear_multiplier, 100)

        self.linear2 = nn.Linear(100, output_size)

        model_parameters = filter(lambda p: p.requires_grad, self.parameters())
        params = sum([np.prod(p.size()) for p in model_parameters])
        print(params)


class Code2VecSingleNN(nn.Module):
    def __init__(self, inputSize=384, hiddenSize=128, outputSize=2, use_cuda=False):
        super(Code2VecSingleNN, self).__init__()

        self.use_cuda = use_cuda

        # 384 input features (code2vec vector is 96*4), 128
        self.hidden = nn.Linear(inputSize, hiddenSize)
        self.output = nn.Linear(hiddenSize, outputSize)


    def forward(self, x, lengths):


        X = fn.relu(self.hidden(x))
        output = self.output(X)

        return output
