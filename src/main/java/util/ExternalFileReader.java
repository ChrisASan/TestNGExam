package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ExternalFileReader {

	public static void externalFile() throws IOException {
		
	
	String path = "data\\info.properties";
	FileInputStream fi = new FileInputStream(path);
	
//	try {
//	FileInputStream fi = new FileInputStream(path);
//	}catch (FileNotFoundException e) {
//		e.printStackTrace();
//	}

	Properties prop = new Properties();
	prop.load(fi);
	
	
}
}

