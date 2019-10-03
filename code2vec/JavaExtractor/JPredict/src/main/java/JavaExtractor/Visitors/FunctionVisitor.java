package JavaExtractor.Visitors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import JavaExtractor.Common.Common;
import JavaExtractor.Common.MethodContent;
import com.sun.org.apache.xpath.internal.operations.Bool;

@SuppressWarnings("StringEquality")
public class FunctionVisitor extends VoidVisitorAdapter<Object> {
	private ArrayList<MethodContent> m_Methods = new ArrayList<>();

	@Override
	public void visit(MethodDeclaration node, Object arg) {
		visitMethod(node, arg);

		super.visit(node, arg);
	}

	private void visitMethod(MethodDeclaration node, Object obj) {
		LeavesCollectorVisitor leavesCollectorVisitor = new LeavesCollectorVisitor();
		leavesCollectorVisitor.visitDepthFirst(node);
		ArrayList<Node> leaves = leavesCollectorVisitor.getLeaves();

		String normalizedMethodName = Common.normalizeName(node.getName(), Common.BlankWord);
		ArrayList<String> splitNameParts = Common.splitToSubtokens(node.getName());

		String splitName = normalizedMethodName;
		if (splitNameParts.size() > 0) {
			splitName = splitNameParts.stream().collect(Collectors.joining(Common.internalSeparator));
		}

		if (node.getBody() != null && isValidMethod(node.getName())) {
            splitName += '|' + extractID(node.getName()) + '|' + extractLabel(node.getName());
            m_Methods.add(new MethodContent(leaves, splitName, getMethodLength(node.getBody().toString())));
		}
	}

	private Boolean isValidMethod(String name){
	    try{
            extractID(name);
            String label = extractLabel(name);
            return Integer.valueOf(label) == 1 || Integer.valueOf(label) == 0;
        } catch (ArrayIndexOutOfBoundsException ex){
	        return false;
        }
    }

	private String extractID(String name){
        String[] splitName = name.split("_");
        return splitName[splitName.length - 2];
    }

    private String extractLabel(String name){
        String[] splitName = name.split("_");
        return splitName[splitName.length - 1];
    }

	private long getMethodLength(String code) {
		String cleanCode = code.replaceAll("\r\n", "\n").replaceAll("\t", " ");
		if (cleanCode.startsWith("{\n"))
			cleanCode = cleanCode.substring(3).trim();
		if (cleanCode.endsWith("\n}"))
			cleanCode = cleanCode.substring(0, cleanCode.length() - 2).trim();
		if (cleanCode.length() == 0) {
			return 0;
		}
		long codeLength = Arrays.asList(cleanCode.split("\n")).stream()
				.filter(line -> (line.trim() != "{" && line.trim() != "}" && line.trim() != ""))
				.filter(line -> !line.trim().startsWith("/") && !line.trim().startsWith("*")).count();
		return codeLength;
	}

	public ArrayList<MethodContent> getMethodContents() {
		return m_Methods;
	}
}
