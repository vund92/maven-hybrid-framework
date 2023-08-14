package utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import commons.GlobalConstants;

public class PropertiesConfig {

	private final Properties properties;
	private final String propertyFilePath = GlobalConstants.getGlobalConstants().getProjectPath() + "/src/test/resources/config.properties";

	// Private static variable
	private static PropertiesConfig configLoader;

	// Private constructor
	private PropertiesConfig() {
		properties = PropertiesConfig.propertyLoader(propertyFilePath);
	}

	private static Properties propertyLoader(String propertyFilePath) {
		Properties properties = new Properties();
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException("Failed to load properties file " + propertyFilePath);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration properties not found at " + propertyFilePath);
		}
		return properties;
	}

	// Public static method
	public static synchronized PropertiesConfig getFileConfigReader() {
//		if (configLoader == null) {
//			configLoader = new PropertiesConfig();
//		}
//		return configLoader;
		// Same with
		return (configLoader == null) ? new PropertiesConfig() : configLoader; // Toan tu tam nguyen
	}

	public long getLongTimeout() {
		String longTimeout = properties.getProperty("LongTimeout");
		if (longTimeout != null)
			return Long.parseLong(longTimeout);
		else
			throw new RuntimeException("Long timeout not found in Config file");
	}

	public long getShortTimeout() {
		String shortTimeout = properties.getProperty("ShortTimeout");
		if (shortTimeout != null)
			return Long.parseLong(shortTimeout);
		else
			throw new RuntimeException("Short timeout not found in Config file");
	}

	public String getUserUrl() {
		String url = properties.getProperty("UserUrl");
		if (url != null)
			return url;
		else
			throw new RuntimeException("User Url not found in Config file");
	}

	public String getAdminUrl() {
		String url = properties.getProperty("AdminUrl");
		if (url != null)
			return url;
		else
			throw new RuntimeException("Admin Url not found in Config file");
	}
	
}
