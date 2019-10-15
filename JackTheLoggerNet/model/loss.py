import torch
import torch.nn.functional as F


def cross_entropy_loss(output, target):
    return F.cross_entropy(output, target, weight=torch.tensor([1.,25.]))
