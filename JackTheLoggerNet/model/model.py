import torch
import torch.nn as nn
from torch.autograd import Variable


class CodeRNN(nn.Module):
    def __init__(self, n_features, batch_size, output_size=2, use_cuda=False):
        super(CodeRNN, self).__init__()

        self.use_cuda = use_cuda
        self.nb_lstm_layers = 1
        self.nb_lstm_units = 512
        self.n_features = n_features
        self.batch_size = batch_size

        # design LSTM
        self.lstm = nn.LSTM(
            input_size=self.n_features,
            hidden_size=self.nb_lstm_units,
            num_layers=self.nb_lstm_layers,
            batch_first=True
        )
        self.linear = nn.Linear(self.nb_lstm_units, output_size)

    def forward(self, X, lengths):
        batch_size, seq_len, _ = X.size()
        self.hidden = self.init_hidden(batch_size)

        total_length = X.shape[1]

        X = torch.nn.utils.rnn.pack_padded_sequence(X, lengths, batch_first=True, enforce_sorted=False)
        # now run through LSTM
        X, self.hidden = self.lstm(X, self.hidden)
        # undo the packing operation
        X, _ = torch.nn.utils.rnn.pad_packed_sequence(X, batch_first=True, total_length=total_length)

        n = [X[i, n, :]for i, n in enumerate(list(lengths))]

        k = torch.cat(n).view(batch_size,-1)
        X = self.linear(k)
        Y_hat = X

        return Y_hat

    def init_hidden(self, batch_size):
        h0 = torch.zeros(self.nb_lstm_layers, batch_size, self.nb_lstm_units)
        c0 = torch.zeros(self.nb_lstm_layers, batch_size, self.nb_lstm_units)

        if self.use_cuda and torch.cuda.is_available():
            h0 = h0.cuda()
            c0 = c0.cuda()

        h0 = Variable(h0)
        c0 = Variable(c0)

        return (h0, c0)
