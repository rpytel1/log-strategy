import numpy as np
from Evaluation import JaccardIndex, Accuracy
from sklearn import svm

def readInput(path: str):
    file = open(path, "r")
    lines = file.readlines()
    file.close()
    print("Found and red " + str(int(len(lines) / 2)) + ' methods in ' + path + '.')
    return lines

def extractVectors(data) -> [[int], [float]] :
    vectors = []
    sampleSizes = []
    for id, line in data:
        if id % 3 == 2:
            codeVector = np.fromstring(line, float)
            vectors.append(codeVector)
            sampleSizes.append(codeVector.size)

    return [sampleSizes, vectors]

def extractLabels(data) -> [int]:
    labels = []
    for id, line in data:
        if id % 3 == 1:
            labels.append(int(line))

    return labels

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


if __name__ == '__main__':
    data = readInput("")
    codeVectors = extractVectors(data)
    labels = extractLabels(data)
    model = train(codeVectors, labels)

    validation_data = readInput("")
    validation_codeVectors = extractVectors(data)
    validation_labels = extractLabels(data)
    prediction = model.predict(validation_codeVectors)

    print("Accuracy: " + str(Accuracy(prediction, validation_labels)))
    print("JaccardIndex: " + str(JaccardIndex(prediction, validation_labels)))
