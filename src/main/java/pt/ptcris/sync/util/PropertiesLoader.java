package pt.ptcris.sync.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class PropertiesLoader {
	private static PropertiesLoader instance = null;
	private static Properties properties;
	private static String propFileName = "gen.properties";

	private PropertiesLoader() {
		// Exists only to defeat instantiation.
	}

	public static PropertiesLoader getInstance() {
		return PropertiesLoader.getInstance(propFileName);
	}

	public static PropertiesLoader getInstance(String propFileName) {
		if (instance == null) {
			instance = new PropertiesLoader();

			InputStream inputStream;
			properties = new Properties();

			inputStream = PropertiesLoader.class.getClassLoader().getResourceAsStream(propFileName);

			try {

				if (inputStream != null) {
					properties.load(inputStream);
				} else {
					throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
				}

			} catch (IOException io) {
				io.printStackTrace();
			} finally {
				if (inputStream != null) {
					try {
						inputStream.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}

		}
		return instance;
	}

	public static Properties loadProperties(String propFileName) {
		InputStream inputStream;
		Properties properties = new Properties();

		inputStream = PropertiesLoader.class.getClassLoader().getResourceAsStream(propFileName);

		try {

			if (inputStream != null) {
				properties.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}

		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return properties;
	}

	public Properties getProperties() {
		return properties;
	}

}
