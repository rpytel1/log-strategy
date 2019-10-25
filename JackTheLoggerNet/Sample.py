import re
import numpy as np


class Sample:
    @staticmethod
    def extract_name(data: [str]) -> str:
        line = data[0]
        if '[' in line or ']' in line:
            raise ValueError("Can't extract name from:", data)
        return line

    @staticmethod
    def extract_codevector(data: [str]) -> [[float]]:
        tmp = ""
        reading = False
        for id, line in enumerate(data):
            if '[' in line:
                tmp = line
                reading = True
            elif ']' in line and reading:
                tmp += line
                rawVector = re.sub(r'\[|\|\n]', '', tmp)
                return np.fromstring(rawVector, np.float32, sep=' ').tolist()
            elif reading:
                tmp += line
        raise ValueError("Can't extract code vector from:", data)

    @staticmethod
    def extract_label(data: [str]) -> int:
        for id, line in enumerate(data):
            if len(line) <= 2:
                label = int(line)
                if label == 0 or label == 1:
                    return label
        raise ValueError("No label found in:", data)

    def __init__(self, rawData: [str]):
        self.name = Sample.extract_name(rawData)
        self.label = Sample.extract_label(rawData)
        self.codeVector = Sample.extract_codevector(rawData)
        if not self.valid_sample():
            raise ValueError("Invalid input:", rawData)

    def __init__(self, name, label, codevector):
        self.name = name
        self.label = int(label)
        self.codeVector = codevector
        if not self.valid_sample():
            raise ValueError("Invalid input:", str(self))

    def valid_sample(self) -> bool:
        return len(self.codeVector) == 128 and (self.label == 0 or self.label == 1) and len(self.name) > 3

    def __str__(self):
        return '\n'.join([self.name, str(self.label), np.array2string(np.asarray(self.codeVector))]) + '\n'
