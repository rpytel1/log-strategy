from joblib import dump, load

def write_model(model, savepath: str):
    dump(model, savepath)
    print("Saved model to:", savepath)

def load_classifier(path: str):
    try:
        model = load(path)
        print("Model load from:", path)
        return model
    except FileNotFoundError:
        print("No model found at:", path)
        return None

def write(data , savepath: str, info:bool = True):
    data_count = len(data)
    print("Start writing", data_count, "data elements to", savepath)
    with open(savepath, "a+") as file:
        write_buffer = ""
        currentPercent = 0
        for id, element in enumerate(data):
            if info and id > 0 and id / data_count > currentPercent:
                print("Wrote", str(round(currentPercent, 2)), "percent of", data_count, "data elements to disk.")
                currentPercent += 0.05
            if id > 0 and id % 1000 == 0:
                file.write(write_buffer)
                write_buffer = ""
            write_buffer += str(element)
        file.write(write_buffer)
    print("Saved data to:", savepath)

