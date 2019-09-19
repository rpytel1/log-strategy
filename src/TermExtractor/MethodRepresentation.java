package TermExtractor;

/*
This class contains all information tom represent a method.
 */
public final class MethodRepresentation {
    private static final String DELIMITER = "\n";

    public String methodName;
    public String signature;
    public String body;

    MethodRepresentation(String name, String signature, String body){
        this.methodName = name;
        this.signature = signature;

        //remove all line breaks for exporting it to txt
        this.body = Preprocessor.removeLineBreaks(body);
    }

    @Override
    public String toString(){
        return methodName + DELIMITER + signature + DELIMITER + body;
    }
}