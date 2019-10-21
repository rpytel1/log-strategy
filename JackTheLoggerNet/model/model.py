import pickle
import string

import torch
import torch.nn as nn
from torch.autograd import Variable
import torch.nn.functional as F
import numpy as np


class TestRNN(nn.Module):
    def __init__(self, batch_size, output_size=2, nb_lstm_layers=1, nb_lstm_units=20, bidirectionality=False,
                 embedding_size=len(string.printable + " .,;'"),
                 use_cuda=False):
        super(TestRNN, self).__init__()

        self.use_cuda = use_cuda
        self.nb_lstm_layers = nb_lstm_layers
        self.nb_lstm_units = nb_lstm_units
        self.batch_size = batch_size
        self.vocabulary = string.printable + " .,;'"
        self.do = nn.Dropout(0.25)

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

        self.linear = nn.Linear(self.nb_lstm_units * self.linear_multiplier, output_size)

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

        X = torch.nn.utils.rnn.pack_padded_sequence(X, lengths, batch_first=True, enforce_sorted=False)
        # now run through LSTM
        X, self.hidden = self.lstm(X, self.hidden)
        # undo the packing operation
        X, _ = torch.nn.utils.rnn.pad_packed_sequence(X, batch_first=True, total_length=total_length)
        idx = (torch.LongTensor(lengths) - 1).view(-1, 1).expand(
            len(lengths), X.size(2))

        time_dimension = 1
        idx = idx.unsqueeze(time_dimension)
        # Shape: (batch_size, rnn_hidden_dim)
        X = X.gather(
            time_dimension, Variable(idx)).squeeze(time_dimension)
        X = self.do(X)
        X = self.linear(X)

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


class CodeRNN(nn.Module):
    def __init__(self, batch_size, output_size=2, nb_lstm_layers=1, nb_lstm_units=20, bidirectionality=False,
                 embedding_size=len(string.printable + " .,;'"),
                 use_cuda=False):
        super(CodeRNN, self).__init__()

        self.use_cuda = use_cuda
        self.nb_lstm_layers = nb_lstm_layers
        self.nb_lstm_units = nb_lstm_units
        self.batch_size = batch_size
        self.vocabulary = string.printable + " .,;'"
        self.do = nn.Dropout(0.25)

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

        self.linear = nn.Linear(self.nb_lstm_units * self.linear_multiplier, output_size)

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

        idx = (torch.LongTensor(lengths) - 1).view(-1, 1).expand(
            len(lengths), X.size(2))

        time_dimension = 1
        idx = idx.unsqueeze(time_dimension)
        # Shape: (batch_size, rnn_hidden_dim)
        X = X.gather(
            time_dimension, Variable(idx)).squeeze(time_dimension)
        X = self.do(X)
        X = self.linear(X)

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
        self.do = nn.Dropout(0.2)

        self.linear = nn.Linear(self.nb_lstm_units * self.linear_multiplier, output_size)


class Code2VecSingleNN(nn.Module):
    def __init__(self, inputSize=384, hiddenSize=128, outputSize=2, use_cuda=False):
        super(Code2VecSingleNN, self).__init__()

        self.use_cuda = use_cuda

        # 384 input features (code2vec vector is 96*4), 128
        self.hidden = nn.Linear(inputSize, hiddenSize)
        self.output = nn.Linear(hiddenSize, outputSize)

    def forward(self, x, lengths):
        X = F.relu(self.hidden(x))
        output = self.output(X)

        return output


class Code2Vec(nn.Module):
    def __init__(self, nodes_dim, paths_dim, embedding_dim, output_dim, dropout):
        super().__init__()

        self.node_embedding = nn.Embedding(nodes_dim, embedding_dim)
        self.path_embedding = nn.Embedding(paths_dim, embedding_dim)
        self.W = nn.Parameter(torch.randn(1, embedding_dim, 3 * embedding_dim))
        self.a = nn.Parameter(torch.randn(1, embedding_dim, 1))
        self.out = nn.Linear(embedding_dim, output_dim)
        self.do = nn.Dropout(dropout)

        # Show how many parameters
        model_parameters = filter(lambda p: p.requires_grad, self.parameters())
        params = sum([np.prod(p.size()) for p in model_parameters])
        print(params)

    def forward(self, X, lengths):
        starts, paths, ends = X

        # starts = paths = ends = [batch size, max length]

        W = self.W.repeat(starts.shape[0], 1, 1)

        # W = [batch size, embedding dim, embedding dim * 3]
        embedded_starts = self.node_embedding(starts)
        embedded_paths = self.path_embedding(paths)
        embedded_ends = self.node_embedding(ends)

        # embedded_* = [batch size, max length, embedding dim]

        c = self.do(torch.cat((embedded_starts, embedded_paths, embedded_ends), dim=2))

        # c = [batch size, max length, embedding dim * 3]

        c = c.permute(0, 2, 1)

        # c = [batch size, embedding dim * 3, max length]

        x = torch.tanh(torch.bmm(W, c))

        # x = [batch size, embedding dim, max length]

        x = x.permute(0, 2, 1)

        # x = [batch size, max length, embedding dim]

        a = self.a.repeat(starts.shape[0], 1, 1)

        # a = [batch size, embedding dim, 1]

        z = torch.bmm(x, a).squeeze(2)

        # z = [batch size, max length]

        z = F.softmax(z, dim=1)

        # z = [batch size, max length]

        z = z.unsqueeze(2)

        # z = [batch size, max length, 1]

        x = x.permute(0, 2, 1)

        # x = [batch size, embedding dim, max length]

        v = torch.bmm(x, z).squeeze(2)

        # v = F.softmax(v)

        # v = [batch size, embedding dim]

        out = self.out(v)

        # out = [batch size, output dim]

        return out
