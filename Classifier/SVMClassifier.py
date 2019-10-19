from Evaluation import JaccardIndex, Accuracy, APrecision, Precision, Recall
from sklearn import svm
from SampleReader import extractSamples, extractData, statistics, rebalance_data
import time
from Persistence import loadModel, save
import numpy as np
from sklearn.ensemble import RandomForestRegressor, RandomForestClassifier
from sklearn.model_selection import RandomizedSearchCV, GridSearchCV


TRAINING_DATA_PATH = "..//result//codevectors//codevectors_labeled_rebalanced-0-2_shuffled.txt"
TEST_DATA_PATH = "..//result//codevectors//codevectors_labeled_shuffled_test.txt"
CLASSIFIER_SAVEPATH = "C://Users//Jan//Desktop//log-strategy//Classifier//model"
STEP_SIZE = 6000000
POSITIVE_RATIO = 0.2


def train_svm(totalCodeVectors, totalLabels):
    print("Training new svm classifier.")
    startTime = time.time()
    clf = svm.SVC(gamma='scale')
    clf.fit(totalCodeVectors, totalLabels)
    svm.SVC(C=1.0, cache_size=2000, class_weight=None, coef0=0.0,
            decision_function_shape='ovr', degree=3, gamma=0.01, kernel='rbf',
            max_iter=-1, probability=False, random_state=None, shrinking=True,
            tol=0.001, verbose=False)
    endTime = time.time()
    executionTime = endTime - startTime
    print("Training svm classifier with", len(totalCodeVectors), "samples took:", round(executionTime, 2), 'seconds.')
    return clf

def train_svm_grid(totalCodeVectors, totalLabels):
    print("Training new svm classifier with grid hyper tuning.")
    startTime = time.time()
    Cs = [0.1, 1, 10]
    gammas = [0.001, 0.01, 0.1]
    param_grid = {'C': Cs, 'gamma': gammas}
    clf = GridSearchCV(svm.SVC(kernel='rbf', C=1.0, cache_size=2000, class_weight=None, coef0=0.0,
                               decision_function_shape='ovr', degree=3, max_iter=-1, probability=False,
                               random_state=None, shrinking=True, tol=0.001, verbose=False), param_grid)
    clf.fit(totalCodeVectors, totalLabels)
    endTime = time.time()
    executionTime = endTime - startTime
    print("Best parameter for svm:", clf.best_params_)
    print("Training svm classifier with", len(totalCodeVectors), "samples took:", round(executionTime, 2), 'seconds.')
    return clf

def train_randomforest_grid(totalCodeVectors, totalLabels):
    print("Training new random forest classifier.")
    startTime = time.time()
    n_estimators = [int(x) for x in np.linspace(start = 200, stop = 2000, num = 10)]
    max_samples = ['auto', 'sqrt']
    max_depth = [int(x) for x in np.linspace(10, 110, num = 11)]
    max_depth.append(None)
    min_samples_split = [2, 5, 10]
    min_samples_leaf = [1, 2, 4]
    bootstrap = [True, False]
    random_grid = {'n_estimators': n_estimators,
                   'max_samples': max_samples,
                   'max_depth': max_depth,
                   'min_samples_split': min_samples_split,
                   'min_samples_leaf': min_samples_leaf,
                   'bootstrap': bootstrap}
    rf = RandomForestRegressor()
    clf = rf_random = RandomizedSearchCV(estimator=rf, param_distributions=random_grid, n_iter=100,
                                         cv=3, verbose=2, random_state=42, n_jobs=-1)
    clf.fit(totalCodeVectors, totalLabels)
    endTime = time.time()
    executionTime = endTime - startTime
    print("Best parameter for random forest:", rf_random.best_params_)
    print("Training random forest classifier with", len(totalCodeVectors), "samples took:", round(executionTime, 2), 'seconds.')
    return rf_random.best_estimator_

def train_randomforest(totalCodeVectors, totalLabels):
    print("Training new random forest classifier.")
    startTime = time.time()
    clf = RandomForestClassifier(n_estimators=800, max_features='sqrt', max_depth=None, min_samples_split=2,
                                 min_samples_leaf=4, bootstrap=False, verbose=2, random_state=42, n_jobs=-1)
    clf.fit(totalCodeVectors, totalLabels)
    endTime = time.time()
    executionTime = endTime - startTime
    print("Training random forest classifier with", len(totalCodeVectors), "features took:", round(executionTime, 2), 'seconds.')
    return clf

# As other classifiers, SVC, NuSVC and LinearSVC take as input two arrays: an array X of size [n_samples, n_samples] holding the training samples,
# and an array y of class labels (strings or integers), size [n_samples]:
def train_classifier(data_path: str, stop: int = -1, step: int = 60000):
    sample_count = 0
    eof = False
    totalCodeVectors, totalLabels = [], []
    with open(data_path, "r") as file_in:
        while not eof and (stop < 0 or sample_count < stop):
            startTime = time.time()
            samples, eof = extractSamples(file_in, min(step, max(stop - sample_count, 100) if stop > 0 else step))
            samples = rebalance_data(samples, POSITIVE_RATIO)
            sample_count += len(samples)
            if len(samples) > 0:
                codeVectors, labels = extractData(samples)
                totalCodeVectors += codeVectors
                totalLabels += labels
                endTime = time.time()
                executionTime = endTime - startTime
                print("Extracting and rebalancing data with", len(samples), "features took:", round(executionTime, 2), 'seconds, current total:', sample_count)
    random_forest_classifier = train_randomforest(totalCodeVectors, totalLabels)
    # svm_classifier = train_svm(totalCodeVectors, totalLabels)
    return [(random_forest_classifier, "random-forest")]

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
    classifier = train_classifier(TRAINING_DATA_PATH, stop=2500, step=STEP_SIZE)

    with open(TEST_DATA_PATH, "r") as file_in:
        samples, eof = extractSamples(file_in, 5000)
        test_codeVectors, test_labels = extractData(samples)
        print("Extracted test data set with:", len(test_codeVectors), "samples.")

    for model, descriptor in classifier:
        save(model, CLASSIFIER_SAVEPATH + "_" + descriptor + "_" + str(2500) + "_" + str(round(POSITIVE_RATIO, 2)) + ".joblib")
        prediction = model.predict(test_codeVectors)
        evaluate(prediction, test_labels, ''.join(["Test samples:", str(len(samples)), descriptor]))