import com.github.javaparser.ParseProblemException;
import com.github.javaparser.StaticJavaParser;

public class Preprocessor {
    public static String removeLineBreaks(String text){
        return text.replace("\n", "").replace("\r", "");
    }

    public static String removeEmptyLines(String text){
        return text.replaceAll("(?m)^\r?\n", "");
    }

    public static String removeComments(String text) { return text;}

    public static Boolean syntaxValidator(String code) {
        try {
            StaticJavaParser.parse("class test{" + code + "}");
            return true;
        } catch (ParseProblemException ex){
            System.out.println("Failed with syntax error: " + code);
            return false;
        }
    }
}