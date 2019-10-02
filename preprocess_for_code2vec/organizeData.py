import os

import subprocess

from preprocess_for_code2vec.DataElem import DataElem

CODE2VEC_PATH = "/Users/rafalpytel/code2vec"
f = open('../tag_remove_log/kafkatest_filtered.txt', "r", encoding='utf-8')
lines = f.readlines()
f.close()

index = 0

# CURRENT VERSION IS RANDOM SAMPLING
body = ""
label = -1
signature = ""
function_name = ""
data = []

# Read data to the structure
for id, l in enumerate(lines):
    if id % 4 == 0:
        function_name = l
    if id % 4 == 1:
        signature = l
    elif id % 4 == 2:
        # SAVE BODY
        body = l
    elif id % 4 == 3:
        label = int(l)
        if body.strip() != "{}":  # TODO: Maybe do smth else here
            elem = DataElem(function_name, signature, body, label)
            data.append(elem)
        else:
            print(body)

# Organize Data into split 5/2/3
if not os.path.isdir("val"):
    os.mkdir("val")

if not os.path.isdir("train"):
    os.mkdir("train")

if not os.path.isdir("test"):
    os.mkdir("test")

f_train_feats = open("train/train.java", "w", encoding="utf-8")
f_train_labels = open("train_lables.txt", "w", encoding="utf-8")

f_test_feats = open("test/test.java", "w", encoding="utf-8")
f_test_labels = open("test_lables.txt", "w", encoding="utf-8")

f_val_feats = open("val/val.java", "w", encoding="utf-8")
f_val_labels = open("val_lables.txt", "w", encoding="utf-8")

print(len(data))

for id, elem in enumerate(data):
    if id % 10 < 5:
        f_train_feats.write(elem.signature + elem.body)
        f_train_labels.write(str(elem.label) + "\n")

    elif 7 > id % 10 >= 5:
        f_test_feats.write(elem.signature + elem.body)
        f_test_labels.write(str(elem.label) + "\n")
    else:
        f_val_feats.write(elem.signature + elem.body)
        f_val_labels.write(str(elem.body) + "\n")

f_train_feats.close()
f_train_labels.close()

f_test_feats.close()
f_test_labels.close()

f_val_feats.close()
f_val_labels.close()

# RUN PREPROCESS
os.chdir(CODE2VEC_PATH)
subprocess.call('sh preprocess_code.sh', shell=True)
