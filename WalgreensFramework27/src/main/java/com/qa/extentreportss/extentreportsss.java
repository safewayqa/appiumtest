package com.qa.extentreportss;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class extentreportsss {
private static ExtentReports extent;
	
	public static ExtentReports createInstance() {
		 // start reporters
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("./Reports/extent.html");
        //htmlReporter.loadXMLConfig("extent-config.xml");
        // create ExtentReports and attach reporter(s)
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        
        
        return extent;
	}
	public static ExtentReports getInstance() {
		if(extent == null) {
			createInstance();
		}
		return extent;
	}
}
