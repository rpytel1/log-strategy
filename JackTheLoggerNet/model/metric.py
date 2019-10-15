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
        tp = torch.sum(pred == 1).item()
        tp_fn = torch.sum(target == 1).item()
        print(tp, tp_fn)
        if tp_fn == 0:
            return 0
    return tp / max(tp_fn, tp)
