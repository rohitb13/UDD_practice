package com.udd.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyFileReader {
	
private Properties prop;
	
	public PropertyFileReader(String filename){
		prop=new Properties();
		InputStream is;
		is = this.getClass().getResourceAsStream("/"+filename);
	
		try {
			prop.load(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String getValue(String key){
		return prop.getProperty(key);
	}
	
	

}
