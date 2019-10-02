from Evaluation import normalizeSilhouetteScore, calculateSilhouetteCoherenceScore


# test normalizeSilhouetteScore:
testSilhouetteScores = [-1, 1, 0, -0.5, 0.5, 0.2]
expectedNormalizedSilhouetteScores = [0, 1, 0.5, 0.25, 0.75, 0.6]
testSilhouetteScoresNormalized = [normalizeSilhouetteScore(silhouette) for silhouette in testSilhouetteScores]

assert expectedNormalizedSilhouetteScores == testSilhouetteScoresNormalized, 'incorrect silhouette score normalization'


# test calculateSilhouetteCoherenceScore
testSilhouetteScores = [-1, 1, 0, -0.4, 0.5, 0.2]
testCoherenceScores = [1, 1, 1, 0.4, 0, 0.2]
expectedResult = [0.5, 1, 0.75, 0.35, 0.375, 0.4]
testCombinedScores = calculateSilhouetteCoherenceScore(testSilhouetteScores, testCoherenceScores)
assert testCombinedScores == expectedResult, 'incorrect combination of silhouette and coherence scores'
