package Dataproviders;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigUtility {
	
	public static String readProperty(String keyName)

	{
		Properties pro=new Properties();
	try
	{
		File file=new File(System.getProperty("user.dir")+"/Configuration/config.properties");
		FileInputStream fis=new FileInputStream(file);
		pro.load(fis);
	}
	catch(Exception e)
	{
		System.out.println("Configuration File not Found");
	}
	
	
	return pro.getProperty(keyName);
		
	}

}
