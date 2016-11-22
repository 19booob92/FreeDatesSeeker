package org.commit.luxmed.notifier.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.commit.luxmed.notifier.main.Runner;

public class PropertyLoader {
	
	private static PropertyLoader instance;
	
	private Properties properties = new Properties();
	private InputStream input = null;
	
	private String URL = "";
	private String login = "";
	private String password = "";
	
	private PropertyLoader() {
		loadProperties();
	}
	
	private void loadProperties() {
		try {
			File propFile = new File("/home/booob/workspace/LuxMedNotifier/notifier.properties");
			input = new FileInputStream(propFile);
			
			properties.load(input);
			
			this.URL = properties.getProperty("url");
			this.login = properties.getProperty("login");
			this.password = properties.getProperty("password");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static PropertyLoader instance() {
		if (instance == null) {
			instance = new PropertyLoader();
			return instance;
		} else {
			return instance;
		}
	}
	
	public String url() {
		return this.URL;
	}
	
	public String login() {
		return this.login;
	}
	
	public String password() {
		return this.password;
	}
}
