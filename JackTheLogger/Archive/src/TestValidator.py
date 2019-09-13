import numpy
import os
from CsvHelper import read
from Validator import validateTopicModel


def randomTest(trainingNames, validationNames, iterations = 1000):
    accuracy = 0

    combinedNames = validationNames + trainingNames
    idNameDict = dict()
    for index in range(len(combinedNames)):
        idNameDict[index] = combinedNames[index]

    for _ in range(iterations):
        similarityMatrix = numpy.random.rand(len(combinedNames), len(combinedNames))
        # fill diagonal with ones, for self similarity
        for i in range(len(validationNames)):
            similarityMatrix[i][i] = 1

        accuracy += validateTopicModel(similarityMatrix, idNameDict, range(len(validationNames)))

    print("Random accuracy:", accuracy / iterations)


# execute in parallel, otherwise it takes to long
if __name__ == '__main__':
    currentDir = os.path.dirname( __file__ )
    inputPathCuratedRaw = os.path.join(currentDir, '..', 'term_extractor/result/curated_repos_nocom.csv')
    inputPathCurated = os.path.abspath(inputPathCuratedRaw)

    inputPathTrainingRaw = os.path.join(currentDir, '..', 'term_extractor/result/top_repos_nocom.csv')
    inputPathTraining = os.path.abspath(inputPathTrainingRaw)

    validationNames, validationFeatures, trainingNames, trainingFeatures = [], [], [], []
    validationNames, validationFeatures = read(inputPathCurated)
    trainingNames, trainingFeatures =  read(inputPathTraining)

    randomTest(trainingNames, validationNames)

