package br.com.medaula.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
public class UtilProperties {
	
	

	public static Properties getProp(String fileString) throws IOException {
		
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		Properties props = new Properties();
		
		InputStream resourceStream = loader.getResourceAsStream(fileString+".properties");
		props.load(resourceStream);
		
		return props;

	}
}