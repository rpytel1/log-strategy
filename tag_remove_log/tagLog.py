import re;
import codecs;


filename = 'Hadoop';

f = open(filename + '.txt', "r", encoding='utf-8')
lines = f.readlines();
f.close()

#REGEX FAILS IF LOG STATEMENT CONTAINS ; IN STRING
regex = re.compile('(((log)|(logger))[.]((debug)|(info)|(warn)|(fatal)|(error))[^;]*;)', flags=re.I)

f = open( filename + "_filtered.txt", "w", "utf-8")

logcount = 0;
nologcount = 0;

index = 0;
funcname = '';
funcsig = '';
funcbody = '';


for l in lines:
    if (index == 0):
        funcname = l
        if (l.strip()):
            index += 1
    elif (index == 1):
        funcsig = l
        index += 1
    elif (index == 2):
        f.write(funcname)
        f.write(funcsig)
        if (regex.search(l)):
            funcbody = l
            f.write(re.sub('(((log)|(logger))[.]((debug)|(info)|(warn)|(fatal)|(error))[^;]*;)', '', funcbody, flags=re.I))
            f.write('1\n')
            logcount += 1
            #tag with 1
        else:
            #tag with 0
            funcbody = l
            f.write(funcbody)
            f.write('0\n')
            nologcount += 1
        index = 0;

f.close()

print(filename)
print("Functions with log: ", logcount)
print("Functions without log: ", nologcount)

         
#Select log lines:
#/(((log)|(logger))[.]((debug)|(info)|(warn)|(fatal)|(error))[^;]*;)/gi
