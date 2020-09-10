package com.udd.utility;

import java.io.File;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LogInitilizer {
	private volatile static Logger instance;

	private LogInitilizer() {
	}

	public static Logger getLogger() {

		synchronized (LogInitilizer.class) {
			if (instance == null) {
				ClassLoader classLoader=LogInitilizer.class.getClassLoader();
				File file = new File(classLoader.getResource("log4j.properties").getFile());
				String path =file.getAbsolutePath();
				PropertyConfigurator.configure(path);
				instance = org.apache.log4j.Logger.getLogger("Logger");
				System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.Jdk14Logger");
				instance.debug("Debug Log is initialized");
			}
			return instance;
		}
	}
}
