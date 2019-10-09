import os
import subprocess
from DataElem import DataElem
import re
import warnings


CODE2VEC_PATH = "../code2vec"


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
    if not os.path.isdir("val"):
        os.mkdir("val")
        print('Created output directory at: ' + os.path.abspath("val"))

    if not os.path.isdir("train"):
        os.mkdir("train")
        print('Created output directory at: ' + os.path.abspath("train"))

    if not os.path.isdir("test"):
        os.mkdir("test")
        print('Created output directory at: ' + os.path.abspath("test"))


def writeInput(data, name):
    createDirectories()

    f_train_feats = open("train/train" + name + "0.java", "w", encoding="utf-8")
    f_train_labels = open("train_labeled" + name + ".txt", "w", encoding="utf-8")

    f_train_counter = 0
    f_train_file_counter = 0

    f_test_feats = open("test/test" + name + "0.java", "w", encoding="utf-8")
    f_test_labels = open("test_labeled" + name + ".txt", "w", encoding="utf-8")

    f_test_counter = 0
    f_test_file_counter = 0

    f_val_feats = open("val/val" + name + "0.java", "w", encoding="utf-8")
    f_val_labels = open("val_labeled" + name + ".txt", "w", encoding="utf-8")

    f_val_counter = 0
    f_val_file_counter = 0

    # Organize Data into split 5/2/3
    for id, elem in enumerate(data):
        if id % 10 < 5:
            if f_train_counter > 1000:
                f_train_file_counter += 1
                f_train_feats.close()
                f_train_feats = open("train/train" + name + str(f_train_file_counter) + ".java", "w", encoding="utf-8")
                f_train_counter = 0
            
            f_train_feats.write(elem.getJavaRepresentation())
            f_train_labels.write(str(elem))
            f_train_counter += 1
        elif id % 10 in range(5, 7, 1):
            if f_test_counter > 1000:
                f_test_file_counter += 1
                f_test_feats.close()
                f_test_feats = open("test/test" + name + str(f_test_file_counter) + ".java", "w", encoding="utf-8")
                f_test_counter = 0
                
            f_test_feats.write(elem.getJavaRepresentation())
            f_test_labels.write(str(elem))
            f_test_counter += 1
        else:
            if f_val_counter > 1000:
                f_val_file_counter += 1
                f_val_feats.close()
                f_val_feats = open("val/val" + name + str(f_val_file_counter) + ".java", "w", encoding="utf-8")
                f_val_counter = 0
                
            f_val_feats.write(elem.getJavaRepresentation())
            f_val_labels.write(str(elem))
            f_val_counter += 1


    print('Wrote ' + str(len(data)) + ' methods to disk.')

    f_train_feats.close()
    f_train_labels.close()

    f_test_feats.close()
    f_test_labels.close()

    f_val_feats.close()
    f_val_labels.close()


# pipeline
def preprocess():
    for (dirpath, dirnames, filenames) in os.walk("../result/filteredCode2Vec"):
        for filename in filenames:
            data = processInput(dirpath + "/" + filename)
            writeInput(data, os.path.splitext(filename)[0])

            if not os.path.isdir(dirpath + '/processed'):
                os.makedirs(dirpath + '/processed')
            os.rename(dirpath + "/" + filename, dirpath + "/processed/" + filename)

        print("Extracted all files in: " + dirpath)
        break

    os.chdir(CODE2VEC_PATH)
    subprocess.call('sh preprocess_code.sh', shell=True)


# RUN PREPROCESS
preprocess()
