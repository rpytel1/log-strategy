from sklearn.metrics import jaccard_score, accuracy_score, recall_score, precision_score, balanced_accuracy_score
from os import path, walk
from Persistence import load_classifier, write
from SampleReader import extractSamples, extractData


TEST_DATA_PATH = "..//result//codevectors//codevectors_labeled_shuffled_test.txt"
CLASSIFIER_PATH = "..//result//Classifier"
STEP_SIZE = 6000000


def JaccardIndex(predictions, labels) -> float:
    jaccard_index = jaccard_score(y_true=labels, y_pred=predictions)
    return round(jaccard_index, 3)

def Accuracy(predictions, labels) -> float:
    return accuracy_score(y_true=labels, y_pred=predictions)

def BalancedAccuracy(predictions, labels) -> float:
    return balanced_accuracy_score(y_true=labels, y_pred=predictions)

def Recall(predictions, labels):
    return recall_score(y_true=labels, y_pred=predictions)

def Precision(predictions, labels):
    return precision_score(y_true=labels, y_pred=predictions, average='binary')

def evaluate(classifier_path: str, test_data_path: str):
    with open(test_data_path, "r") as file_test:
        test_samples, _ = extractSamples(file_test, STEP_SIZE)
        test_codeVectors, test_labels = extractData(test_samples)
        print("Extracted test data set with:", len(test_codeVectors), "samples.")
        if path.isdir(classifier_path):
            for dirpath, dirname, filenames in walk(classifier_path):
                for filename in filenames:
                    __evaluate_classifier("//".join([dirpath, filename]), test_codeVectors, test_labels)
        elif path.isfile(classifier_path):
            __evaluate_classifier(classifier_path, test_codeVectors, test_labels)

def __evaluate_classifier(classifier_path: str, test_codeVectors: [float], test_labels: [int]):
    if classifier_path.endswith('.joblib'):
        classifier = load_classifier(classifier_path)
        evaluate_classifier(classifier, path.splitext(classifier_path)[0], test_codeVectors, test_labels)
    else:
        print(path, "was ignored for evaluation, because it is not saved in joblib format.")

def evaluate_classifier(classifier, name, test_codeVectors: [float], test_labels: [int]):
    print("Making prediction for test set with", str(len(test_codeVectors)), "samples.")
    prediction = classifier.predict(test_codeVectors)
    __evaluate_prediction_formatted(prediction, test_labels,
                                  ' '.join(["Evaluation of classifier", name, "with", str(len(test_codeVectors)), "shuffled samples."]),
                                  "..//result//Classifier//Classifier_Evaluation_Statistics.txt")

def __evaluate_prediction_formatted(prediction, label: [int], description: str, savepath: str):
    result = ''.join(['\n-----------------------RESULTS-----------------------\n',
                      description,
                      "\nAccuracy: ", str(Accuracy(prediction, label)),
                      "\nJaccard Index: ", str(JaccardIndex(prediction, label)),
                      "\nPrecision: ", str(Precision(prediction, label)),
                      "\nRecall: ", str(Recall(prediction, label)),
                      "\nBalanced Accuracy: ", str(BalancedAccuracy(prediction, label)),
                      '\n-----------------------END RESULTS-----------------------\n'])
    print(result)
    write(result, savepath, False)


if __name__ == '__main__':
    sample_count_test, positive_count_test, negative_count_test = 104982, 2865, 102117
    evaluate(CLASSIFIER_PATH, TEST_DATA_PATH)

