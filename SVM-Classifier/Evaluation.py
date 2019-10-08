from sklearn.metrics import jaccard_score, accuracy_score, average_precision_score, recall_score, precision_score


def JaccardIndex(predictions, labels) -> float:
    jaccard_index = jaccard_score(y_true=labels, y_pred=predictions)
    return round(jaccard_index, 3)

def Accuracy(predictions, labels) -> float:
    return accuracy_score(y_true=labels, y_pred=predictions)

def APrecision(predictions, labels) -> float:
    return average_precision_score(y_true=labels, y_score=predictions)

def Recall(predictions, labels):
    return recall_score(y_true=labels, y_pred=predictions)

def Precision(predictions, labels):
    return precision_score(y_true=labels, y_pred=predictions, average='binary')
