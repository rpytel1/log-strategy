## Java Parser

Run the app.java class in src/TermExtractor to extract all functions from java classes.

Run the Parser with "-Xmx4g -Xmx8g -XX:+UseG1GC" compiler options and a path to a directory containing all java classes as an argument.

## Training
To run training of Neural network invoke:

```bash
python3 train.py -c config/config_test.json

```

Available configurations:
- char-based approach `char_config.json`
- word-based approach `word_config.json`

## Vizualization

To observe how learning rate is changing while training you have to open tensorboard. If training is happening 
on the cloud you need to open another session to the machine tunneling on 6006 port and invoke command:
```bash
tensorboard --logdir saved/
```
Then open `localhost:6006` to observe learning rates and more.  
## Requirements
- `pytroch`
- `tensorflow`
- `tensorboard`
- `tensorboardx`
- `progressbar2`

To install all of required libraries run: 
```bash
pip3 install -r requirements.txt
```