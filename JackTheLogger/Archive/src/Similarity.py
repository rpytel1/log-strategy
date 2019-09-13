from typing import List, Any
import numpy as np
import gensim


# create a similarity matrix for all of the topic models
# the matrix is a densely populated diagonal matrix
def calculateSimilarity(finalModel, corpus):
    modelSize = len(corpus)
    similarityMatrix = np.zeros(shape = (modelSize, modelSize), dtype = float)

    for currentDocumentIndex in range(modelSize):
        currentDocument = corpus[currentDocumentIndex]
        currentLdaVec = extractTopicDistribution(finalModel, currentDocument)

        for comparisonTopicModelIndex in range(modelSize):
            comparisonDocument = corpus[comparisonTopicModelIndex]
            comparisonLdaVec = extractTopicDistribution(finalModel, comparisonDocument)

            # similarity = calculateKullback_LeiblerSimilarity(currentLdaVec, comparisonLdaVec)
            # similarity = calculateJaccardSimilarity(currentLdaVec, comparisonLdaVec)
            similarity = calculateHellingerSimilarity(currentLdaVec, comparisonLdaVec, finalModel.num_topics)
            similarityMatrix[currentDocumentIndex, comparisonTopicModelIndex] = similarity

    return similarityMatrix


# Jaccard
# pretty buggy so far!
# calculate the similarity of two lists with Jaccard-Coefficient
# the return values ranges from 0 to 1, higher values are more similar
def calculateJaccardSimilarity(setLeft: List[Any], setRight: List[Any]) -> float:
    combinedElements: Int = len(union(setLeft, setRight))
    commonElements: Int = len(intersection(setLeft, setRight))
    similarity = (commonElements / combinedElements)

    return similarity


# implements union for two lists of variable sizes
def union(setLeft: List[Any], setRight: List[Any]) -> List[Any]:
    return list(set(setLeft) | set(setRight))


# implements intersection for two lists of variable sizes
def intersection(setLeft: List[Any], setRight: List[Any]) -> List[Any]:
    return list(set(setLeft) & set(setRight))


# Hellinger
def calculateHellingerSimilarity(ldaVecLeft, ldaVecRight, topicCount) -> float:
    densityLeft = gensim.matutils.sparse2full(ldaVecLeft, topicCount)
    densityRight = gensim.matutils.sparse2full(ldaVecRight, topicCount)
    distance = np.sqrt(0.5 * ((np.sqrt(densityLeft) - np.sqrt(densityRight))**2).sum())
    return 1 - distance


# Kullback Leibler
# https://en.wikipedia.org/wiki/Kullback%E2%80%93Leibler_divergence, https://en.wikipedia.org/wiki/Jensen%E2%80%93Shannon_divergence
def calculateKullback_LeiblerSimilarity(ldaVecLeft, ldaVecRight) -> float:
    distance = gensim.matutils.hellinger(ldaVecLeft, ldaVecRight)
    return 1 - distance


# Helper
def extractTopicDistribution(topicModel, corpus):
    topicDistribution = topicModel.get_document_topics(corpus, 0.0)
    return topicDistribution

