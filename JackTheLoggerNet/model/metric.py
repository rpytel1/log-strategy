import torch


def accuracy(output, target):
    with torch.no_grad():
        pred = torch.argmax(output, dim=1)
        assert pred.shape[0] == len(target)
        correct = 0
        correct += torch.sum(pred == target).item()
    return correct / len(target)


def recall(output, target):
    with torch.no_grad():
        pred = torch.argmax(output, dim=1)
        assert pred.shape[0] == len(target)
        pred = pred[pred == target]
        tp = torch.sum(pred == 1).item()
        tp_fn = torch.sum(target == 1).item()
        if tp_fn == 0:
            return 0
    return tp / max(tp_fn, tp)

def balanced_acc(output, target):
    rec = recall(output, target)

    
    with torch.no_grad():
        pred = torch.argmax(output, dim=1)
        assert pred.shape[0] == len(target)
        pred = pred[pred == target]
        tn = torch.sum(pred == 0).item()
        tn_fp = torch.sum(target == 0).item()
        if tn_fp == 0:
            return 0
    return (rec + (tn / max(tn_fp, tn))) / 2
