package JavaExtractor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import org.kohsuke.args4j.CmdLineException;
import JavaExtractor.Common.CommandLineValues;
import JavaExtractor.FeaturesEntities.ProgramRelation;
import py4j.GatewayServer;

public class App {
	private static CommandLineValues s_CommandLineValues;

	public static void main(String[] args) {
		System.out.println("PY4J gateway server is being started");
		GatewayServer gatewayServer = new GatewayServer(new App(), 25335);
		gatewayServer.start();
		System.out.println("PY4J gateway server was started");
	}

	public static String extractFile(int max_path_length, int max_path_width, String path){
		String[] args = new String[]{"--max_path_length", String.valueOf(max_path_length),
				"--max_path_width", String.valueOf(max_path_width), "--file", path, "--no_hash"};

		try {
			s_CommandLineValues = new CommandLineValues(args);
		} catch (CmdLineException e) {
			e.printStackTrace();
			return "";
		}

		if (s_CommandLineValues.NoHash) {
			ProgramRelation.setNoHash();
		}

		if (s_CommandLineValues.File != null) {
			return extractFile();
		} else if (s_CommandLineValues.Dir != null) {
			return extractDir();
		}
		return "";
	}

	private static String extractFile() {
		ExtractFeaturesTask extractFeaturesTask = new ExtractFeaturesTask(s_CommandLineValues,
				s_CommandLineValues.File.toPath());
		return extractFeaturesTask.processFile();
	}

	private static String extractDir() {
		LinkedList<ExtractFeaturesTask> tasks = new LinkedList<>();
		try {
			Files.walk(Paths.get(s_CommandLineValues.Dir)).filter(Files::isRegularFile)
					.filter(p -> p.toString().toLowerCase().endsWith(".java")).forEach(f -> {
						ExtractFeaturesTask task = new ExtractFeaturesTask(s_CommandLineValues, f);
						tasks.add(task);
					});
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		}
		String output = "";
		for (int i = 0; i < tasks.size(); i++) {
			ExtractFeaturesTask task = tasks.get(i);
			output += task.processFile();
		}
		return output;
	}
}
