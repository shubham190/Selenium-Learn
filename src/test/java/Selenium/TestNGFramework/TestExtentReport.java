package Selenium.TestNGFramework;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class TestExtentReport {
	
	public ExtentSparkReporter htmlReport; //Create HTML file and add configuration
	
	public ExtentReports extent; //Attaching reporting,create test cases and other classes
	
	public ExtentTest test; // Maintain the test cases, adding log status pass and fail
	
	
	@BeforeTest
	public void setReport()
	{
		htmlReport = new ExtentSparkReporter("./reports/extent.html");
		
		htmlReport.config().setEncoding("utf-8");
		htmlReport.config().setDocumentTitle("Automation Report");
		htmlReport.config().setReportName("Automation Test Result");
		htmlReport.config().setTheme(Theme.STANDARD);
		
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReport);
		
		extent.setSystemInfo("Automation Tester", "Shubham Agrawal");
		extent.setSystemInfo("Build No.", "12345");
		extent.setSystemInfo("Organization", "Automation Tester");
	}
	
	@Test
	public void DoLogin()
	{
		
		test=extent.createTest("Login Test");
		test.log(Status.INFO,"Enter username");
		test.log(Status.INFO,"Enter Password");
		System.out.println("Login sucessful");
	}
	
	@Test
	public void InvalidLogin()
	{
		test=extent.createTest("Invalid user");
		test.log(Status.INFO,"Enter username");
		test.log(Status.INFO,"Enter Password");
		//test.fail("Fail the test case");
		Assert.fail();
	}
	
	@Test
	public void userReg()
	{
		test=extent.createTest("UserRegistration");
		test.log(Status.INFO,"Filling form");
		//test.fail("Fail the test case");
		
	}
	
	@Test()
	public void isSkipTest()
	{
		test=extent.createTest("Skip Test");
		test.log(Status.INFO,"Entering some data");
		//test.skip("Skip the Test case");
		throw new SkipException("Skip the test case");
	
	}
	
	@AfterMethod
	public void updateResult(ITestResult result) // I test result is a interface in Test ng
	{
		
		if(result.getStatus()==ITestResult.FAILURE)
		{
			String Methodname= result.getMethod().getMethodName();
			//Adding level for better visibility in report
			Markup m=MarkupHelper.createLabel("test case fail : " +Methodname.toUpperCase(), ExtentColor.RED);
			
			
			test.fail(m);
		}
		else if (result.getStatus()==ITestResult.SUCCESS) {
			
			String Methodname= result.getMethod().getMethodName();
			Markup m=MarkupHelper.createLabel("Test case pass :" + Methodname.toUpperCase(),ExtentColor.GREEN);
			test.pass(m);
		}
		else if (result.getStatus()==ITestResult.SKIP) {
			String Methodname= result.getMethod().getMethodName();
			Markup m=MarkupHelper.createLabel("Test case skip :" + Methodname.toUpperCase(),ExtentColor.YELLOW);
			test.skip(m);
			
		}
	}
	
	@AfterTest
	public void endReport()
	{
		extent.flush();
	}

}
