package TermExtractor;

public class Preprocessor {
    public static String removeLineBreaks(String text){
        return text.replace("\n", "").replace("\r", "");
    }
}