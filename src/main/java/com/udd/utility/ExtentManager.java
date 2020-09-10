package com.udd.utility;

import java.io.File;
import java.util.Date;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {

	static Date date = new Date();
	public static ExtentReports extent;
	public static String filename = "" + date.getTime() + ".html";
	public static String reportPath = "./reports/UDDreport.html";
//	private static Logger log;

	public static ExtentReports getInstance() {
		if (extent == null) {
//			log=LogInitilizer.getLogger();
			extent = new ExtentReports(reportPath, true);
//			log.debug("Initilizing report at - "+reportPath);
			File f =new File("./extent-config.xml");
//					new ResourceUtil().getFile("Properties/extent-config.xml");
			
			extent.loadConfig(f.getAbsoluteFile());
		}
		return extent;
	}
}
