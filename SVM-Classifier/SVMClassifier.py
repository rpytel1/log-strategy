from Evaluation import JaccardIndex, Accuracy, APrecision, Precision, Recall
from sklearn import svm, linear_model
from Feature import Feature
import time
from Persistence import loadModel, save
import numpy as np


DATA_PATH = "..//result//codevectors//codevectors_labeled.txt"
MODEL_SAVEPATH = "C://Users//Jan//Desktop//log-strategy//SVM-Classifier//trained_svm"
TRAIN_SIZE = 80000
TEST_SIZE = 20000
STEP_SIZE = 20000


def isFeatureEnd(line: str) -> bool:
    return ']' in line

def extractFeatures(file, batch_size: int) -> ([Feature], bool):
    features = []
    featureRaw = ""

    for line in file:
        featureRaw += line
        if isFeatureEnd(line):
            features.append(Feature(featureRaw.splitlines()))
            featureRaw = ""

        if len(features) == batch_size:
            print("Extracted:", len(features), "features")
            return features, False

    print("Extracted:", len(features), "features")
    return features, True

def extractData(features: [Feature]) -> ([float], [int]):
    codeVectors, labels = [], []
    for feature in features:
        codeVectors.append(feature.codeVector)
        labels.append(feature.label)

    return codeVectors, labels

def get_model():
    clf = linear_model.SGDClassifier()
    return clf

def incremental_train(data_path: str, stop: int, step: int):
    feature_count =0
    eof = False
    model = get_model()

    with open(data_path, "r") as file_in:
        while not eof and feature_count < stop:
            startTime = time.time()
            features, eof = extractFeatures(file_in, step)
            feature_count += len(features)
            if len(features) > 0:
                codeVectors, labels = extractData(features)
                model = model.partial_fit(codeVectors, labels, classes=np.unique(labels))
                endTime = time.time()
                executionTime = endTime - startTime
                print("Extracting and training model with", step, "features took:", round(executionTime, 2), 'seconds.')

    return model

# As other classifiers, SVC, NuSVC and LinearSVC take as input two arrays: an array X of size [n_samples, n_features] holding the training samples,
# and an array y of class labels (strings or integers), size [n_samples]:
def train_svm(features, labels):
    clf = svm.SVC(gamma='scale')
    clf.fit(features, labels)
    svm.SVC(C=1.0, cache_size=200, class_weight=None, coef0=0.0,
    decision_function_shape='ovr', degree=3, gamma='scale', kernel='rbf',
    max_iter=-1, probability=False, random_state=None, shrinking=True,
    tol=0.001, verbose=False)
    return clf

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
    model = loadModel(MODEL_SAVEPATH + "_" + str(TRAIN_SIZE) + ".joblib")
    lastLineNo = 0
    if(model == None):
        print("Training new svm model.")
        startTime = time.time()
        model = incremental_train(DATA_PATH, TRAIN_SIZE, STEP_SIZE)
        endTime = time.time()
        executionTime = endTime - startTime
        print("Training model with", TRAIN_SIZE, "samples took", round(executionTime, 2), 'seconds.')
        save(model, MODEL_SAVEPATH + "_" + str(TRAIN_SIZE) + ".joblib")

    with open(DATA_PATH, "r") as file_in:
        features, eof = extractFeatures(file_in, TEST_SIZE)
        test_codeVectors, test_labels = extractData(features)
        prediction = model.predict(test_codeVectors)
        evaluate(prediction, test_labels, str(TEST_SIZE) + " test samples")

