import csv
import os


# read a vsc file with the following format:
# first column of each row is the name of the repository
# other columns of each row represent all features of the repository
def read(filepath):
    with open(filepath, encoding='utf-8') as csvfile:
        reader = csv.reader(csvfile)
        names = []
        features = []
        for row in reader:
            names.append(row[0])
            features.append(row[1:])

        print("Red file:",  filepath)
        return names, features


# write content to a csv file
def write(filePath, content):
    with open(filePath, mode='w', encoding='utf-8') as csvfile:
        writer = csv.writer(csvfile, delimiter=',', quotechar='"', quoting=csv.QUOTE_ALL)
        for element in content:
            writer.writerow(element)

        print("Wrote to:", filePath)


def createDir(dirPath):
    os.mkdir(dirPath)
    print('Created directory: ' + dirPath)