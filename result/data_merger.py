import progressbar

save_train_file = open("all_train_filteredRNN.txt", "w", encoding="utf-8")
save_test_file = open("all_test_filteredRNN.txt", "w", encoding="utf-8")

## TEST RATIO = 30%

files = [ "cassandra_filteredRNN.txt", "hadoop_filteredRNN.txt", "hive_filteredRNN.txt", "jmeter_filteredRNN.txt", "kafka_filteredRNN.txt",
         "maven_filteredRNN.txt", "tomcat_filteredRNN.txt"]

# Open directory and learn words

for file in files:
    d = open(file, "r", encoding="utf-8")
    for ind, elem in enumerate(d):
        if ind % 9 < 3:
            save_test_file.write(elem)
        else:
            save_train_file.write(elem)
    d.close()

save_train_file.close()
save_train_file.close()


