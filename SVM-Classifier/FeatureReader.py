from Feature import Feature
from functools import reduce

# read code2vec representation from txt file into features in an iterative more RAM efficient way
def isFeatureEnd(line: str) -> bool:
    return ']' in line

def extractFeatures(file, batch_size: int) -> ([Feature], bool):
    features = []
    featureRaw = ""

    for line in file:
        featureRaw += line
        if isFeatureEnd(line):
            features.append(Feature(featureRaw.splitlines()))
            featureRaw = ""

        if len(features) == batch_size:
            print("Extracted:", len(features), "features")
            return features, False

    print("Extracted:", len(features), "features")
    return features, True

def extractData(features: [Feature]) -> ([float], [int]):
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

def splitDataSet(features: [Feature], positive_proportion: float, featureTargetCount: int = -1) -> [Feature]:
    if positive_proportion <= 0:
        return features

    negative_proportion = 1 - positive_proportion
    positiveFeatureCount: int = conditionalCount(features, filterPositive)
    negativeFeatureCount: int = conditionalCount(features, filterNegative)
    print(positiveFeatureCount)
    print(negativeFeatureCount)

    if featureTargetCount == -1:
        finalNegativeRatio: float = negative_proportion / positive_proportion
        finalNegativeTargetTmp = int(finalNegativeRatio * positiveFeatureCount)
        finalNegativeTarget: int = finalNegativeTargetTmp if finalNegativeTargetTmp < negativeFeatureCount else negativeFeatureCount
        finalNegativeRatio: float = positive_proportion / negative_proportion
        finalPositiveTarget: int = int(finalNegativeRatio * finalNegativeTarget)
        featureTargetCount = finalNegativeTarget + finalPositiveTarget
    else:
        finalNegativeTarget: int = int(featureTargetCount * negative_proportion)
        finalPositiveTarget: int = int(featureTargetCount * positive_proportion)

    if negativeFeatureCount < finalNegativeTarget:
        raise ValueError("To few negative features for a final feature count of", featureTargetCount, "with", negative_proportion, "percent negative features.")
    elif positiveFeatureCount < finalPositiveTarget:
        raise ValueError("To few negative features for a final feature count of", featureTargetCount, "with", positive_proportion, "percent positive features.")

    positiveFeatures, negativeFeatures = conditionalSplit(features, filterPositive, finalPositiveTarget, finalNegativeTarget)

    print("Reconfigured data set has a positive/ negative label ratio of:", positive_proportion, "/", negative_proportion, "with", (finalPositiveTarget + finalNegativeTarget), "features.")
    return positiveFeatures + negativeFeatures