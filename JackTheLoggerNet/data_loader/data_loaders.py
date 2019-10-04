import string

import progressbar
import torch
from base import BaseDataLoader
from torch.utils.data.dataset import Dataset


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
