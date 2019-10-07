from sklearn.metrics import jaccard_score
from sklearn.metrics import accuracy_score


def JaccardIndex(predictions, labels) -> float:
    jaccard_index = jaccard_score(y_true=labels, y_pred=predictions)
    return round(jaccard_index, 3)

def Accuracy(predictions, labels) -> float:
    return accuracy_score(labels, predictions)