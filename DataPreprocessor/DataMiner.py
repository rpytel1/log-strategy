from py4j.java_gateway import JavaGateway, GatewayParameters
from LogLabeler import label
from organizeDataForCode2Vec import prepare

#Change to the folder with your repositories
INPUT_PATH = "C://Users//Jan//Desktop//Repositories"
#Change to your preferred output path
METHODS_SAVE_PATH = "C://Users//Jan//Desktop//log-strategy//DataPreprocessor//data"


if __name__ == '__main__':
    gateway = JavaGateway(gateway_parameters=GatewayParameters(port=25335))
    java_extractor = gateway.entry_point

    # 0.
    print("Please run the TermExtractor.App class with VM arguments: -Xmx4g -Xmx8g -XX:+UseG1GC.")

    # 1. extract java methods from git repositories
    print("Extracting java methods with JavaExtractor from", INPUT_PATH)
    success = java_extractor.extractMethods(INPUT_PATH, METHODS_SAVE_PATH)
    if not success:
        raise ValueError("Invalid path to repositories:", INPUT_PATH)

    # 2. label data and remove logs from method bodies
    label(METHODS_SAVE_PATH, java_extractor)

    # 3. prepare the data for code2vec, by chunking it into small files
    prepare(METHODS_SAVE_PATH + "//filteredCode2Vec", METHODS_SAVE_PATH + "//filteredCode2Vec")

    #4.
    print("To generate the codevectors with code2vec run the following code2vec.py with these arguments:\n",
          "--load C:/PATH-TO-REPO/log-strategy/code2vec/models/java14_model/saved_model_iter8.release\n" 
          "--inputData C:/PATH-TO-REPO/log-strategy/DataPreprocessor/data/filteredCode2Vec/ --representation")
