package frameworks.loadingConfig;

import java.io.IOException;
import java.util.HashMap;


public class TestLoadManager {
	public String dbName;
	public String username;
	public String password;

	public void loadConfigurations() {
		HashMap<String, String> configs = null;
		try {
			configs = new ConfigurationProvider().getDataFromTheFile("config.properties");
		} catch (IOException e) {
			throw new RuntimeException("Config file does not exist.");
		}
		dbName = configs.get(ConfigurationParameters.dbName);
		username = configs.get(ConfigurationParameters.username);
		password = configs.get(ConfigurationParameters.password);
	}

}
