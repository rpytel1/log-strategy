package TermExtractor;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class App {
	
	public static final String REPO_DIR = "C:/Users/Jan/Desktop/JackTheLogger";
	
	/*
	 * This has to be run with the G1 Garbage Collector
	 * VM Arguments: -Xmx4g -Xmx8g -XX:+UseG1GC
	 */
	public static void main(String[] args) {
		generateCsv(getAllRepositories(), "hadoop_functions");
	}
	
	private static void generateCsv(List<Repository> repositories, String fileName) {
		List<String> repoCsvRows = repositories.stream()
				.map(repo -> repo.getCsvRepresentation())
				.collect(Collectors.toList());
		try {
			writeOutputFile("result/" + fileName + ".csv", repoCsvRows);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static List<Repository> getAllRepositories() {
		List<Repository> repositories = new ArrayList<>();
		repositories.addAll(getHadoop());
		return repositories;
	}
	
	public static List<Repository> getHadoop() {
		List<Repository> repositories = new ArrayList<>();
		repositories.add(createRepo("Hadoop"));
		return repositories;
	}

	private static Repository createRepo(String name) {
		return new Repository(REPO_DIR + name);
	}
	
	private static void writeOutputFile(String path, List<String> rows) throws IOException {
		Path outputPath = Paths.get(path);
		Files.write(outputPath, rows, Charset.forName("UTF-8"));
	}
}
