import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.sun.org.apache.xpath.internal.operations.Bool;
import py4j.GatewayServer;

/*
 * This has to be run with the G1 Garbage Collector
 * VM Arguments: -Xmx4g -Xmx8g -XX:+UseG1GC
 */
public class App {
	public static void main(String[] args) {
		System.out.println("PY4J gateway server is being started");
		GatewayServer gatewayServer = new GatewayServer(new SyntaxValidator(), 25335);
		gatewayServer.start();
		System.out.println("PY4J gateway server was started");
	}

	public static Boolean extractMethods(String path) throws IOException{
		Path repoDir = Paths.get(path);
		return generateOutput(getAllRepositories(repoDir));
	}
	
	private static List<String> generateOutput(List<Repository> repositories) throws IOException{
		for (Repository repository: repositories) {
			List<String> repoRepresentation = Stream.of(repository.getRepresentation())
					.collect(Collectors.toList());

			String fileName = repository.name;
			writeOutputFile("result/" + fileName + ".txt", repoRepresentation);
		}
	}

	public static List<Repository> getAllRepositories(Path repoDir) throws IOException {
		List<Repository> repositories = new ArrayList<>();

		System.out.println("-----------------------------------------------------------");
		Files.list(repoDir)
				.limit(100)
				.forEach(path -> {
					repositories.addAll(getRepository(path));
				});

		return repositories;
	}
	
	public static List<Repository> getRepository(Path path) {
		List<Repository> repositories = new ArrayList<>();
		repositories.add(new Repository(path));
		return repositories;
	}
	
	private static void writeOutputFile(String path, List<String> rows) throws IOException {
		Path outputPath = Paths.get(path);

		List<String> output = new ArrayList<>();
		for (String row : rows) {
			output.add(Preprocessor.removeEmptyLines(row));
		}

		System.out.println("Writing to " + path);
		Files.write(outputPath, output, Charset.forName("UTF-8"));
		System.out.println("Wrote to " + path);
		System.out.println("-----------------------------------------------------------");
	}
}
