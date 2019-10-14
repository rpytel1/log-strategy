import os

def parse_line(line):
    """
    Takes a string 'x y1,p1,z1 y2,p2,z2 ... yn,pn,zn and splits into name (x) and tree [[y1,p1,z1], ...]
    """
    name, *tree = line.split(' ')
    tree = [t.split(',') for t in tree if t != '' and t != '\n']

    return name, tree


def file_iterator(file_path, MAX_LENGTH):
    """
    Takes a file path and creates and iterator
    For each line in the file, parse into a name and tree
    Pad tree to maximum length
    Yields example:
    - example_name = 'target'
    - example_body = [['left_node','path','right_node'], ...]
    """

    with open(file_path, 'r') as f:

        for line in f:

            #each line is an example

            #each example is made of the function name and then a sequence of triplets
            #the triplets are (node, path, node)

            example_name, example_body = parse_line(line)


            #max length set while preprocessing, make sure none longer

            example_length = len(example_body)

            assert example_length <= MAX_LENGTH

            #need to pad all to maximum length

            example_body += [['<pad>', '<pad>', '<pad>']]*(MAX_LENGTH - example_length)

            assert len(example_body) == MAX_LENGTH


            yield example_name, example_body, example_length
