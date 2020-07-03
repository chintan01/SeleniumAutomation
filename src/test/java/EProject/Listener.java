package EProject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.ExtentReporterNG;
import resources.base;

public class Listener extends base implements ITestListener{

	ExtentTest test;
	ExtentReports extent=ExtentReporterNG.getReportObject();
	ThreadLocal<ExtentTest> extentTest =new ThreadLocal<ExtentTest>();

	public void onTestStart(ITestResult result) {  
	// TODO Auto-generated method stub  
		test= extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
		
	}  
	  
	public void onTestSuccess(ITestResult result) {  
	// TODO Auto-generated method stub  
	System.out.println("Success of test cases and its details are : "+result.getName());  
	extentTest.get().log(Status.PASS, "Test Passed");

	}  
	  
	public void onTestFailure(ITestResult result) {  
	// TODO Auto-generated method stub  
	//Screenshot code	
	System.out.println("Failure of test cases and its details are : "+result.getName());  
	extentTest.get().fail(result.getThrowable());
	WebDriver driver =null;
	String testMethodName =result.getMethod().getMethodName();
	
	try {
		driver =(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
	} catch(Exception e)
	{
		
	}
	try {
		extentTest.get().addScreenCaptureFromPath(getScreenShotPath(testMethodName,driver), result.getMethod().getMethodName());
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}  
	  

	public void onTestSkipped(ITestResult result) {  
	// TODO Auto-generated method stub  
	System.out.println("Skip of test cases and its details are : "+result.getName());  
	}  
	  
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {  
	// TODO Auto-generated method stub  
	System.out.println("Failure of test cases and its details are : "+result.getName());  
	}  
	  
	public void onStart(ITestContext context) {  
	// TODO Auto-generated method stub  
	}  
	  
	public void onFinish(ITestContext context) {  
	// TODO Auto-generated method stub  
		
		extent.flush();
	}  

	
}
