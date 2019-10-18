import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import com.github.javaparser.ParseProblemException;
import py4j.GatewayServer;
import com.github.javaparser.StaticJavaParser;

/*
 * This has to be run with the G1 Garbage Collector
 *
 * VM Arguments: -Xmx4g -Xmx8g -XX:+UseG1GC
 */
public class App {
	public static void main(String[] args) {
		System.out.println("PY4J gateway server is being started");
		GatewayServer gatewayServer = new GatewayServer(new App(), 25335);
		gatewayServer.start();
		System.out.println("PY4J gateway server was started");
	}

	public static Boolean extractMethods(String path, String savePath) throws IOException{
		Path repoDir = Paths.get(path);
		return generateOutput(getAllRepositories(repoDir), savePath);
	}

	public static Boolean validateMethod(String code) {
		try {
			StaticJavaParser.parse("class test{" + code + "}");
			return true;
		} catch (ParseProblemException ex) {
			System.out.println("Failed with syntax error: " + code);
			return false;
		}
	}
	
	private static Boolean generateOutput(List<Repository> repositories, String savePath) throws IOException{
		for (Repository repository: repositories) {
			List<String> repoRepresentation = Stream.of(repository.getRepresentation())
					.collect(Collectors.toList());

			String fileName = repository.name;
			writeOutputFile(Paths.get(savePath + "/" + fileName + ".txt"), repoRepresentation);
		}

		return true;
	}

	private static List<Repository> getAllRepositories(Path repoDir) throws IOException {
		List<Repository> repositories = new ArrayList<>();

		System.out.println("-----------------------------------------------------------");
		Files.list(repoDir)
				.limit(100)
				.forEach(path -> {
					repositories.addAll(getRepository(path));
				});

		return repositories;
	}
	
	private static List<Repository> getRepository(Path path) {
		List<Repository> repositories = new ArrayList<>();
		repositories.add(new Repository(path));
		return repositories;
	}

	private static List<String> prepareOutput(List<String> rows){
		List<String> output = new ArrayList<>();
		for (String row : rows) {
			output.add(Preprocessor.removeEmptyLines(row));
		}
		return output;
	}
	
	private static void writeOutputFile(Path path, List<String> rows) throws IOException {
		System.out.println("Writing to " + path);
		Files.write(path, prepareOutput(rows), Charset.forName("UTF-8"));
		System.out.println("Wrote to " + path);
		System.out.println("-----------------------------------------------------------");
	}
}
