from joblib import dump, load

def save(model, savepath: str):
    dump(model, savepath)
    print("Saved model to:", savepath)

def loadModel(path: str):
    try:
        model = load(path)
        print("Model load from:", path)
        return model
    except FileNotFoundError:
        print("No model found at:", path)
        return None
