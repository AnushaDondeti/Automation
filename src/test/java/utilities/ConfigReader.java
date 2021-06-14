package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
	private ConfigReader() {

	}

	/**
	 * =============================================================================
	 * Method: loadPropertyFile | Author: Rajesh Buddha | Date:16 Jan 2020 |
	 * Description: This method loadPropertyFile method used for loading the
	 * properties file | Parameters:filePath | Return: Properties
	 * =============================================================================
	 */
	public static Properties loadPropertyFile(String filePath) {
		// Read from properties file
		File file = new File(filePath);
		Properties prop = new Properties();

		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
			prop.load(fileInput);
		} catch (Exception e) {
			// LogUtil.errorLog(ConfigReader.class, "Caught the exception", e);

		}
		return prop;

	}

	/**
	 * =============================================================================
	 * Method: getValue | Author: Rajesh Buddha | Date:16 Jan 2020 | Description:
	 * will get sting value from properties file | Parameters:key | Return: String
	 * =============================================================================
	 */
	public static String getValue(String key) {

		Properties prop = loadPropertyFile("D:\\workspace1\\Automationtask\\src\\test\\resources\\ConfigFiles\\config.properties");

		return prop.getProperty(key);
	}

	/**
	 * =============================================================================
	 * Method: getValue | Author: Rajesh Buddha | Date:16 Jan 2020 | Description:
	 * will get int value from properties file | Parameters:key | Return: int
	 * =============================================================================
	 */
	public static int getIntValue(String key) {
		Properties prop = loadPropertyFile("D:\\workspace1\\Automationtask\\src\\test\\resources\\ConfigFiles\\config.properties");

		String strKey = prop.getProperty(key);

		return Integer.parseInt(strKey);
	}

}
