import os
from DataElem import DataElem
from IOHelper import read_data, write_data, move_file
import re
import warnings

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

    for id, line in enumerate(read_data(input)):
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

def prepare(input_dir: str, save_dir: str):
    print("Prepare the data for code2vec.")
    for (dirpath, dirnames, filenames) in os.walk(input_dir):
        for filename in filenames:
            data = processInput(dirpath + "/" + filename)
            write_data(data, save_dir, filename)
            move_file(dirpath + "/" + filename, dirpath + "/processed/" + filename)