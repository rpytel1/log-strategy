import os
from DataElem import DataElem
import re
import warnings


def readInput(path: str):
    file = open(path, "r", encoding='utf-8')
    lines = file.readlines()
    file.close()

    print("Found and red " + str(int(len(lines) / 2)) + ' methods in ' + path + '.')
    return lines


def extractLabel(signature: str):
    splitSignature = signature.split('_')
    functionName = splitSignature[len(splitSignature) - 1]
    logPattern = re.compile(r'[^0|1].*')

    return re.sub(logPattern, '', functionName)


def extractFunctionId(signature: str):
    splitSignature = signature.split('_')
    return splitSignature[len(splitSignature) - 2]


def extractFunctionName(signature: str):
    pattern = re.compile(r'( [^\( ]+\()')
    cleanedSignature = re.sub(r'\(', '', str(re.findall(pattern, signature)))
    splitSignature = cleanedSignature.split(' ')
    functionName = splitSignature[(len(splitSignature) - 1)]

    return ''.join(functionName[: (len(functionName) - 2)])

# CURRENT VERSION IS RANDOM SAMPLING
# Read data to the DataElem structure
def processInput(input: str):
    data = []
    signature = ""

    for id, line in enumerate(readInput(input)):
        line.replace('\n', ' ').replace('\r', '')
        if id % 2 == 0:
            signature = line
        elif id % 2 == 1:
            function_name = extractFunctionName(signature)
            body = line
            if body.strip() != "{}":
                methodDescription = DataElem(function_name, signature, body, extractFunctionId(signature), extractLabel(signature))
                data.append(methodDescription)
            else:
                warnings.WarningMessage("Found an empty body for method: " + function_name, category=ImportWarning, filename=DataElem, lineno=0)

    print("Processed " + str(len(data)) + ' methods.')
    return data

def createDirectories():
    if not os.path.isdir("train"):
        os.mkdir("train")
        print('Created output directory at: ' + os.path.abspath("train"))

def writeInput(data, name):
    createDirectories()

    f_train_file_counter = 0
    f_train_counter = 0
    write_buffer = ""
    
    for id, elem in enumerate(data):
        if f_train_counter > 1000:
            f_train_features = open("train/train" + name + str(f_train_file_counter) + ".java", "w", encoding="utf-8")
            f_train_features.write(write_buffer)
            f_train_features.close()
            write_buffer = ""
            f_train_file_counter += 1
            f_train_counter = 0
        f_train_counter += 1
        write_buffer += elem.getJavaRepresentation()

    print('Wrote ' + str(len(data)) + ' methods to disk.')
    f_train_features.close()

# pipeline
def preprocess():
    for (dirpath, dirnames, filenames) in os.walk("../result/filteredCode2Vec"):
        for filename in filenames:
            data = processInput(dirpath + "/" + filename)
            writeInput(data, filename)


# RUN PREPROCESS
preprocess()
