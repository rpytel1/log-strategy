import string
import torch
from torchvision import datasets, transforms
from base import BaseDataLoader
from torch.utils.data.dataset import Dataset


class MnistDataLoader(BaseDataLoader):
    """
    MNIST data loading demo using BaseDataLoader
    """

    def __init__(self, data_dir, batch_size, shuffle=True, validation_split=0.0, num_workers=1, training=True):
        trsfm = transforms.Compose([
            transforms.ToTensor(),
            transforms.Normalize((0.1307,), (0.3081,))
        ])
        self.data_dir = data_dir
        self.dataset = datasets.MNIST(self.data_dir, train=training, download=True, transform=trsfm)
        super().__init__(self.dataset, batch_size, shuffle, validation_split, num_workers)


class CodeDataLoader(BaseDataLoader):
    def __init__(self, filename, batch_size, shuffle=True, validation_split=0.0, num_workers=1, training=True):
        self.dataset = CodeDataset(filename)
        super().__init__(self.dataset, batch_size, shuffle, validation_split, num_workers)


class CodeDataset(Dataset):
    CODE_DIR = "./data/"
    all_letters = string.ascii_letters + " .,;'"
    n_letters = len(all_letters)

    def __init__(self, filename):
        d = self.read_local_file(filename)
        self.data = []
        self.labels = []
        signature = ""
        d = open(self.CODE_DIR + "beam_filteredRNN.txt", "r", encoding="utf-8")
        for ind, elem in enumerate(d):
            if ind % 3 == 0:
                signature = elem
            elif ind % 3 == 1:
                self.data.append(self.line_to_tensor(signature + elem))
            else:
                self.labels.append(torch.tensor(int(elem)))

    def __getitem__(self, index):
        print("__getitem__")
        print(self.data[index])
        print(self.labels[index])
        return self.letter_to_tensor(self.data[index]), torch.tensor(self.labels[index])

    def __len__(self):
        return len(self.data)

    def read_local_file(self, filename):
        # TODO: repair later to accomodate multiple names from config file
        with open(self.CODE_DIR + "beam_filteredRNN.txt", 'rb') as f:
            d = f.readline()
        return d

    def letter_to_index(self, letter):
        return self.all_letters.find(letter)

    # Just for demonstration, turn a letter into a <1 x n_letters> Tensor
    def letter_to_tensor(self, letter):
        tensor = torch.zeros(1, self.n_letters)
        tensor[0][self.letter_to_index(letter)] = 1
        return tensor

    # Turn a line into a <line_length x 1 x n_letters>,
    # or an array of one-hot letter vectors
    def line_to_tensor(self, line):
        tensor = torch.zeros(len(line), 1, self.n_letters)
        for li, letter in enumerate(line):
            tensor[li][0][self.letter_to_index(letter)] = 1
        return tensor
