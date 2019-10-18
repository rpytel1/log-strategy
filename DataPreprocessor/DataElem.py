class DataElem:
    def __init__(self, function_name, signature, body, function_id, label):

            self.function_name = function_name
            self.signature = signature
            self.body = body
            self.label = label
            self.function_id = function_id

    def __str__(self):
        return self.function_name + '\n' \
               + self.signature \
               + self.body \
               + self.function_id + '\n' \
               + self.label + '\n'

    def getJavaRepresentation(self) -> str:
        return self.signature \
               + self.body \

