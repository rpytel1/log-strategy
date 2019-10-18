import os

def read_data(path: str):
    file = open(path, "r", encoding='utf-8')
    lines = file.readlines()
    file.close()
    print('Red', len(lines), 'lines to disk.')
    return lines

def write_data(data, dir_path, name):
    create_directory(dir_path)

    file_counter = 0
    element_counter = 0
    write_buffer = ""

    file = open(dir_path + "/" + name + str(file_counter) + ".java", "w", encoding="utf-8")
    for id, elem in enumerate(data):
        if element_counter > 1000:
            file.write(write_buffer)
            file.close()
            write_buffer = ""
            element_counter = 0
            file_counter += 1
            file = open(dir_path + "/" + name + str(file_counter) + ".java", "w", encoding="utf-8")
        element_counter += 1
        write_buffer += elem.getJavaRepresentation()

    file.write(write_buffer)
    file.close()
    print('Wrote', len(data), 'lines to disk at', dir_path)

def create_directory(dir_path: str):
    if not os.path.isdir(dir_path):
        os.mkdir(dir_path)
        print('Created output directory at: ' + os.path.abspath(dir_path))

def move_file(from_path: str, target_path:str):
    create_directory(os.path.dirname(target_path))
    os.rename(from_path, target_path)
