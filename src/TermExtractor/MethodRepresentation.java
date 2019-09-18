package TermExtractor;

import java.util.Optional;

public final class MethodRepresentation {
    public String methodName;
    public String signature;
    public String body;

    MethodRepresentation(String name, String signature, String body){
        this.methodName = name;
        this.signature = signature;

        //remove all line breaks for exporting it to txt
        this.body = Preprocessor.removeLineBreaks(body);

        System.out.println("--------------------------------");
        System.out.println(this);
        System.out.println("--------------------------------");
    }

    @Override
    public String toString(){
        return methodName + "\n" + signature + "\n" + body;
    }
}