from Evaluation import JaccardIndex, Accuracy, APrecision, Precision, Recall
from sklearn import svm, linear_model
import FeatureReader as  fr
import time
from Persistence import loadModel, save
import numpy as np


DATA_PATH = "..//result//codevectors//codevectors_labeled.txt"
MODEL_SAVEPATH = "C://Users//Jan//Desktop//log-strategy//SVM-Classifier//trained_svm"
TRAIN_SIZE = 50000
TEST_SIZE = 5000
STEP_SIZE = 10000
POSITIVE_RATIO = 0.2
MODEL_DESCRIPTOR = "_" + str(TRAIN_SIZE) + "_" + str(round(POSITIVE_RATIO, 2)) + ".joblib"

def incremental_train_svm(data_path: str, stop: int, step: int):
    feature_count = 0
    eof = False
    model = linear_model.SGDClassifier()

    with open(data_path, "r") as file_in:
        while not eof and feature_count < stop:
            startTime = time.time()
            features, eof = fr.extractFeatures(file_in, step)
            feature_count += len(features)
            if len(features) > 0:
                codeVectors, labels = fr.extractData(features)
                model = model.partial_fit(codeVectors, labels, classes=np.unique(labels))
                endTime = time.time()
                executionTime = endTime - startTime
                print("Extracting and training model with", step, "features took:", round(executionTime, 2), 'seconds.')

    return model

# As other classifiers, SVC, NuSVC and LinearSVC take as input two arrays: an array X of size [n_samples, n_features] holding the training samples,
# and an array y of class labels (strings or integers), size [n_samples]:
def train_svm(data_path: str, stop: int, step: int):
    feature_count = 0
    eof = False
    totalCodeVectors, totalLabels = [], []

    with open(data_path, "r") as file_in:
        while not eof and feature_count < stop:
            startTime = time.time()
            features, eof = fr.extractFeatures(file_in, min(step, stop - feature_count))
            features = fr.splitDataSet(features, POSITIVE_RATIO)
            feature_count += len(features)
            if len(features) > 0:
                codeVectors, labels = fr.extractData(features)
                totalCodeVectors += codeVectors
                totalLabels += labels
                endTime = time.time()
                executionTime = endTime - startTime
                print("Extracting and splitting", len(features), "features took:", round(executionTime, 2), 'seconds.')

    startTime = time.time()
    clf = svm.SVC(gamma='scale')
    clf.fit(totalCodeVectors, totalLabels)
    svm.SVC(C=1.0, cache_size=200, class_weight=None, coef0=0.0,
            decision_function_shape='ovr', degree=3, gamma='scale', kernel='rbf',
            max_iter=-1, probability=False, random_state=None, shrinking=True,
            tol=0.001, verbose=False)
    endTime = time.time()
    executionTime = endTime - startTime
    print("Training model with", feature_count, "features took:", round(executionTime, 2), 'seconds.')
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
        model = train_svm(DATA_PATH, TRAIN_SIZE, STEP_SIZE)
        save(model, MODEL_SAVEPATH + MODEL_DESCRIPTOR)

    with open(DATA_PATH, "r") as file_in:
        features, eof = fr.extractFeatures(file_in, TEST_SIZE)
        test_codeVectors, test_labels = fr.extractData(features)
        prediction = model.predict(test_codeVectors)
        evaluate(prediction, test_labels, str(TEST_SIZE) + " test samples")

