import random

import progressbar


## TEST RATIO = 30%

class Element():
    def __init__(self, sign_elem, body_elem, label_elem):
        self.signature = sign_elem
        self.body = body_elem
        self.label = label_elem


files = ["beam_filteredRNN.txt", "camel_filteredRNN.txt", "cassandra_filteredRNN.txt", "flink_filteredRNN.txt",
         "hadoop_filteredRNN.txt", "hive_filteredRNN.txt", "jmeter_filteredRNN.txt", "kafka_filteredRNN.txt",
         "maven_filteredRNN.txt", "tomcat_filteredRNN.txt"]

elements = []
num_positive = 0
signature = ""
body = ""
label = ""
# Open files and read data
for file in files:
    d = open("../result/" + file, "r", encoding="utf-8")
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
test_set_size = 0
balanced_elements = []
test_elements = []

for elem in elements:
    if elem.label.strip() == "1" and positive_curr < num_positive:
        balanced_elements.append(elem)
        positive_curr += 1
    elif elem.label.strip() == "0" and negative_curr < int(4 * num_positive):
        balanced_elements.append(elem)
        negative_curr += 1
    elif test_set_size < 0.1*len(elements):
        test_elements.append(elem)
        test_set_size += 1

    if positive_curr == num_positive and negative_curr == num_positive and test_set_size == num_positive:
        break

print(len(balanced_elements))
print(len(test_elements))

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
