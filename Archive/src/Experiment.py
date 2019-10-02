from Evaluation import evaluateModels, plot, selectTopicModel
from TopicModeler import modelTopics
from Similarity import calculateSimilarity
from CsvHelper import read, write, createDir
from Validator import validateTopicModel
from Utils import save_sim_matrix_plot

import os
import time
import datetime

def experiment():
    currentDir = os.path.dirname( __file__ )
    inputPathCuratedRaw = os.path.join(currentDir, '..', 'term_extractor/result/curated_repos_nocom.csv')
    inputPathCurated = os.path.abspath(inputPathCuratedRaw)

    inputPathTrainingRaw = os.path.join(currentDir, '..', 'term_extractor/result/top_repos_nocom.csv')
    inputPathTraining = os.path.abspath(inputPathTrainingRaw)

    validationNames, validationFeatures, trainingNames, trainingFeatures = [], [], [], []
    validationNames, validationFeatures = read(inputPathCurated)
    # trainingNames, trainingFeatures =  read(inputPathTraining)
    for i in range(139,142):
        now = datetime.datetime.now()
        dateTime = now.strftime("%d-%m-%Y-%H-%M")
        experimentDescription = str(i) + '_' + dateTime + "Full-NoComments"
        pipeline(experimentDescription, trainingNames, validationNames, trainingFeatures, validationFeatures)


def pipeline(description, trainingNames, validationNames, trainingFeatureLists, valiationFeatureLists):
    print('\n-----------------------EXPERIMENT STARTED-----------------------')
    print(description, '\n')

    startTime = time.time()

    currentDir = os.path.dirname( __file__ )
    experimentPathRaw = os.path.join(currentDir, '..', "results/" + description)
    experimentPath = os.path.abspath(experimentPathRaw)

    # generate a topic model from the raw input, with each document in the model representing an entire repository
    # (topicModels, dictionary, corpus, processedFeatures, topicCounts)
    documentFeatureLists = valiationFeatureLists + trainingFeatureLists
    repositoryNames = validationNames + trainingNames

    topicLimit = min(128, len(repositoryNames) - 1)
    topicModels, dictionary, corpus, repositoryFeatures, topicCounts, alphas, betas = modelTopics(documentFeatureLists, 2, topicLimit)

    # evaluate the generated models to find the best one
    silhouetteScores, coherenceScores = evaluateModels(topicModels, topicCounts, dictionary, corpus, repositoryFeatures)
    parameters = [str(topicCount) + "; " + alpha + "; " + beta for topicCount, alpha, beta in zip(topicCounts, alphas, betas)]
    # plot(parameters, silhouetteScores, "silhouetteScore", "# topics, alpha, beta")

    print('Silhouette Scores:', silhouetteScores)
    print('Coherence Scores:', coherenceScores)
    # select the best topic model based in the coherenceScores
    finalModel, modelIndex = selectTopicModel(topicModels, silhouetteScores, coherenceScores)

    # create a similarity matrix for all documents in the topic model
    similarityMatrix = calculateSimilarity(finalModel, corpus)


    idNameDict = dict()
    for index in range(len(documentFeatureLists)):
        idNameDict[index] = repositoryNames[index]
    accuracy = validateTopicModel(similarityMatrix, idNameDict, range(len(validationNames)))

    endTime = time.time()
    executionTime = endTime - startTime

    # results
    createDir(experimentPath)
    print('\n-----------------------RESULTS-----------------------')
    print('Model with index', modelIndex, 'has an accuracy of', accuracy, ' and took: ', executionTime, 'seconds.')
    print('Parameters:', parameters[modelIndex])
    print('Silhouette Score:', silhouetteScores[modelIndex])
    print('Coherence Score:', coherenceScores[modelIndex])
    print('\nSimilarity matrix:', similarityMatrix)
    print('-----------------------END RESULTS-----------------------\n')

    # create similarity matrix and compute accuracy for all topic models, to evaluate correctness of topic selection
    similarityMatrices = []
    accuracies = []
    for currentModel in range(len(parameters)):
        currentSimilarityMatrix = calculateSimilarity(topicModels[currentModel], corpus)
        similarityMatrices.append(currentSimilarityMatrix)
        currentAccuracy = validateTopicModel(currentSimilarityMatrix, idNameDict, range(len(validationNames)))
        accuracies.append(currentAccuracy)

    # save experiment data
    resultDump = storeExperimentResults(description, modelIndex, executionTime, parameters, accuracies, silhouetteScores, coherenceScores, similarityMatrices)
    write(experimentPath + "/results.csv", resultDump)
    write(experimentPath + "/processedFeatures.csv", repositoryFeatures)
    save_sim_matrix_plot(similarityMatrix, experimentPath, 'Similarity')
    print('-----------------------EXPERIMENT FINISHED-----------------------\n')


# stores the experiment result in a csv file, which can be easily imported into sheets
def storeExperimentResults(description, modelIndex, executionTime, parameters, accuracies, silhouetteScores, coherenceScores, similarityMatrices):
    # List[Experiment Description, Model Index, Execution Time, Model Accuracy, Parameters, Silhouette Score, Coherence Score, Similarity Matrix]
    outputData = []

    # store all experiment data for all topic model configurations
    for currentModel in range(len(parameters)):
        accuracy = accuracies[currentModel]
        parameter = parameters[currentModel]
        silhouetteScore = silhouetteScores[currentModel]
        coherenceScore = coherenceScores[currentModel]
        similarityMatrix = similarityMatrices[currentModel]
        outputData.append([description, modelIndex, executionTime, accuracy, parameter, silhouetteScore, coherenceScore, similarityMatrix])

    return outputData

# execute in parallel, otherwise it takes to long
if __name__ == '__main__':
    experiment().runInParallel(numProcesses=4, numThreads=8)