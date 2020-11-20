package frameworks.loadingConfig;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

public class ConfigurationProvider {

	public HashMap<String, String> getDataFromTheFile(String fileName) throws IOException {
		InputStream inputStream = null;
		Properties props = new Properties();
		try {
			inputStream = getClass().getClassLoader().getResourceAsStream(fileName);
			if (inputStream == null) {
				throw new FileNotFoundException(fileName + " not found");
			}
			props.load(inputStream);
		} finally {
			inputStream.close();
		}

		HashMap<String, String> dataMap = new HashMap<String, String>();

		for (String key : props.stringPropertyNames()) {
			dataMap.put(key, props.getProperty(key));
		}

		return dataMap;
	}
}
