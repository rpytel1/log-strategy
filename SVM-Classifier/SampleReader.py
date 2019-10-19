from Sample import Sample
import random

# read code2vec representation from txt file into features in an iterative more RAM efficient way
def isFeatureEnd(line: str) -> bool:
    return ']' in line

def extractFeatures(file, batch_size: int, start: int = 0) -> ([Sample], bool):
    features = []
    featureRaw = ""
    feature_count = 0

    for line in file:
        featureRaw += line
        if isFeatureEnd(line):
            feature_count += 1
            if feature_count > start:
                features.append(Sample(featureRaw.splitlines()))
                featureRaw = ""

        if len(features) == batch_size:
            return features, False

    print("Extracted:", len(features), "features and red file", str(file), "till the end.")
    return features, True

def extractData(features: [Sample]) -> ([float], [int]):
    codeVectors, labels = [], []
    for feature in features:
        codeVectors.append(feature.codeVector)
        labels.append(feature.label)

    return codeVectors, labels


# split the training data based on given conditions
def filterPositive(feature):
    return feature.label == 1

def filterNegative(feature):
    return feature.label == 0

def conditionalCount(list, condition) -> int:
    return sum(condition(feature) for feature in list)

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

def estimateSplitCount(features: [Sample], positive_proportion: float) -> int:
    positiveFeatureCount: int = conditionalCount(features, filterPositive)
    negativeFeatureCount: int = conditionalCount(features, filterNegative)
    return estimateBalance(positiveFeatureCount, negativeFeatureCount, positive_proportion)

def estimateBalance(positiveFeatureCount, negativeFeatureCount, positive_proportion: float) -> int:
    negative_proportion = 1 - positive_proportion
    finalNegativeRatio: float = negative_proportion / positive_proportion
    finalNegativeTargetTmp: int = int(finalNegativeRatio * positiveFeatureCount)
    finalNegativeTarget: int = finalNegativeTargetTmp if finalNegativeTargetTmp < negativeFeatureCount else negativeFeatureCount
    finalNegativeRatio: float = positive_proportion / negative_proportion
    finalPositiveTarget: int = int(finalNegativeRatio * finalNegativeTarget)
    featureTargetCount = finalNegativeTarget + finalPositiveTarget
    return featureTargetCount

def rebalance_data(features: [Sample], positive_proportion: float, featureTargetCount: int = -1) -> [Sample]:
    if positive_proportion < 0:
        return features

    if featureTargetCount == -1:
        featureTargetCount = estimateSplitCount(features, positive_proportion)

    negative_proportion = 1 - positive_proportion
    positiveFeatureCount: int = conditionalCount(features, filterPositive)
    negativeFeatureCount: int = conditionalCount(features, filterNegative)
    finalNegativeTarget: int = int(featureTargetCount * negative_proportion)
    finalPositiveTarget: int = int(featureTargetCount * positive_proportion)

    if negativeFeatureCount < finalNegativeTarget:
        raise ValueError("To few negative features for a final feature count of", featureTargetCount, "with", negative_proportion, "percent negative features.")
    elif positiveFeatureCount < finalPositiveTarget:
        raise ValueError("To few negative features for a final feature count of", featureTargetCount, "with", positive_proportion, "percent positive features.")

    positiveFeatures, negativeFeatures = conditionalSplit(features, filterPositive, finalPositiveTarget, finalNegativeTarget)
    samples = shuffle_data(positiveFeatures + negativeFeatures)

    print("Rebalanced and shuffled data set has a positive/ negative label ratio of:", positive_proportion, "/",
          negative_proportion, "with", (finalPositiveTarget + finalNegativeTarget), "features.")
    return samples

def shuffle_data(features: [Sample]):
    random.shuffle(features)
    return features

def split_set(features: [Sample], proportion: float = 1):
    size: int = len(features)
    target: int = int(proportion * size)
    return features[:target], features[target:]

def statistics(path):
    with open(path, "r") as file_in:
        eof = False
        feature_count, positive_count, negative_count = 0, 0, 0
        while not eof:
            samples, eof = extractFeatures(file_in, 60000)
            _, positive_countTmp, negative_countTmp = statistics_samples(samples)
            positive_count += positive_countTmp
            negative_count += negative_countTmp

        return (negative_count + positive_count), positive_count, negative_count

def statistics_samples(samples: [Sample]):
    positive_count = conditionalCount(samples, filterPositive)
    negative_count = conditionalCount(samples, filterNegative)

    return (negative_count + positive_count), positive_count, negative_count

def save(samples: [Sample], savepath: str):
    print("Start writing", len(samples), "sample to", savepath)
    with open(savepath, "a+") as file:
        write_buffer = ""
        sample_count = 0
        for sample in samples:
            if sample_count > 1000:
                file.write(write_buffer)
                write_buffer = ""
                sample_count = 0
            sample_count += 1
            write_buffer += str(sample)
        file.write(write_buffer)
    print("Saved all samples to:", savepath)

def write_rebalanced_shuffled_data(file_in, save_path: str, stop: int = -1, balance: float = -1, step: int = 60000):
    samples = []
    eof = False
    sample_count: int = 0
    while not eof and (stop < 0 or sample_count < stop):
        samples, eof = extractFeatures(file_in, min(step, max(stop - step, 100) if stop > 0 else step))
        if balance > 0:
            samples = rebalance_data(samples, balance)
        sample_count += len(samples)
        save(samples, save_path)
    save(samples, save_path)
