from torch import nn
import torch
import numpy as np

class Network(nn.Module):
    def __init__(self):
        super().__init__()

        self.inputSize = 384
        self.hiddenSize = 128
        self.outputSize = 1
        #384 input features (code2vec vector is 96*4), 128
        self.hidden = nn.Linear(self.inputSize, self.hiddenSize)
        #binary classifier
        self.output = nn.Linear(self.hiddenSize, self.outputSize)

        ##init weights
        self.w1 = torch.randn(self.inputSize, self.hiddenSize)
        self.w2 = torch.randn(self.hiddenSize, self.outputSize)

        self.sigmoid = nn.Sigmoid()
        self.softmax = nn.Softmax(dim=1)
        ## initialize tensor for inputs, and outputs 
        self.x = torch.randn((1, self.inputSize))
        self.y = torch.randn((1, self.outputSize)) 
        self.b1 = torch.randn((1, self.hiddenSize)) # bias for hidden layer
        self.b2 = torch.randn((1, self.outputSize)) # bias for output layer

        self.learning_rate = 0.1

        self.correct = 0
        self.incorrect = 0


    def sigmoid_activation(x):
        return 1 / (1 + torch.exp(-x))

    def sigmoid_delta(x):
        return x * (1 - x)

    def forward(self, x):
        ##activate hidden layer
        self.z1 = torch.mm(x, self.w1) + self.b1
        self.a1 = sigmoid_activation(self.z1)

        ##activate output
        self.z2 = torch.mm(self.a1, self.w2) + self.b2
        output = sigmoid_activation(self.z2)
        
        return output
    
    def backward(self, x, label, output):
        loss = label - output
        
        delta_output = sigmoid_delta(output)
        delta_hidden = sigmoid_delta(self.a1)
        
        ## backpass the changes to previous layers 
        d_outp = loss * delta_output
        loss_h = torch.mm(d_outp, w2.t())
        d_hidn = loss_h * delta_hidden

        ##update params
        self.w2 += torch.mm(self.a1.t(), d_outp) * self.learning_rate
        self.w1 += torch.mm(x.t(), d_hidn) * self.learning_rate

        self.b2 += d_outp.sum() * self.learning_rate
        self.b1 += d_hidn.sum() * self.learning_rate

    def trainModel(self, result):
        forwardout = model.forward(torch.tensor(result.vector, dtype=torch.float))
        backward(torch.tensor(result.vector, dtype=torch.float), result.label, forwardout)

    def testModel(self, result):
        output = model.forward(torch.tensor(result.vector, dtype=torch.float))
        if (output == result.label):
            self.correct += 1
        else:
            self.incorrect += 1
        

class Code2VecData:
    funcname = ''
    label = -1
    vector = []

def readFile(y, optype):

    
    f = open(y)
    lines = f.readlines();
    f.close()
    
    counter = 0

    result = Code2VecData()
    for l in lines:
        if (counter == 0):
            result.funcname = l
            counter += 1
        elif (counter == 1):
            result.label = int(l)
            counter += 1
        elif (counter == 2):
            l = l[1:]
            arr = np.array(l.split())
            result.vector.extend(arr.astype(np.float))
            counter += 1
        elif (counter == 3):
            if (l[-2] == ']'):
                counter = 0
                l = l[:-2]
                arr = np.array(l.split())
                result.vector.extend(arr.astype(np.float))

                
                #Do nn logic here (then not everything needs to be in memory)
                #print(result.vector)
                if (optype == 'train'):
                    model.trainModel(result)
                if (optype == 'test'):
                    model.testModel(result)
                    

    
                    
                #reset
                result.vector = []
            else:
                arr = np.array(l.split())
                result.vector.extend(arr.astype(np.float))
    print("Done " + optype + "ing")


#init network
model = Network()
#TODO: change training to support epochs
readFile("code2vec/result/codevectors_labeled_train.txt", 'train')
readFile("code2vec/result/codevectors_labeled_test.txt", 'test')
print("Correct: " + str(model.correct))
print("Incorrect: " + str(model.incorrect))


    
