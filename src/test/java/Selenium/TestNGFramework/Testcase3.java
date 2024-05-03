package Selenium.TestNGFramework;

import org.testng.annotations.Test;

import org.testng.Assert;
public class Testcase3 {
	
	@Test(priority=1)
	public void userReg()
	{
		System.out.println("user Reg");
		Assert.fail("user not registered sucessful");
	}
	
	
    @Test(priority=2,dependsOnMethods="userReg")
	public void Login()
	{
		System.out.println("Login");
	}
    
    @Test(priority=3,dependsOnMethods="userReg",alwaysRun=true)
    public static void thirdTest()
    {
    	System.out.println("Third test");
    }
    
    @Test(priority=4)
    public static void fourthTest()
    {
    	System.out.println("fourth test");
    }


}
