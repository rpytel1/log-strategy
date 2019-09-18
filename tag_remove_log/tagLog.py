import re;

f = open('small.txt', "r")
lines = f.readlines();
f.close()

#REGEX FAILS IF LOG STATEMENT CONTAINS ; IN STRING
regex = re.compile('(((log)|(logger))[.]((debug)|(info)|(warn)|(fatal)|(error))[^;]*;)', flags=re.I)

#print(regex)

f = open("filteredFunctions.txt", "w")


for l in lines:
    if (regex.search(l)):
        f.write(re.sub('(((log)|(logger))[.]((debug)|(info)|(warn)|(fatal)|(error))[^;]*;)', '', l, flags=re.I))
        f.write('1\n')
        #tag with 1
    else:
        #tag with 0
        f.write(l)
        f.write('0\n')

f.close()
         
#Select log lines:
#/(((log)|(logger))[.]((debug)|(info)|(warn)|(fatal)|(error))[^;]*;)/gi
