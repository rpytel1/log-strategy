import numpy as np
from Evaluation import JaccardIndex, Accuracy, APrecision, Precision, Recall
from sklearn import svm
import re
import time
from Persistence import loadModel, save
from sklearn.model_selection import train_test_split

DATA_PATH = "..//result//codevectors//codevectors_labeled.txt"
MODEL_SAVEPATH = "C://Users//Jan//Desktop//log-strategy//SVM-Classifier//trained_svm"


def readInput(path: str):
    file = open(path, "r")
    lines = file.readlines()
    file.close()
    print("\nExtracted", len(lines), "lines from", path, ".")
    return lines

def extractVectors(data) -> [[int], [float]] :
    vectors = []
    tmp = ""
    reading = False
    for id, line in enumerate(data):
        if '[' in line:
            tmp = line
            reading = True
        elif ']' in line:
            tmp += line
            reading = False
            rawVector = re.sub(r'\[|\|\n]', '', tmp)
            codeVector = np.fromstring(rawVector, float, sep=' ').tolist()
            vectors.append(codeVector)
        elif reading:
            tmp += line

    print("Found ", len(vectors), " code vectors.")
    return vectors

def extractLabels(data) -> [int]:
    labels = []
    for id, line in enumerate(data):
        if len(line) <= 2:
            labels.append(int(line))

    print("Of the", len(labels), "labels", labels.count(1), 'labels are positive.\n')
    return labels

def filterData(codeVectors, labels, condition):
    filteredCodeVectors = []
    filteredLabels = []
    for id, label in enumerate(labels):
        if label == condition:
            filteredCodeVectors.append(np.fromiter(codeVectors[id], dtype=float))
            filteredLabels.append(label)

    print("After filtering", len(filteredCodeVectors), "code vectors and", len(filteredLabels), "labels remain.")
    return filteredCodeVectors, filteredLabels

def extractPositive(codeVectors, labels):
    return filterData(codeVectors, labels, 1)

def extractNegative(codeVectors, labels):
    return filterData(codeVectors, labels, 0)

def split(codeVectors, labels, positive_size):
    negative_size = 1 - positive_size
    positiveCodeVectors, positiveLabel = extractPositive(codeVectors, labels)
    negativeCodeVectors, negativeLabel = extractNegative(codeVectors, labels)

    finalRatio = negative_size / positive_size
    finalNegativeCount = int(finalRatio * min(len(positiveCodeVectors), len(negativeCodeVectors)))
    splitCodeVectors = positiveCodeVectors + negativeCodeVectors[:finalNegativeCount]
    splitLabel = positiveLabel + negativeLabel[:finalNegativeCount]
    print("Reconfigured data set has a positive/ negative label ratio of:", positive_size, "/", negative_size, "with", len(splitLabel), "elements.")
    return splitCodeVectors, splitLabel

# As other classifiers, SVC, NuSVC and LinearSVC take as input two arrays: an array X of size [n_samples, n_features] holding the training samples,
# and an array y of class labels (strings or integers), size [n_samples]:
def train(features, labels):
    clf = svm.SVC(gamma='scale')
    clf.fit(features, labels)
    svm.SVC(C=1.0, cache_size=200, class_weight=None, coef0=0.0,
    decision_function_shape='ovr', degree=3, gamma='scale', kernel='rbf',
    max_iter=-1, probability=False, random_state=None, shrinking=True,
    tol=0.001, verbose=False)
    return clf

def extractData(path: str):
    data = readInput(path)
    codeVectors = extractVectors(data)
    labels = extractLabels(data)
    return codeVectors, labels

def evaluate(prediction, label, description):
    print('\n-----------------------RESULTS-----------------------')
    print(description)
    print("Accuracy:", Accuracy(prediction, label))
    print("Jaccard Index:", JaccardIndex(prediction, label))
    print("Precision:", Precision(prediction, label))
    print("Recall:", Recall(prediction, label))
    print("Average precision:", APrecision(prediction, label))
    print('-----------------------END RESULTS-----------------------\n')

if __name__ == '__main__':
    print("Reading and splitting data from:", DATA_PATH)
    startTime = time.time()
    full_codeVectors, full_labels = extractData(DATA_PATH)
    train_codeVectors, test_codeVectors, train_labels, test_labels = train_test_split(full_codeVectors, full_labels, test_size = 0.2, random_state = 0)
    endTime = time.time()
    executionTime = endTime - startTime
    print("Readind and splitting data took:", round(executionTime, 2), 'seconds.')

    model = loadModel(MODEL_SAVEPATH + "_full" + ".joblib")
    if(model == None):
        # reconfigured_codeVectors, reconfigured_labels = split(train_codeVectors + test_codeVectors, train_labels + test_labels, 0.1)
        print("Training new svm model.")
        startTime = time.time()
        model = train(train_codeVectors, train_labels)
        endTime = time.time()
        executionTime = endTime - startTime
        print("Training model took:", round(executionTime, 2), 'seconds.')
        save(model, MODEL_SAVEPATH + "_reconfigured" + ".joblib")

    prediction = model.predict(test_codeVectors)
    evaluate(prediction, test_labels, "test split of 20 percent.")

