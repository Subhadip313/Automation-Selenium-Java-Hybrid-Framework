package com.reportsConfig;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsTestNG {
	
	public static ExtentReports getReportObject(){
		String Path= System.getProperty("user.dir")+"\\src\\test\\java\\HospitalProject\\testReports\\index.html";
		ExtentSparkReporter report = new ExtentSparkReporter(Path);
		report.config().setDocumentTitle("Hospital-Project Automation");
		report.config().setReportName("Test Results");
		ExtentReports test = new ExtentReports();
		test.attachReporter(report);
		test.setSystemInfo("tester", "Subhadip Dutta");
		return test;
	}

}
