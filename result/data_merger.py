import random


class Element():
    def __init__(self, sign_elem, body_elem, label_elem):
        self.signature = sign_elem
        self.body = body_elem
        self.label = label_elem


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

elements = []
num_positive = 0
signature = ""
body = ""
label = ""
# Open files and read data
for file in files:
    d = open("filteredRNN/" + file, "r", encoding="utf-8")
    for ind, elem in enumerate(d):
        if ind % 3 == 0:
            signature = elem
        elif ind % 3 == 1:
            body = elem
        else:
            if elem.strip() == "1":
                num_positive += 1
            elem = Element(signature, body, elem)
            elements.append(elem)
    d.close()

random.shuffle(elements)

# Balance
positive_curr = 0
negative_curr = 0
positive_test = 0
negative_test = 0
balanced_elements = []
test_elements = []

test_set_size = 40000

for elem in elements:
    if elem.label.strip() == "1" and positive_curr < num_positive * 0.7:
        balanced_elements.append(elem)
        positive_curr += 1
    elif elem.label.strip() == "0" and negative_curr < int(4 * 0.7 * num_positive):
        balanced_elements.append(elem)
        negative_curr += 1

    # TEST SET
    elif elem.label.strip() == "1" and positive_test < 0.05 * test_set_size:
        test_elements.append(elem)
        positive_test += 1
    elif elem.label.strip() == "0" and negative_test < 0.95 * test_set_size:
        test_elements.append(elem)
        negative_test += 1

    if negative_test >= 0.95 * test_set_size and positive_test == 0.05 * test_set_size:
        print("broken")
        break

print("Size of trainset: " + str(len(balanced_elements)))
print("Positives in trainset: " + str(0.2 * len(balanced_elements)))

print("Size of testset: " + str(len(test_elements)))
print("Positives in testset:" + str(positive_test))

save_train_file = open("all_train_filteredRNN.txt", "w", encoding="utf-8")
save_test_file = open("all_test_filteredRNN.txt", "w", encoding="utf-8")
# Save to the file
for i, elem in enumerate(balanced_elements):
    save_train_file.write(elem.signature)
    save_train_file.write(elem.body)
    save_train_file.write(elem.label)

for i, elem in enumerate(test_elements):
    save_test_file.write(elem.signature)
    save_test_file.write(elem.body)
    save_test_file.write(elem.label)

save_train_file.close()
save_test_file.close()

# Size of trainset: 179141
# Positives in trainset: 35828.200000000004
# Size of testset: 40000
# Positives in testset:2000


