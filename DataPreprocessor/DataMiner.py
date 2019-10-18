from py4j.java_gateway import JavaGateway, GatewayParameters
from LogLabeler import label
from organizeDataForCode2Vec import prepare


INPUT_PATH = "C://Users//Jan//Desktop//Repositories"
METHODS_SAVE_PATH = "C://Users//Jan//Desktop//log-strategy//DataPreprocessor//data"


if __name__ == '__main__':
    gateway = JavaGateway(gateway_parameters=GatewayParameters(port=25335))
    java_extractor = gateway.entry_point

    # 0.
    print("Please run the TermExtractor.App class with VM arguments: -Xmx4g -Xmx8g -XX:+UseG1GC.")

    # 1. extract java methods from git repositories
    success = java_extractor.extractMethods(INPUT_PATH, METHODS_SAVE_PATH)
    if not success:
        raise ValueError("Invalid path to repositories:", INPUT_PATH)

    # 2. label data and remove logs from method bodies
    label(METHODS_SAVE_PATH, java_extractor)

    # 3. prepare the data for code2vec, by chunking it into small files
    prepare(METHODS_SAVE_PATH + "//filteredCode2Vec", METHODS_SAVE_PATH + "//filteredCode2Vec")
