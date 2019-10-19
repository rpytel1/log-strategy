from Evaluation import JaccardIndex, Accuracy, APrecision, Precision, Recall
from sklearn import svm, linear_model
import FeatureReader as fr
import time
from Persistence import loadModel, save
import numpy as np
from sklearn.ensemble import RandomForestRegressor
from sklearn.model_selection import RandomizedSearchCV, GridSearchCV


TRAINING_DATA_PATH = "..//result//codevectors//codevectors_labeled.txt"
TEST_DATA_PATH = "..//result//codevectors//codevectors_labeled.txt"
CLASSIFIER_SAVEPATH = "C://Users//Jan//Desktop//log-strategy//SVM-Classifier//model"
STEP_SIZE = 6000000
POSITIVE_RATIO = 0.2
REAL_POSITIVE_RATIO = 0.04

def incremental_train_svm(data_path: str, stop: int, step: int):
    feature_count = 0
    eof = False
    model = linear_model.SGDClassifier()

    with open(data_path, "r") as file_in:
        while not eof and feature_count < stop:
            startTime = time.time()
            features, eof = get_features(file_in, feature_count, step, stop)
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

def train_svm_grid(totalCodeVectors, totalLabels):
    print("Training new svm classifier with grid hyper tuning.")
    startTime = time.time()
    Cs = [0.1, 1, 10]
    gammas = [0.01, 0.1, 1]
    param_grid = {'C': Cs, 'gamma': gammas}
    clf = GridSearchCV(svm.SVC(kernel='rbf', C=1.0, cache_size=500, class_weight=None, coef0=0.0,
                               decision_function_shape='ovr', degree=3, max_iter=-1, probability=False,
                               random_state=None, shrinking=True, tol=0.001, verbose=False), param_grid)
    clf.fit(totalCodeVectors, totalLabels)
    endTime = time.time()
    executionTime = endTime - startTime
    print("Best parameter for svm:", clf.best_params_)
    print("Training svm classifier with", len(totalCodeVectors), "features took:", round(executionTime, 2), 'seconds.')
    return clf

def train_randomforest(totalCodeVectors, totalLabels):
    print("Training new random forest classifier.")
    startTime = time.time()
    # Number of trees in random forest
    n_estimators = [int(x) for x in np.linspace(start = 200, stop = 2000, num = 10)]
    # Number of features to consider at every split
    max_features = ['auto', 'sqrt']
    # Maximum number of levels in tree
    max_depth = [int(x) for x in np.linspace(10, 110, num = 11)]
    max_depth.append(None)
    # Minimum number of samples required to split a node
    min_samples_split = [2, 5, 10]
    # Minimum number of samples required at each leaf node
    min_samples_leaf = [1, 2, 4]
    # Method of selecting samples for training each tree
    bootstrap = [True, False]
    # Create the random grid
    random_grid = {'n_estimators': n_estimators,
                   'max_features': max_features,
                   'max_depth': max_depth,
                   'min_samples_split': min_samples_split,
                   'min_samples_leaf': min_samples_leaf,
                   'bootstrap': bootstrap}
    rf = RandomForestRegressor()
    clf = rf_random = RandomizedSearchCV(estimator= rf, param_distributions= random_grid, n_iter= 100,
                                         cv= 3, verbose=2, random_state=42, n_jobs= -1)
    clf.fit(totalCodeVectors, totalLabels)
    endTime = time.time()
    executionTime = endTime - startTime
    print("Best parameter for random forest:", rf_random.best_params_)
    print("Training random forest classifier with", len(totalCodeVectors), "features took:", round(executionTime, 2), 'seconds.')
    return rf_random.best_estimator_

def get_features(file_in, feature_count, step, stop):
    features, eof = fr.extractFeatures(file_in, min(int(step * (POSITIVE_RATIO / REAL_POSITIVE_RATIO) * 2), int(stop * (POSITIVE_RATIO / REAL_POSITIVE_RATIO) * 2)))
    features = fr.shuffle_data(features)
    features = fr.rebalance_data(features, POSITIVE_RATIO, min(fr.estimateSplitCount(features, POSITIVE_RATIO), (stop - feature_count)))
    return features, eof

# As other classifiers, SVC, NuSVC and LinearSVC take as input two arrays: an array X of size [n_samples, n_features] holding the training samples,
# and an array y of class labels (strings or integers), size [n_samples]:
def train_classifier(data_path: str, stop: int, step: int):
    feature_count = 0
    eof = False
    totalCodeVectors, totalLabels = [], []

    with open(data_path, "r") as file_in:
        while not eof and feature_count < stop:
            startTime = time.time()
            features, eof = get_features(file_in, feature_count, step, stop)
            feature_count += len(features)
            if len(features) > 0:
                codeVectors, labels = fr.extractData(features)
                totalCodeVectors += codeVectors
                totalLabels += labels
                endTime = time.time()
                executionTime = endTime - startTime
                print("Extracting and splitting model with", len(features), "features took:", round(executionTime, 2), 'seconds, current total:', feature_count)

    # random_forest_classifier = train_randomforest(totalCodeVectors, totalLabels)
    svm_classifier = train_svm_grid(totalCodeVectors, totalLabels)

    return [(svm_classifier, "svm")]

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
    feature_count, positive_count, negative_count = 925833, 44073, 881760
    train_count: int = fr.estimateBalance(positive_count, negative_count, POSITIVE_RATIO)

    with open(TEST_DATA_PATH, "r") as file_in:
        test_count = 15000
        features, eof = fr.extractFeatures(file_in, test_count)
        test_codeVectors, test_labels = fr.extractData(features)
        print("Extracted training data set with:", len(test_codeVectors), "features.")
        classifier = [loadModel("model_svm_5000_0.2.joblib"), " svm 5000 0-2"]
        for model, descriptor in classifier:
            prediction = model.predict(test_codeVectors)
            evaluate(prediction, test_labels, str(len(features)) + descriptor)