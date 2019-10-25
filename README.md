## Data Extraction and Preprocessing

1. Run  the App.java class in DataPreprocessor/TermExtractor/src/ the Parser with "-Xmx4g -Xmx8g -XX:+UseG1GC" compiler options. Wait for py4j to open a gateway.
2. Afterwards run DataMiner.py in directory DataPreprocessor and set INPUT_PATH to a directory containing all java classes as an argument.
3. You can find the results in results directory in filteredCode2 and filteredRNN.

## Already Custom Preprocessed Data can be downloaded from
https://drive.google.com/drive/folders/1z2A7IRtdZ6gCILysk_ai9eGGG4po6ZHa?usp=sharing

## Generate Code Vectors from Custom Trained code2vec

1. Preprocess your data as described in section "Data Extraction and Preprocessing"
2. Split your data from result/filteredCode2Vec/ into train, test and validation
3. Move the split data to directory /code2vec into folders train, test and val
4. Go to code2vec/JavaExtractor/JPredict/src/main/java/JavaExtractor and run App.java. Wait for py4j to open a gateway.
5. Go to code2vec/preprocess.sh and run it.
6. Move produced files from data/preprocessed_code to JackTheLoggerNet/data/preprocessed_code/ (Be sure that preprocessed_code.dict.c2v is a dictionary on which model was trained)
7. Run
```bash
python3 extract_code_vectors.py --resume PATH_TO_MODEL --file my_dataset.train.c2v   
```
Code vectors will be in jan_train.txt

## code2vec Pretrained Codevectors
To generate the codevectors with code2vec run code2vec.py in the code2vec folder with these arguments
 ```bash
    python3 code2vec.py --load PATH-TO-REPO/log-strategy/code2vec/models/java14_model/saved_model_iter8.release\
         --inputData PATH-TO-REPO/log-strategy/DataPreprocessor/data/filteredCode2Vec/ --representation
```
This creates a single .txt file which can be used as a training or testing set.
Files that are inside the --inputData path are included in the .txt file.

To balance the data use the 

**Alternatively, you can download the pretrained code2vec train and test sets used in the paper from
the links stated in the issues**

## Training (NN)
Adjust the path to the training and testing set, whether you want to use a gpu, and other factors in the config files.
To run training of neural network approaches navigate to JackTheLoggerNet and invoke:

```bash
python3 train.py -c config/config_test.json

```

Available configurations:
- char-based approaches are in `config/char_based/`
- word-based approach are in `config/word_config/`
- code2vec (custom) approach is in  `config/code_2_vec/`
- for single layer NN using pretrained vectors use `config/config_singlenn.json`



## Train SVM and RFC

1. Extract the methods first and preprocess it, as explained in "Data Extraction and Preprocessing" section
2. Go to Classifier/Trainer
   1. Set the variable TRAINING_DATA_PATH to a .txt file with your labeled code vectors for training
   2. Set the variable POSITIVE_RATIO to the desired amount of positive labels in your train data
3. Run Trainer.py
   1. The trained classifiers are saved to result/Classifier/
4. To evaluate your classifier got to Classifier/Evaluation:
   1. Set TEST_DATA_PATH to a .txt file with your labeled code vectors for testing
5. Run Evaluation.py
   1. The evaluation will contain accuracy, jaccard index, precision, recall and balanced accuracy
   2. The evaluation results are saved to "/result/Classifier/Classifier_Evaluation_Statistics.txt"

   
## Visualization (NN)

To observe how learning rate is changing while training you have to open tensorboard. If training is happening 
on the cloud you need to open another session to the machine tunneling on 6006 port and invoke command:
```bash
tensorboard --logdir saved/
```
Then open `localhost:6006` to observe learning rates and more.  

## Testing (NN)
To run testing of neural network approaches invoke:

```bash
python3 test.py -r saved/MODELNAME/RUNTIMESTAMP/model_best.pth

```
Where MODELNAME = the name of the model you trained (see config)

and RUNTIMESTAMP = a timestamp in the form: 1016_174555 for the 16th of october
17:45:55

The results will be printed on screen.


## Requirements

- `Python >= 3.6`
- `Java >= 8`
- `Maven >= 2`
- `Python libraries specified in requirements.txt`

To install all of the required libraries for Python run: 
```bash
pip3 install -r requirements.txt
```
