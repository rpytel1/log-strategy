/*
This class contains all information tom represent a method.
 */
public final class MethodRepresentation {
    public String id = "";
    public String methodName = "";
    public String signature = "";
    public String body = "";

    private static final String DELIMITER = "\n";

    MethodRepresentation(String name, String signature, String body) {
        if(Preprocessor.syntaxValidator(signature + body)){
            this.id = Preprocessor.generateId(signature);
            this.methodName = name;
            this.signature = signature;

            this.body = Preprocessor.removeLineBreaks(body);
            this.body = Preprocessor.removeComments(this.body);
        }
    }

    @Override
    public String toString(){
        return id + DELIMITER + methodName + DELIMITER + signature + DELIMITER + body;
    }
}