package com.Log;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log {
	static Logger log = Logger.getLogger("Log");
	public static void info(String message) throws FileNotFoundException {
		FileInputStream file = new FileInputStream("Log4j.properties");
		PropertyConfigurator.configure(file);
		log.info(message);
	}
}
