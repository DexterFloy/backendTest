package gamer.backendTest.api.utility;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ValuesPropertiesHandling {

	public static Properties getConfigProperties() {
		return getPropertiesFromFile("gamer/backendTest/config.properties");
	}
	
	private static Properties getPropertiesFromFile(String filePath) {
		Properties properties = new Properties();
		try (InputStream is = ValuesPropertiesHandling.class.getClassLoader().getResourceAsStream(filePath) ) {
			properties.load(is);
		} catch (IOException e) {
			throw new RuntimeException("Could not load config file!");
		}
		return properties;
	}
}
