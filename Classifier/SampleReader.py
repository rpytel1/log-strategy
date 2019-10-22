from Sample import Sample
from Persistence import write
import random

# read code2vec representation from txt file into samples in an iterative more RAM efficient way
def isSampleEnd(line: str) -> bool:
    return ']' in line

def extractSamples(file, batch_size: int, start: int = 0) -> ([Sample], bool):
    samples = []
    sampleRaw = ""
    sample_count = 0
    for line in file:
        sampleRaw += line
        if isSampleEnd(line):
            sample_count += 1
            if sample_count > start:
                samples.append(Sample(sampleRaw.splitlines()))
                sampleRaw = ""
        if len(samples) == batch_size:
            print("Extracted:", len(samples), "samples.")
            return samples, False
    print("Extracted:", len(samples), "samples and red file", str(file), "till the end.")
    return samples, True

def extractData(samples: [Sample]) -> ([float], [int]):
    codeVectors, labels = [], []
    for sample in samples:
        codeVectors.append(sample.codeVector)
        labels.append(sample.label)

    return codeVectors, labels

# split the training data based on given conditions
def filterPositive(sample):
    return sample.label == 1

def filterNegative(sample):
    return sample.label == 0

def conditionalCount(list, condition) -> int:
    return sum(condition(sample) for sample in list)

def conditionalSplit(list, condition, a_target: int, b_target: int):
    a, b = [], []
    a_count, b_count = 0, 0
    for element in list:
        if a_count >= a_target and b_count >= b_target:
            return a, b
        elif a_count < a_target and condition(element):
            a.append(element)
            a_count += 1
        elif b_count < b_target and not condition(element):
            b.append(element)
            b_count += 1

    if a_count >= a_target and b_count >= b_target:
        return a, b
    raise ValueError("Could not hit the given target of", a_target, "positive elements and",
                     b_target, "negative elements with condition:", str(condition), "for the given input.")

def estimateSplitCount(samples: [Sample], positive_proportion: float) -> int:
    positiveSampleCount: int = conditionalCount(samples, filterPositive)
    negativeSampleCount: int = conditionalCount(samples, filterNegative)
    return estimateBalance(positiveSampleCount, negativeSampleCount, positive_proportion)

def estimateBalance(positiveSampleCount, negativeSampleCount, positive_proportion: float) -> int:
    negative_proportion = 1 - positive_proportion
    finalNegativeRatio: float = negative_proportion / positive_proportion
    finalNegativeTargetTmp: int = int(finalNegativeRatio * positiveSampleCount)
    finalNegativeTarget: int = finalNegativeTargetTmp if finalNegativeTargetTmp < negativeSampleCount else negativeSampleCount
    finalNegativeRatio: float = positive_proportion / negative_proportion
    finalPositiveTarget: int = int(finalNegativeRatio * finalNegativeTarget)
    sampleTargetCount = finalNegativeTarget + finalPositiveTarget
    return sampleTargetCount

def rebalance_data(samples: [Sample], positive_proportion: float, sampleTargetCount: int = -1) -> [Sample]:
    if positive_proportion < 0:
        return samples

    if sampleTargetCount == -1:
        sampleTargetCount = estimateSplitCount(samples, positive_proportion)

    negative_proportion = 1 - positive_proportion
    positiveSampleCount: int = conditionalCount(samples, filterPositive)
    negativeSampleCount: int = conditionalCount(samples, filterNegative)
    finalNegativeTarget: int = int(sampleTargetCount * negative_proportion)
    finalPositiveTarget: int = int(sampleTargetCount * positive_proportion)

    if negativeSampleCount < finalNegativeTarget:
        raise ValueError("To few negative samples for a final sample count of", sampleTargetCount, "with", negative_proportion, "percent negative samples.")
    elif positiveSampleCount < finalPositiveTarget:
        raise ValueError("To few negative samples for a final sample count of", sampleTargetCount, "with", positive_proportion, "percent positive samples.")

    positive_samples, negative_samples = conditionalSplit(samples, filterPositive, finalPositiveTarget, finalNegativeTarget)
    shuffled_samples = shuffle_data(positive_samples + negative_samples)

    print("Rebalanced data set has a positive/ negative label ratio of:", positive_proportion, "/",
          negative_proportion, "with", (finalPositiveTarget + finalNegativeTarget), "samples.")
    return shuffled_samples

def shuffle_data(samples: [Sample]):
    random.shuffle(samples)
    return samples

def split_set(samples: [Sample], proportion: float = 1):
    size: int = len(samples)
    target: int = int(proportion * size)
    return samples[:target], samples[target:]

def statistics(path):
    with open(path, "r") as file_in:
        eof = False
        feature_count, positive_count, negative_count = 0, 0, 0
        while not eof:
            samples, eof = extractSamples(file_in, 60000)
            _, positive_countTmp, negative_countTmp = statistics_samples(samples)
            positive_count += positive_countTmp
            negative_count += negative_countTmp

        return (negative_count + positive_count), positive_count, negative_count

def statistics_samples(samples: [Sample]):
    positive_count = conditionalCount(samples, filterPositive)
    negative_count = conditionalCount(samples, filterNegative)
    return (negative_count + positive_count), positive_count, negative_count

def write_rebalanced_shuffled_data(file_in, save_path: str, stop: int = -1, balance: float = -1, step: int = 60000):
    eof = False
    sample_count: int = 0
    while not eof and (stop < 0 or sample_count < stop):
        samples, eof = extractSamples(file_in, min(step, max(stop - sample_count, 100) if stop > 0 else step))
        if balance > 0:
            samples = rebalance_data(samples, balance)
        else:
            samples = shuffle_data(samples)
        sample_count += len(samples)
        write(samples, save_path)

