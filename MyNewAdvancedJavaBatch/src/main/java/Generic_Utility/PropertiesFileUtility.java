package Generic_Utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileUtility {
	public String readingDataFromPropertyFile(String Key) throws IOException {
		FileInputStream fis=new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\MyNewAdvancedJavaBatch\\src\\test\\resources\\commondata.properties");
	Properties prop =new Properties();
	prop.load(fis);
	String data = prop.getProperty(Key);
	return data;
	}

}
