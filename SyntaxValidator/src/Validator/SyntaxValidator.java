package Validator;

import com.github.javaparser.ParseProblemException;
import com.github.javaparser.StaticJavaParser;

public class SyntaxValidator {
    public static Boolean validateMethod(String code) {
        try {
            StaticJavaParser.parse("class test{" + code + "}");
            return true;
        } catch (ParseProblemException ex) {
            System.out.println("Failed with syntax error: " + code);
            return false;
        }
    }
}
