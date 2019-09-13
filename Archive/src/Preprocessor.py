from stop_words import get_stop_words
from nltk.stem.porter import PorterStemmer
from Utils import flatten, toLower
from typing import List, Any
import re


# Process the data by splitting, stop word removal and stemming. Optionally add smoothing, as described by Panichella.
# Preprocessing massively increases the quality of the input data for the semantic text analysis and reduces the load.
# Input: list of list of terms, parsed from java classes
# Output: list of list of terms
def preProcess(termLists: List[Any]) -> List[Any]:
    return [preProcessSingle(termList) for termList in termLists]


def preProcessSingle(termList: List[str]) -> List[Any]:
    splitTerms = flatten([splitTerm(term) for term in termList])
    cleanedTerms = removeStopWords(splitTerms)
    lowerTerms = toLower(cleanedTerms)
    cleanedTerms = removeStopWords(lowerTerms)
    stemmedTerms = stem(cleanedTerms)
    return stemmedTerms


#----SPLITTING----
# split the term by e.g. camel case, as a preparationn for stop word removal and smoothing
def splitTerm(term: str) -> List[str]:
    splittedCamel = splitCamelCase(term)
    splittedUnderscore = flatten([splitUnderscore(term) for term in splittedCamel])
    splittedDot = flatten([splitDot(term) for term in splittedUnderscore])

    # could be done more efficiently, but probably not worth the effort
    if len(splittedDot) > 1:
        return [splitTerm(term) for term in splittedDot]
    return term


def splitCamelCase(term: str) -> List[str]:
    splitTerms = re.finditer('.+?(?:(?<=[a-z])(?=[A-Z])|(?<=[A-Z])(?=[A-Z][a-z])|$)', term)
    return [newTerm.group(0) for newTerm in splitTerms]


def splitUnderscore(term: str) -> List[str]:
    # splitTerms = re.finditer('.+?(?:(?<=[a-z])(?=[A-Z])|(?<=[A-Z])(?=[A-Z][a-z])|$)', term)
    # return [newTerm.group(0) for newTerm in splitTerms]
    return re.split('_', term)


def splitDot(term: str) -> List[str]:
    # splitTerms = re.finditer('.+?(?:(?<=[a-z])(?=[A-Z])|(?<=[A-Z])(?=[A-Z][a-z])|$)', term)
    # return [newTerm.group(0) for newTerm in splitTerms]
    return term.split('.')



#----STOP WORD REMOVAL----
# remove all stop words from the given list of terms
# make sure to split the terms before, otherwise stop word removal does not work as intended
def removeStopWords(termList: List[str]) -> List[str]:
    cleanEnglish = removeStopWordsEnglish(termList)
    cleanJava = removeStopWordsJava(cleanEnglish)
    longTerms = removeShortWords(cleanJava)
    return longTerms


# remove all english stop words from the given list of terms, e.g. is, a, the
def removeStopWordsEnglish(termList: List[str]) -> List[str]:
    stopListEnglish = toLower(get_stop_words('en'))
    return removeStopWordsCustom(termList, stopListEnglish)


# remove all java specific stop words from the given list of terms, e.g. get or set
def removeStopWordsJava(termList: List[str]) -> List[str]:
    stopListJava = toLower(['return', 'get', 'set', 'object', 'class', 'import', 'delete', 'remove', 'isA', 'typeOf',
                    'type', 'create', 'build', 'find', 'print', 'debug', 'abstract', 'assert', 'boolean', 'break',
                    'byte', 'case', 'catch', 'char', 'class', 'continue', 'default', 'split', 'open', 'close', 'None',
                    'Null', 'List', 'handler', 'empty', 'instance', 'exception', 'error', 'manager',
                    'params', 'init', 'String', 'begin', 'end', 'clear', 'to', 'test', 'main', 'Array', 'Map', 'Set', 'is',
                    'Logger', 'Log', 'Factory', 'Observer', 'Instance', 'run', 'exec', 'calc', 'Service', 'thread', 'async',
                    'Application', 'App', 'Util', 'Utility', 'check', 'update', 'value', 'executor', 'interface', 'key',
                    'next', 'previous', 'non', 'current', 'Adapter', 'Tree', 'Model', 'nullable', 'validate', 'use', 'context',
                    'builder', 'not', 'mock', 'equals', 'has', 'bean', 'config'])
    return removeStopWordsCustom(termList, stopListJava)


# remove all words with length 2 or shorter
def removeShortWords(termList: List[str]) -> List[str]:
    return [term for term in termList if not len(term) < 3]


def removeStopWordsCustom(termList: List[str], stopWordList: List[str]) -> List[str]:
    return [term for term in termList if not term.lower() in stopWordList]


#----STEMMING----
# stem all terms with the Porter Stemmer, because it was recommended in The impact of Classifier Configuration and Classifier Combination on Bug Localization
# e.g. configure, configuration, configs -> config
# make sure to split the terms before, otherwise stop word removal does not work as intended. Also, apply stop word removal before and after the stemming, to not miss any stopwords and simplify stemming.
def stem(termList: List[str]) -> List[str]:
    porterStemmer = PorterStemmer()
    stemmedTerms = [porterStemmer.stem(term) for term in termList]
    return stemmedTerms