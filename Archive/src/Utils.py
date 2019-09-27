from typing import List, Any
import matplotlib.pyplot as plt
import numpy as np


# a little helper to flatten lists, not flattening strings
def flatten(unevenList: List[Any]) -> List[Any]:
    flattenedList = []
    for subList in unevenList:
        if isinstance(subList, list) and not isinstance(subList, (str, bytes)):
            for element in subList:
                flattenedList.append(element)
        else:
            flattenedList.append(subList)
    return flattenedList


# make all strings in a list to lower
def toLower(termList: List[str]) -> List[str]:
    return list(map(lambda term: term.lower(), termList))

_DEFAULT_IMAGE_FIGSIZE = (7, 7)


def save_sim_matrix_plot(matrix, experiment_dir, title=''):
    fig, ax = plt.subplots(figsize=(20, 20))
    cax = ax.matshow(matrix, interpolation='nearest')
    ax.grid(True)
    plt.title('title')
    #fig.colorbar(cax, ticks=[0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, .75, .8, .85, .90, .95, 1])
    plt.savefig(experiment_dir + "/" + title + ".png", dpi=150)