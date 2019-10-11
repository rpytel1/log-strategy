import subprocess
import os
import time
from py4j.java_gateway import JavaGateway, GatewayParameters

class Extractor:
    def __init__(self, config, jar_path, max_path_length, max_path_width):
        self.config = config
        self.max_path_length = max_path_length
        self.max_path_width = max_path_width
        self.jar_path = jar_path

    def extract_processed(self, out, err, hash_to_string_dict, result):
        output = out.splitlines()
        if len(output) == 0:
            raise ValueError(err)
        for i, line in enumerate(output):
            parts = line.rstrip().split(' ')
            method_name = parts[0]
            current_result_line_parts = [method_name]
            contexts = parts[1:]
            for context in contexts[:self.config.MAX_CONTEXTS]:
                context_parts = context.split(',')
                context_word1 = context_parts[0]
                context_path = context_parts[1]
                context_word2 = context_parts[2]
                hashed_path = str(self.java_string_hashcode(context_path))
                hash_to_string_dict[hashed_path] = context_path
                current_result_line_parts += ['%s,%s,%s' % (context_word1, hashed_path, context_word2)]
            space_padding = ' ' * (self.config.MAX_CONTEXTS - len(contexts))
            result_line = ' '.join(current_result_line_parts) + space_padding
            result.append(result_line)
        return result, hash_to_string_dict

    def extract_java(self, path, hash_to_string_dict, result):
        gateway = JavaGateway(gateway_parameters=GatewayParameters(port=25335))
        syntaxChecker = gateway.entry_point

        out = syntaxChecker.extractFile(self.max_path_length, self.max_path_width, path)
        return self.extract_processed(str(out), "", hash_to_string_dict, result)

    def extract_paths(self, inputType, path):
        if inputType == '--dir':
            result = []
            hash_to_string_dict = {}
            for (dirpath, dirnames, filenames) in os.walk(path):
                print("Processing all java files at", dirpath, '.')
                for filename in filenames:
                    startTime = time.time()
                    filepath = os.path.normpath(dirpath + '/' + filename)
                    if os.path.isfile(filepath):
                        result, hash_to_string_dict = self.extract_java(dirpath + '/' + filename, hash_to_string_dict, result)
                        endTime = time.time()
                        executionTime = endTime - startTime
                        print("Processing", filename, 'at', dirpath, 'took', round(executionTime, 3), 'seconds.')
                    else:
                        print("Incorrect filepath:", filepath)
                print("Processed all java files at", dirpath, '.')
            return result, hash_to_string_dict
        elif inputType == '--file':
            return self.extract_java(path, {}, [])
        elif inputType == '--processed':
            print("Read processed java code from:", path)
            f = open(path, "r")
            out = f.read()
            f.close()
            return self.extract_processed(out, "", {}, [])
        else:
            raise ValueError("Invalid input type: ", inputType)

    @staticmethod
    def java_string_hashcode(s):
        """
        Imitating Java's String#hashCode, because the model is trained on hashed paths but we wish to
        Present the path attention on un-hashed paths.
        """
        h = 0
        for c in s:
            h = (31 * h + ord(c)) & 0xFFFFFFFF
        return ((h + 0x80000000) & 0xFFFFFFFF) - 0x80000000
