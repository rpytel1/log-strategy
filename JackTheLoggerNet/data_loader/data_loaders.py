import string

import progressbar
import torch
from base import BaseDataLoader
from torch.utils.data.dataset import Dataset
import random
import numpy as np


class CodeCharDataLoader(BaseDataLoader):
    def __init__(self, filename, batch_size, shuffle=True, validation_split=0.0, num_workers=1, training=True):
        self.dataset = CodeCharDataset(filename)
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
        print(self.length, len(functions), len(self.labels))
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
            tensor[li] = self.all_letters.find(letter)
        return tensor, len(line) - 1

class Code2VecLoader(BaseDataLoader):
	def __init__(self, filename, relativeNrNoLogFunctions, shuffle=True, validation_split=0.0, num_workers=1):
		self.dataset = Code2VecDataset(filename, relativeNrNoLogFunctions)
		super().__init__(self.dataset, 1, shuffle, validation_split, num_workers)
	
class Code2VecData:
    funcname = ''
    label = -1
    vector = []
    def __init__(self):
        funcname = ''
        label = -1
        vector = []
		
class Code2VecDataset:

	def __init__(self, filename, relativeNrNoLogFunctions):
		self.inputDataslog = []
		self.inputDatasnolog = []
		self.balancedInputDatas = []
		self.logcount = 0
		
		self.readFile(filename)
		self.relativeNrNoLogFunctions = relativeNrNoLogFunctions
		random.shuffle(self.inputDatasnolog)
		for j in range(relativeNrNoLogFunctions * self.logcount):
			self.balancedInputDatas.append(self.inputDatasnolog[j])
			self.balancedInputDatas.append(self.inputDataslog[j])
		random.shuffle(self.balancedInputDatas)
		self.inputDataslog.clear()
		self.inputDatasnolog.clear()
		
	def __getitem__(self, index):
		return torch.tensor(self.balancedInputDatas[index].vector), self.balancedInputDatas[index].label, -1
		
	def __len__(self):
		return len(self.balancedInputDatas)
		
	#line to tensor?
	
	def readFile(self, filepath):
		inputData = Code2VecData()
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

					#reset
					del inputData
					inputData = Code2VecData()
					inputData.vector = []
				else:
					arr = np.array(l.split())
					inputData.vector.extend(arr.astype(np.float))


		
		
	