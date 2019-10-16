from nltk import FreqDist
from nltk.tokenize import word_tokenize
import pickle

CODE_DIR = "../result/"
WORTH_VOCAB_RATIO = 0.4

functions = []
word_dict = FreqDist()
signature = ""
files = ["beam_filteredRNN.txt", "camel_filteredRNN.txt", "cassandra_filteredRNN.txt", "flink_filteredRNN.txt",
         "hadoop_filteredRNN.txt", "hive_filteredRNN.txt", "jmeter_filteredRNN.txt", "kafka_filteredRNN.txt",
         "maven_filteredRNN.txt", "tomcat_filteredRNN.txt"]

# Open directory and learn words
for file in files:
    d = open(CODE_DIR + file, "r", encoding="utf-8")
    for ind, elem in enumerate(d):
        if ind % 3 == 0:
            signature = elem
        elif ind % 3 == 1:
            fdist = FreqDist(word.lower() for word in word_tokenize(signature + elem))
            word_dict.update(fdist)

# Take 50 % of most common words to vocabulary
worth = word_dict.most_common(int(WORTH_VOCAB_RATIO * len(word_dict)))
worth_vocab = [word for word, freq in worth]
print(len(worth_vocab))

# Save Vocabulary
with open(CODE_DIR + 'vocabulary.pickle', 'wb') as handle:
    pickle.dump(worth_vocab, handle, protocol=pickle.HIGHEST_PROTOCOL)
