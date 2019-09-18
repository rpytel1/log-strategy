package TermExtractor;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.ImportDeclaration;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;

public class JavaCompilationUnit {
	
	private final CompilationUnit compilationUnit;
	
	private JavaCompilationUnit(File file) throws IOException {
		String sourceCode = new String(Files.readAllBytes(file.toPath()));
		compilationUnit = StaticJavaParser.parse(sourceCode);
	}

	public CompilationUnit getCompilationUnit() {
		return compilationUnit;
	}
	
	public List<String> getTypeNames() {
		return compilationUnit.findAll(ClassOrInterfaceDeclaration.class).stream()
        .map(type -> type.getNameAsString())
        .collect(Collectors.toList());
	}

	/**
	 * Get the body and the content of all methods.
	 */
	public List<String> getMethods() {
		return compilationUnit.findAll(MethodDeclaration.class).stream()
				.map(method -> new MethodRepresentation(method.getNameAsString(), method.getSignature().toString(), method.getBody().toString()).toString())
				.collect(Collectors.toList());
	}

	public List<String> getMethodNames() {
		return compilationUnit.findAll(MethodDeclaration.class).stream()
        .map(method -> method.getNameAsString())
        .collect(Collectors.toList());
	}

	public List<String> getMethodBodies() {
		return compilationUnit.findAll(MethodDeclaration.class).stream()
				.map(method -> method.getBody().get().toString())
				.collect(Collectors.toList());
	}
	
	public List<String> getFieldNames() {
		return compilationUnit.findAll(FieldDeclaration.class).stream()
        .flatMap(field -> field.getVariables().stream())
        .map(variable -> variable.getNameAsString())
        .collect(Collectors.toList());
	}
	
	public List<String> getImportNames() {
		return compilationUnit.findAll(ImportDeclaration.class).stream()
		.filter(importDecl -> !importDecl.isAsterisk())
        .map(importDecl -> extractImportClassName(importDecl.getNameAsString()))
        .collect(Collectors.toList());
	}
	
	public List<String> getComments() {
		return compilationUnit.getAllContainedComments().stream()
				.map(comment -> comment.getContent())
				.flatMap(comment -> Stream.of(comment.replaceAll("[^a-zA-Z ]", "").toLowerCase().split(" ")))
				.filter(comment -> !comment.isEmpty())
				.collect(Collectors.toList());
	}
	
	public List<String> getTerms() {
		List<String> terms = new ArrayList<>();
		terms.addAll(getMethods());
		return terms;
	}
	
	private static String extractImportClassName(String fullyQualifiedImport) {
		String[] pathParts = fullyQualifiedImport.split("\\.");
		return pathParts[pathParts.length - 1];
	}
	
	public static JavaCompilationUnit create(File file) {
		JavaCompilationUnit jcu  = null;
		try {
			jcu = new JavaCompilationUnit(file);
		} catch (Exception e) {
			
		}
		return jcu;
	}
}
