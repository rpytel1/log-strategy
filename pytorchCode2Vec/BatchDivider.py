import torch

def numericalize(examples, n,BATCH_SIZE,MAX_LENGTH, node2idx,path2idx,target2idx):
    """
    Examples are a list of list of lists, i.e. examples[0] = [['left_node','path','right_node'], ...]
    n is how many batches we are getting our of `examples`

    Get a batch of raw (still strings) examples
    Create tensors to store them all
    Numericalize each raw example within the batch and convert whole batch tensor
    Yield tensor batch
    """
    global printBatch
    assert n*BATCH_SIZE <= len(examples)

    for i in range(n):

        #get the raw data

        raw_batch_label, raw_batch_body, batch_lengths = zip(*examples[BATCH_SIZE*i:BATCH_SIZE*(i+1)])

        #create a tensor to store the batch

        tensor_lab = torch.zeros(BATCH_SIZE).long() #name
        tensor_l = torch.zeros((BATCH_SIZE, MAX_LENGTH)).long() #left node
        tensor_p = torch.zeros((BATCH_SIZE, MAX_LENGTH)).long() #path
        tensor_r = torch.zeros((BATCH_SIZE, MAX_LENGTH)).long() #right node
        mask = torch.ones((BATCH_SIZE, MAX_LENGTH)).float() #mask


        #for each example in our raw data
        for j, (label, body, length) in enumerate(zip(raw_batch_label, raw_batch_body, batch_lengths)):

            #convert to idxs using vocab
            #use <unk> tokens if item doesn't exist inside vocab
            label = label[-1:]

            temp_lab = target2idx.get(label, target2idx['0'])
            #temporary left, path and right idx vectors
            temp_l, temp_p, temp_r = zip(*[(node2idx.get(l, node2idx['<unk>']), path2idx.get(p, path2idx['<unk>']), node2idx.get(r, node2idx['<unk>'])) for l, p, r in body])

            #store idxs inside tensors
            tensor_lab[j] = temp_lab
            tensor_l[j,:] = torch.LongTensor(temp_l)
            tensor_p[j,:] = torch.LongTensor(temp_p)
            tensor_r[j,:] = torch.LongTensor(temp_r)

            #create masks
            mask[j, length:] = 0


        yield tensor_lab, tensor_l, tensor_p, tensor_r, mask
