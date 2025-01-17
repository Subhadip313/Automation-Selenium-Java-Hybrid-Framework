package e_commerce.testComponenets;

import java.io.IOException;

import com.reportsConfig.ExtentReportsTestNG;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ListenerClass extends BaseTest implements ITestListener {
	int index=1;
	ExtentReports extent = ExtentReportsTestNG.getReportObject();
	ExtentTest test; 	
	WebDriver driver=null;
	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
		
			//System.out.println(result.getTestClass().getRealClass().getField("driver").get(result.getInstance()));
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "The Test is Passed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String ScreenshotPath = null;
		test.log(Status.FAIL, "The Test is Failed");
		test.fail(result.getThrowable()); 
		
		  try { driver = (WebDriver)
		  result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		  
		  } catch (IllegalArgumentException | IllegalAccessException |
		  NoSuchFieldException | SecurityException e) {
		  e.printStackTrace(); }
		 
			 String TestCaseName = result.getMethod().getMethodName();
			TestCaseName = TestCaseName+index;
		
		try {
			 ScreenshotPath = takeScreenshot(TestCaseName,driver);
			index=index+1;
		} catch (IOException e) {
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(ScreenshotPath, TestCaseName);
		System.out.println("ScreenshotPath: " + ScreenshotPath);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
		
	}

}
