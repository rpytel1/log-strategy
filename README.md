## Data Mining and Extraction

Run  the app.java class in DataPreprocessor/TermExtractor/src/ the Parser with "-Xmx4g -Xmx8g -XX:+UseG1GC" compiler options.
Furthermore run DataMiner.py in DataPreprocessor/ and set INPUT_PATH to a directory containing all java classes as an argument.

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
