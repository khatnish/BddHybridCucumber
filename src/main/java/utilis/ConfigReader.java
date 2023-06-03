package utilis;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	public  Properties intializeProperties() throws IOException  {
		Properties prop= new Properties();
		File file= new File("C:\\Users\\nisha\\eclipse-workspace\\TutorialsNinja_BBB\\src\\test\\resource\\config\\config.properties");
	FileInputStream fis;
	try {
		fis = new FileInputStream(file);
		prop.load(fis);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return prop;
	
	}

}
