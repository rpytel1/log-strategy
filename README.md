## Data Mining and Extraction

Run  the app.java class in DataPreprocessor/TermExtractor/src/ the Parser with "-Xmx4g -Xmx8g -XX:+UseG1GC" compiler options. Wait for py4j to open a gateway.
Afterwards run DataMiner.py in directory DataPreprocessor and set INPUT_PATH to a directory containing all java classes as an argument.
You can find the results in results directory in filteredCode2Vec and filteredRNN.

## code2vec Pretrained Codevectors
To generate the codevectors with code2vec run
 ```bash
    python3 code2vec.py --load PATH-TO-REPO/log-strategy/code2vec/models/java14_model/saved_model_iter8.release\
         --inputData PATH-TO-REPO/log-strategy/DataPreprocessor/data/filteredCode2Vec/ --representation
```

## Training the neural networks
To run training of Neural network navigate to JackTheLoggerNet and invoke:

```bash
python3 train.py -c config/config_test.json

```

Available configurations:
- char-based approaches are in `config/char_based/`
- word-based approach are in `config/word_config/`
- code2vec approach is in  `config/code_2_vec/`
- for single layer NN using pretrained vectors use `config/config_singlenn.json`

## Vizualization

To observe how learning rate is changing while training you have to open tensorboard. If training is happening 
on the cloud you need to open another session to the machine tunneling on 6006 port and invoke command:
```bash
tensorboard --logdir saved/
```
Then open `localhost:6006` to observe learning rates and more.  

## Requirements
- `Python >= 3.6`
- `Java >= 8`
- `Maven >= 2`
- `Python libraries specified in requirements.txt`

To install all of the required libraries for Python run: 
```bash
pip3 install -r requirements.txt
```
