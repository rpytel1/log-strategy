package TermExtractor;

import java.io.File;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;


public final class Repository {
	
	private static final String CSV_DELIMITER = ",";
	
	private final String path;
	private final String name;
	
	public Repository (String path) {
		this.path = path;
		String[] parts = path.split("/");
		this.name = parts[parts.length - 1];
	}
	
	public Collection<File> getAllJavaFilePaths() {
		File repoDirectory = new File(this.path);
		String[] filterExtensions = {"java"};
		Collection<File> javaFiles = FileUtils.listFiles(repoDirectory, filterExtensions, true);
		return javaFiles;
	}
	
	public int getRepoSize() {
		return getAllJavaFilePaths().size();
	}
	
	public Collection<JavaCompilationUnit> getAllJavaCompilationUnits() {
		return this.getAllJavaFilePaths().stream()
				.map(file -> JavaCompilationUnit.create(file))
				.filter(Objects::nonNull)
				.collect(Collectors.toList());
	}
	
	public List<String> getAllTerms() {
		return this.getAllJavaCompilationUnits().stream()
				.flatMap(cu -> cu.getTerms().stream())
				.collect(Collectors.toList());
	}
	
	public String getCsvRepresentation() {
		System.out.println(this.name);
		String name = this.name + CSV_DELIMITER;
		List<String> terms = getAllTerms();
		return name + String.join(CSV_DELIMITER, terms);
	}
	
	public Map<String, Long> getTermOccurances() {
		Map<String, Long> counterMap = getAllTerms().stream().
				collect(Collectors.groupingBy(e -> e.toString().toLowerCase(), Collectors.counting()));
		return counterMap.entrySet().stream()
				.sorted(Entry.comparingByValue(Comparator.reverseOrder()))
				.collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
	}
	
	@Override
	public String toString() {
		return this.name;
	}

}
