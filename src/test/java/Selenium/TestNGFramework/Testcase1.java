package Selenium.TestNGFramework;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Testcase1 {
	
	@BeforeTest
	public void DBconnection()
	{
		System.out.println("Db connection");
	}
	
	@AfterTest
	public void DBcloseconnection()
	{
		System.out.println("Db close connection");
	}
	
	
	@BeforeMethod
	public void LauchBrowser()
	{
		System.out.println("Launch browser");
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		System.out.println("Close Browser");
	}
	
	@Test(priority=1)
	public void Login()
	{
		System.out.println("Execute do login");
	}
	
	
    @Test(priority=2)
	public void Logout()
	{
		System.out.println("Execute do logout");
	}
    
    @Test(priority=3)
	public void click()
	{
		System.out.println("click on element");
	}
}
