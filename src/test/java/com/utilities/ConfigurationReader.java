package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
	File f;
	FileInputStream fis;
	Properties p;
	public ConfigurationReader() throws IOException {
		f=new File("C:\\eclipse workspace\\Cucumber\\src\\test\\java\\com\\utilities\\Expected.properties");
		fis=new FileInputStream(f);
		p=new Properties();
		p.load(fis);
	}
	public String browserName1() {
		return p.getProperty("browserName1");
	}
	public String browserName2() {
		return p.getProperty("browserName2");
	}
	public String url() {
		return p.getProperty("url");
	}

}
