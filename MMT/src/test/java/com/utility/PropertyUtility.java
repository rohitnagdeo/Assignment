package com.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtility {

	
	public static String readPropertyFile(String filePath,String key) throws IOException
	{
		FileInputStream fis = new FileInputStream(filePath);
		
		Properties property = new Properties();
		property.load(fis);
		
		return property.getProperty(key);
	}
	
	
	
}
