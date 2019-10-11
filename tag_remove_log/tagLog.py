import re
import os
import codecs
from py4j.java_gateway import JavaGateway, GatewayParameters

gateway = JavaGateway(gateway_parameters=GatewayParameters(port=25335))
syntaxChecker = gateway.entry_point

INPUT_PATH = "..//result"
DEBUG = False

for (dirpath, dirnames, filenames) in os.walk(INPUT_PATH):
    for filename in filenames:
        fileEnding = os.path.splitext(filename)[1]
        filename = os.path.splitext(filename)[0]
        if not (os.path.isfile(dirpath + '/filteredCode2Vec/' + filename + "_filteredCode2Vec.txt") and
                os.path.isfile(dirpath + '/filteredRNN/' + filename + "_filteredRNN.txt"))\
                and fileEnding == ".txt":
            print("--------------------------", "Import", filename, "--------------------------")
            f = open(dirpath + "/" + filename + ".txt", "r", encoding='utf-8')
            lines = f.readlines();
            f.close()

            #REGEX FAILS IF LOG STATEMENT CONTAINS ; IN STRING
            regex = re.compile('(((log)|(logger))[.]((debug)|(info)|(warn)|(fatal)|(error))[^;]*;)', flags=re.I)

            if not os.path.isdir(dirpath + '/filteredCode2Vec/'):
                os.makedirs(dirpath + '/filteredCode2Vec')
            f = open(dirpath + '/filteredCode2Vec/' + filename + "_filteredCode2Vec.txt", "w", encoding="utf-8")

            if not os.path.isdir(dirpath + '/filteredRNN/'):
                os.makedirs(dirpath + '/filteredRNN')
            f2 = open(dirpath + '/filteredRNN/' + filename + "_filteredRNN.txt", "w", encoding="utf-8")


            logcount = 0;
            nologcount = 0;

            index = -1;
            funchash = '';
            funcname = '';
            funcsig = '';
            funcbody = '';

            syntaxerrorcount = 0;

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
                            #f.write(funcname)
                            f2.write(funcsig + funcbody)
                            f2.write('1\n')
                            funcsig = re.sub('( ([^\( ]*\())', ' ' + filename + '_f' + str(funccounter) + '_1(', funcsig, 1)
                            f.write(funcsig)
                            f.write(funcbody)
                            logcount += 1
                            #tag with 1
                        else:
                            syntaxerrorcount += 1;
                            if DEBUG:
                                print("Syntax incorrect for function: " + funcsig + funcbody)
                    else:
                        #tag with 0
                        funcbody = l

                        if (syntaxChecker.validateMethod(funcsig + funcbody)):
                            f2.write(funcsig + funcbody)
                            f2.write('0\n')
                            #f.write(funcname)
                            funcsig = re.sub('( ([^\( ]*\())', ' ' + filename + '_f' + str(funccounter) + '_0(', funcsig, 1)
                            f.write(funcsig)
                            f.write(funcbody)
                            nologcount += 1
                        else:
                            syntaxerrorcount += 1
                            if DEBUG:
                                print("Syntax incorrect for UNCHANGED function: " + funcsig + funcbody)

                    funccounter += 1;
                    index = -1;
            f.close()
            if not os.path.isdir(dirpath + '/processed/'):
                os.makedirs(dirpath + '/processed')
            os.rename(dirpath + "/" + filename + ".txt", dirpath + "/processed/" + filename + ".txt")

            information = "\n" + filename + "\n" + "Functions with log: " + str(logcount) + "\n" + "Functions without log: " + str(nologcount) + "\n" + "Functions without log: " + str(nologcount) + "\n"
            print(information)

            f = open(dirpath + "/FUNCTION_STATISTICS", 'a')
            f.write(information)
            f.close()
            print("--------------------------", "Parsed", filename, "--------------------------")
        else:
            print(filename, 'was already parsed.')

    print("Extracted all files in: " + dirpath)
    break
