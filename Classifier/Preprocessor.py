from SampleReader import statistics, extractSamples, shuffle_data, rebalance_data
from Persistence import write


RAW_DATA_PATH = "..//result//codevectors//codevectors_labeled.txt"
PROCESSED_DATA_PATH = "..//result//codevectors//codevectors_labeled_shuffled_test02.txt"
STEP_SIZE = 6000000


def write_rebalanced_shuffled_data(file_in, save_path: str, stop: int = -1, balance: float = -1, step: int = 60000):
    eof = False
    sample_count: int = 0
    while not eof and (stop < 0 or sample_count < stop):
        samples, eof = extractSamples(file_in, min(step, max(stop - sample_count, 100) if stop > 0 else step))
        if balance > 0:
            samples = rebalance_data(samples, balance)
        else:
            samples = shuffle_data(samples)
        sample_count += len(samples)
        write(samples, save_path)


if __name__ == '__main__':
    sample_count, positive_count, negative_count = statistics(RAW_DATA_PATH)
    with open(RAW_DATA_PATH, "r") as file:
        write_rebalanced_shuffled_data(file, PROCESSED_DATA_PATH, step=STEP_SIZE)

