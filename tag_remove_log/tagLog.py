import re;
import codecs;
from py4j.java_gateway import JavaGateway, GatewayParameters

gateway = JavaGateway(gateway_parameters=GatewayParameters(port=25335))
syntaxChecker = gateway.entry_point

filename = 'camel';

f = open(filename + '.txt', "r", encoding='utf-8')
lines = f.readlines();
f.close()

#REGEX FAILS IF LOG STATEMENT CONTAINS ; IN STRING
regex = re.compile('(((log)|(logger))[.]((debug)|(info)|(warn)|(fatal)|(error))[^;]*;)', flags=re.I)

f = open( filename + "_filtered.txt", "w", encoding="utf-8")

logcount = 0;
nologcount = 0;

index = -1;
funchash = '';
funcname = '';
funcsig = '';
funcbody = '';

funccounter = 0;

for l in lines:
    if (index == -1):
        funchash = l
        index += 1
    elif (index == 0):
        funcname = l
        if (l.strip()):
            index += 1
    elif (index == 1):
        funcsig = l
        index += 1
    elif (index == 2):
        if (regex.search(l)):
            funcbody = l
            funcbody = re.sub('(((log)|(logger))[.]((debug)|(info)|(warn)|(fatal)|(error))[^;]*;)', '', funcbody, flags=re.I)
            if (syntaxChecker.validateMethod(funcsig + funcbody)):
                f.write(funcname)
                funcsig = re.sub('( ([^\( ]*\())', 'f' + str(funccounter) + '_1', funcsig)
                f.write(funcsig)
                f.write(funcbody)
                logcount += 1
                #tag with 1
            else:
                print("Syntax incorrect for function: " + funcsig + funcbody)
        else:
            #tag with 0
            funcbody = l

            if (syntaxChecker.validateMethod(funcsig + funcbody)):
                f.write(funcname)
                funcsig = re.sub('( ([^\( ]*\())', ' ' + filename + '_f' + str(funccounter) + '_0(', funcsig)
                f.write(funcsig)
                f.write(funcbody)
                nologcount += 1
            else:
                print("Syntax incorrect for UNCHANGED function: " + funcsig + funcbody)

        funccounter += 1;
        index = -1;

f.close()

print(filename)
print("Functions with log: ", logcount)
print("Functions without log: ", nologcount)

         
#Select log lines:
#/(((log)|(logger))[.]((debug)|(info)|(warn)|(fatal)|(error))[^;]*;)/gi
