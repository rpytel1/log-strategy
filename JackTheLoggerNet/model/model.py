import string

import torch
import torch.nn as nn
from torch.autograd import Variable
import torch.nn.functional as fn

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
        self.embedding = nn.Embedding(len(self.vocabulary), embedding_size)

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

        n = [X[i, n, :] for i, n in enumerate(list(lengths))]

        k = torch.cat(n).view(batch_size, -1)
        X = self.linear(k)
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

class Code2VecSingleNN(nn.Module):
	def __init__(self, inputSize=384, hiddenSize=128, outputSize=1, use_cuda=False):
		super(Code2VecSingleNN, self).__init__()
		
		self.use_cuda = use_cuda
		
        #384 input features (code2vec vector is 96*4), 128
		self.hidden = nn.Linear(inputSize, hiddenSize)
		self.output = nn.Linear(hiddenSize, outputSize)

        ##init weights
		self.w1 = torch.randn(inputSize, hiddenSize)
		self.w2 = torch.randn(hiddenSize, outputSize)

        ## initialize tensor for inputs, and outputs 
		self.x = torch.randn((1, inputSize))
		self.y = torch.randn((1, outputSize)) 
		self.b1 = torch.randn((1, hiddenSize)) # bias for hidden layer
		self.b2 = torch.randn((1, outputSize)) # bias for output layer
		
		if self.use_cuda and torch.cuda.is_available():
			self.w1 = self.w1.cuda()
			self.w2 = self.w2.cuda()
			self.x = self.x.cuda()
			self.y = self.y.cuda()
			self.b1 = self.b1.cuda()
			self.b2 = self.b2.cuda()
		
	
	
	def forward(self, x, lengths):
        ##activate hidden layer
		self.z1 = torch.matmul(x, self.w1) + self.b1
		self.a1 = fn.relu(self.z1)

        ##activate output
		self.z2 = torch.matmul(self.a1, self.w2) + self.b2
		output = fn.relu(self.z2)
        
		return output