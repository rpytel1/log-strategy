package TermExtractor;

import java.io.File;
import java.nio.file.Path;
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
	
	private static final String DELIMITER = "\n";
	
	public final Path path;
	public final String name;
	
	public Repository (Path path) {
		this.path = path;
		this.name = path.getName(path.getNameCount()-1).toString();
	}

	public Map<String, Long> termCount() {
		Map<String, Long> counterMap = getAllTerms().stream().
				collect(Collectors.groupingBy(e -> e.toString().toLowerCase(), Collectors.counting()));

		return counterMap.entrySet().stream()
				.sorted(Entry.comparingByValue(Comparator.reverseOrder()))
				.collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
	}

	public int javaClassCount() {
		return getAllJavaFilePaths().size();
	}
	
	public Collection<File> getAllJavaFilePaths() {
		File repoDirectory = new File(this.path.toUri());
		String[] filterExtensions = {"java"};
		Collection<File> javaFiles = FileUtils.listFiles(repoDirectory, filterExtensions, true);

		System.out.println("Found " + javaClassCount() + " java classes.");
		return javaFiles;
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
	
	public String getRepresentation() {
		System.out.println(this.name + " is beeing parsed.");
		List<String> terms = getAllTerms();
		System.out.println("Found " + termCount() + " functions for " + this.name + ".");
		return String.join(DELIMITER, terms);
	}

	@Override
	public String toString() { return this.name; }
}