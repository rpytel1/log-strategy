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

    def __init__(self, filename):
        d = self.readLocalFile(filename)
        self.data = []
        self.labels = []

        for ind, elem in enumerate(d):
            if ind % 2 == 0:
                self.data.append(elem)
            else:
                self.labels.append(elem)

    def __getitem__(self, index):
        return self.data[index], self.labels[index]

    def __len__(self):
        return len(self.data)



    def readLocalFile(self, filename):
        # TODO: repair later to accomodate multiple names from config file
        with open(self.CODE_DIR + "beam_filteredRNN.txt", 'rb') as f:
            d = f.read()
        return d

