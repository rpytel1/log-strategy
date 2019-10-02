from gensim import corpora
from typing import List, Dict, Tuple


# Create a corpus for all termlists (source code features) and return a dictionary with all actual terms and a list of bags of words
# For input use a prepocessed list of term lists representing an entire repository
def buildCorpus(featureLists: List[List[str]]) -> Tuple[Dict[int, str], List[Tuple[int, int]]]:
    # use this dictionary to lookup words based on their key in the bag of words
    dictionary = corpora.Dictionary(featureLists)

    # create a bag of words for each list of terms, a bag of words contains the amount of how often a term appears per document and a key for the actual term in the dictionary
    bagsOfWords = [dictionary.doc2bow(features) for features in featureLists]
    return (dictionary, bagsOfWords)

