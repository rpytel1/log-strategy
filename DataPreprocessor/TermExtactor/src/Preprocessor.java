import com.github.javaparser.ParseProblemException;
import com.github.javaparser.StaticJavaParser;
import com.google.common.hash.Hashing;
import java.nio.charset.StandardCharsets;

public class Preprocessor {
    public static String removeLineBreaks(String text){
        return text.replace("\n", "").replace("\r", "");
    }

    public static String removeEmptyLines(String text){
        return text.replaceAll("(?m)^\r?\n", "");
    }

    public static String removeComments(String text) { return removeSingleLineComments(text); }

    private static String removeSingleLineComments(String text){
        return text.replaceAll("//\\s((.*)|[\n\r])", "");
    }

    private static String removeBlockComments(String text) {
        //ToDo: Fix performance
        return text.replaceAll("/\\*([^*]|[\\r\\n]|(\\*+([^*/]|[\\r\\n])))*\\*+/", "");
    }

    public static String generateId(String name) {return Hashing.sha256().hashString(name, StandardCharsets.UTF_8).toString();}

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