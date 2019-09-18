package TermExtractor;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class App {
	/*
	 * This has to be run with the G1 Garbage Collector
	 * VM Arguments: -Xmx4g -Xmx8g -XX:+UseG1GC
	 */
	public static void main(String[] args) throws IOException {
		String repoDir = "C:/Users/Jan/Desktop/Repositories/";

		generateCsv(getAllRepositories(repoDir));
	}
	
	private static void generateCsv(List<Repository> repositories) {
		for (Repository repository: repositories) {
			List<String> repoCsv = Stream.of(repository.getCsvRepresentation())
					.collect(Collectors.toList());
			try {
				String fileName = repository.toString();
				writeOutputFile("result/" + fileName + ".txt", repoCsv);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static List<Repository> getAllRepositories(String repoDir) throws IOException {
		List<Repository> repositories = new ArrayList<>();

		Files.list(new File(repoDir).toPath())
				.limit(100)
				.forEach(path -> {
					repositories.addAll(getRepository(path));
				});

		return repositories;
	}
	
	public static List<Repository> getRepository(Path path) {
		List<Repository> repositories = new ArrayList<>();
		System.out.println("-----------------------------------------------------------");
		repositories.add(new Repository(path));
		return repositories;
	}
	
	private static void writeOutputFile(String path, List<String> rows) throws IOException {
		Path outputPath = Paths.get(path);
		System.out.println("Writing to " + path);
		Files.write(outputPath, rows, Charset.forName("UTF-8"));
		System.out.println("Wrote to " + path);
		System.out.println("-----------------------------------------------------------");
	}
}
