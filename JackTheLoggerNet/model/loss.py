import torch.nn.functional as F


def cross_entropy_loss(output, target):
    return F.binary_cross_entropy(output, target)
