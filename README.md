## Data Mining and Extraction

Run  the app.java class in DataPreprocessor/TermExtractor/src/ the Parser with "-Xmx4g -Xmx8g -XX:+UseG1GC" compiler options. Wait for py4j to open a gateway.
Afterwards run DataMiner.py in directory DataPreprocessor and set INPUT_PATH to a directory containing all java classes as an argument.
You can find the results in results directory in filteredCode2 and filteredRNN.

## Download preprocessed data for training embeddings

## To preprocess your own data
- 'start the java extractor app'
- 'set the balanced training, validation and test datasets into directories train, val and test respectively.'
- 'run preprocess.sh'

## Training
To run training of Neural network invoke:

```bash
python3 train.py -c config/config_test.json

```

Available configurations:
- char-based approach `char_config.json`
- word-based approach `word_config.json`
- code2vec approach  `code2vec.json`

## Vizualization

To observe how learning rate is changing while training you have to open tensorboard. If training is happening 
on the cloud you need to open another session to the machine tunneling on 6006 port and invoke command:
```bash
tensorboard --logdir saved/
```
Then open `localhost:6006` to observe learning rates and more.  
## Requirements
- `Python >= 3.7`
- `Java >= 8`
- `Maven >= 2`
- `Python libraries specified in requirements.txt`

To install all of the required libraries for Python run: 
```bash
pip3 install -r requirements.txt
```
