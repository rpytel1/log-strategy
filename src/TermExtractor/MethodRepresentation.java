package TermExtractor;

/*
This class contains all information tom represent a method.
 */
public final class MethodRepresentation {
    public String methodName = "";
    public String signature = "";
    public String body = "";

    private static final String DELIMITER = "\n";

    MethodRepresentation(String name, String signature, String body) {
        if(Preprocessor.syntaxValidator(signature + body)){
            this.methodName = name;
            this.signature = signature;

            //remove all line breaks for exporting it to txt
            this.body = Preprocessor.removeLineBreaks(body);
        }
    }

    @Override
    public String toString(){
        return methodName + DELIMITER + signature + DELIMITER + body;
    }
}