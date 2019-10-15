from Evaluation import JaccardIndex, Accuracy, APrecision, Precision, Recall
from sklearn import svm, linear_model
import FeatureReader as  fr
import time
from Persistence import loadModel, save
import numpy as np
from sklearn.ensemble import RandomForestClassifier


DATA_PATH = "..//result//codevectors//codevectors_labeled.txt"
CLASSIFIER_SAVEPATH = "C://Users//Jan//Desktop//log-strategy//SVM-Classifier//trained_svm"
TRAIN_SIZE = 160000
TEST_SIZE = 20000
STEP_SIZE = 60000
POSITIVE_RATIO = 0.2

def incremental_train_svm(data_path: str, stop: int, step: int):
    feature_count = 0
    eof = False
    model = linear_model.SGDClassifier()

    with open(data_path, "r") as file_in:
        while not eof and feature_count < stop:
            startTime = time.time()
            features, eof = fr.extractFeatures(file_in, min(step, stop))
            feature_count += len(features)
            if len(features) > 0:
                codeVectors, labels = fr.extractData(features)
                model = model.partial_fit(codeVectors, labels, classes=np.unique(labels))
                endTime = time.time()
                executionTime = endTime - startTime
                print("Extracting and training model with", len(features), "features took:", round(executionTime, 2), 'seconds, current total:', feature_count)
    return model

def train_svm(totalCodeVectors, totalLabels):
    print("Training new svm classifier.")
    startTime = time.time()
    clf = svm.SVC(gamma='scale')
    clf.fit(totalCodeVectors, totalLabels)
    svm.SVC(C=1.0, cache_size=200, class_weight=None, coef0=0.0,
            decision_function_shape='ovr', degree=3, gamma='scale', kernel='rbf',
            max_iter=-1, probability=False, random_state=None, shrinking=True,
            tol=0.001, verbose=False)
    endTime = time.time()
    executionTime = endTime - startTime
    print("Training svm classifier with", len(totalCodeVectors), "features took:", round(executionTime, 2), 'seconds.')
    return clf

def train_randomforest(totalCodeVectors, totalLabels):
    print("Training new random forest classifier.")
    startTime = time.time()
    clf = RandomForestClassifier(n_estimators=100, max_depth=2, random_state=0)
    clf.fit(totalCodeVectors, totalLabels)
    RandomForestClassifier(bootstrap=True, class_weight=None, criterion='gini',
                       max_depth=2, max_features='auto', max_leaf_nodes=None,
                       min_impurity_decrease=0.0, min_impurity_split=None,
                       min_samples_leaf=1, min_samples_split=2,
                       min_weight_fraction_leaf=0.0, n_estimators=100, n_jobs=None,
                       oob_score=False, random_state=0, verbose=0, warm_start=False)
    endTime = time.time()
    executionTime = endTime - startTime
    print("Training random forest classifier with", len(totalCodeVectors), "features took:", round(executionTime, 2), 'seconds.')
    return clf

# As other classifiers, SVC, NuSVC and LinearSVC take as input two arrays: an array X of size [n_samples, n_features] holding the training samples,
# and an array y of class labels (strings or integers), size [n_samples]:
def train_classifier(data_path: str, stop: int, step: int):
    feature_count = 0
    eof = False
    totalCodeVectors, totalLabels = [], []

    with open(data_path, "r") as file_in:
        while not eof and feature_count < stop:
            startTime = time.time()
            features, eof = fr.extractFeatures(file_in, min(step, stop))
            features = fr.splitDataSet(features, POSITIVE_RATIO, min(fr.estimateSplitCount(features, POSITIVE_RATIO), (stop - feature_count)))
            feature_count += len(features)
            if len(features) > 0:
                codeVectors, labels = fr.extractData(features)
                totalCodeVectors += codeVectors
                totalLabels += labels
                endTime = time.time()
                executionTime = endTime - startTime
                print("Extracting and splitting model with", len(features), "features took:", round(executionTime, 2), 'seconds, current total:', feature_count)

    svm_classifier = train_svm(totalCodeVectors, totalLabels)
    random_forest_classifier = train_randomforest(totalCodeVectors, totalLabels)

    return [(svm_classifier, "svm"), (random_forest_classifier, "random_forest")]

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
    classifier = train_classifier(DATA_PATH, TRAIN_SIZE, STEP_SIZE)
    for model, descriptor in classifier:
        save(model, CLASSIFIER_SAVEPATH + "_" + descriptor + "_" + str(TRAIN_SIZE) + "_" + str(round(POSITIVE_RATIO, 2)) + ".joblib")

    with open(DATA_PATH, "r") as file_in:
        features, eof = fr.extractFeatures(file_in, TEST_SIZE)
        test_codeVectors, test_labels = fr.extractData(features)
        for model, descriptor in classifier:
            prediction = model.predict(test_codeVectors)
            evaluate(prediction, test_labels, str(TEST_SIZE) + descriptor)

