package JavaExtractor;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import org.apache.commons.lang3.StringUtils;
import com.github.javaparser.ParseException;
import JavaExtractor.Common.CommandLineValues;
import JavaExtractor.Common.Common;
import JavaExtractor.FeaturesEntities.ProgramFeatures;

public class ExtractFeaturesTask implements Callable<Void> {
	CommandLineValues m_CommandLineValues;
	Path filePath;

	public ExtractFeaturesTask(CommandLineValues commandLineValues, Path path) {
		m_CommandLineValues = commandLineValues;
		this.filePath = path;
	}

	@Override
	public Void call() throws Exception {
		//System.err.println("Extracting file: " + filePath);
		processFile();
		//System.err.println("Done with file: " + filePath);
		return null;
	}

	public static String readFileString ( Path filePath) {
		StringBuffer text = new StringBuffer();
		try {
			BufferedReader in = new BufferedReader( new InputStreamReader( new FileInputStream(filePath.toFile()), "UTF8") );
			String line;
			while ( (line = in.readLine()) != null ) {
				text.append(line + "\r\n");
			}


		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return text.toString();
	}

	public String processFeatures(ArrayList<ProgramFeatures> features){
		if (features == null) {
			return "";
		}

		String toPrint = featuresToString(features);
		if (toPrint.length() > 0) {
			// System.out.println(toPrint);
		}
		return toPrint;
	}

	public String processCode(String code){
		ArrayList<ProgramFeatures> features;
		try {
			features = extractCode(code);
		} catch (ParseException | IOException e) {
			e.printStackTrace();
			return "";
		}
		return processFeatures(features);
	}

	public String processFile() {
		ArrayList<ProgramFeatures> features;
		try {
			features = extractSingleFile();
		} catch (ParseException | IOException e) {
			e.printStackTrace();
			return "";
		}
		return processFeatures(features);
	}

	public ArrayList<ProgramFeatures> extractCode(String code) throws ParseException, IOException {
		FeatureExtractor featureExtractor = new FeatureExtractor(m_CommandLineValues);

		ArrayList<ProgramFeatures> features = featureExtractor.extractFeatures(code);

		return features;
	}

	public ArrayList<ProgramFeatures> extractSingleFile() throws ParseException, IOException {
		String code = readFileString(this.filePath);
		return extractCode(code);
	}

	public String featuresToString(ArrayList<ProgramFeatures> features) {
		if (features == null || features.isEmpty()) {
			return Common.EmptyString;
		}

		List<String> methodsOutputs = new ArrayList<>();

		for (ProgramFeatures singleMethodfeatures : features) {
			StringBuilder builder = new StringBuilder();

			String toPrint = Common.EmptyString;
			toPrint = singleMethodfeatures.toString();
			if (m_CommandLineValues.PrettyPrint) {
				toPrint = toPrint.replace(" ", "\n\t");
			}
			builder.append(toPrint);


			methodsOutputs.add(builder.toString());

		}
		return StringUtils.join(methodsOutputs, "\n");
	}
}