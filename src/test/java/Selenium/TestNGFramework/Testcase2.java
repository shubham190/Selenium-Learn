package Selenium.TestNGFramework;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Testcase2 {
	
	@Test
	public void validateTittle()
	
	{
		System.out.println("Begining");
		String expTittle="Yahoo.com";
		String actTittle="Gmail";
		
		SoftAssert ass= new SoftAssert();
		
		ass.assertEquals(expTittle, actTittle);
		ass.assertEquals(true, false);
		
		//Assert.fail("Faling the Test case as not meet expect behaviour");
		System.out.println("Ending");
		
		ass.assertAll();
	}

}
