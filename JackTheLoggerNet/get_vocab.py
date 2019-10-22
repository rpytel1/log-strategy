from nltk import FreqDist
from nltk.tokenize import word_tokenize
import pickle

CODE_DIR = "../result/filteredRNN/"
WORTH_VOCAB_RATIO = 0.1

functions = []
word_dict = FreqDist()
signature = ""
files = ["activemq_filteredRNN.txt",
         "ambari_filteredRNN.txt",
         "avro_filteredRNN.txt",
         "beam_filteredRNN.txt",
         "calcite_filteredRNN.txt",
         "camel_filteredRNN.txt",
         "cassandra_filteredRNN.txt",
         "cloudstack_filteredRNN.txt",
         "codevectors_labeled_filteredRNN.txt",
         "curator_filteredRNN.txt",
         "drill_filteredRNN.txt",
         "elasticsearch_filteredRNN.txt",
         "fastText_java_filteredRNN.txt",
         "flink_filteredRNN.txt",
         "flume_filteredRNN.txt",
         "geode_filteredRNN.txt",
         "groovy_filteredRNN.txt",
         "hadoop_filteredRNN.txt",
         "hbase_filteredRNN.txt",
         "hive_filteredRNN.txt",
         "jmeter_filteredRNN.txt",
         "kafka_filteredRNN.txt",
         "kylin_filteredRNN.txt",
         "lucene-solr_filteredRNN.txt",
         "mahout_filteredRNN.txt",
         "maven_filteredRNN.txt",
         "nifi_filteredRNN.txt",
         "nutch_filteredRNN.txt",
         "parquet-mr_filteredRNN.txt",
         "shiro_filteredRNN.txt",
         "storm_filteredRNN.txt",
         "tomcat_filteredRNN.txt",
         "zeppelin_filteredRNN.txt",
         "zookeeper_filteredRNN.txt"]

# Open directory and learn words
for file in files:
    d = open(CODE_DIR + file, "r", encoding="utf-8")
    for ind, elem in enumerate(d):
        if ind % 3 == 0:
            signature = elem
        elif ind % 3 == 1:
            fdist = FreqDist(word.lower() for word in word_tokenize(signature.strip() + elem.strip()))
            word_dict.update(fdist)

# Take 50 % of most common words to vocabulary
worth = word_dict.most_common(int(WORTH_VOCAB_RATIO * len(word_dict)))
worth_vocab = [word for word, freq in worth]
print(len(worth_vocab))

# Save Vocabulary
with open(CODE_DIR + 'vocabulary.pickle', 'wb') as handle:
    pickle.dump(worth_vocab, handle, protocol=pickle.HIGHEST_PROTOCOL)
