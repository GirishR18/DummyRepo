package com.assertion.testng;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HomePageSampleTest {
	
	@Test
	public void homePageTest(Method mtd) {
		Reporter.log(mtd.getName()+"Test Start");
		Reporter.log("step1");
		Reporter.log("step2");
		Assert.assertEquals("Home", "Home_page");
		Reporter.log("Step 3");
		Assert.assertEquals("Home", "Home-CRM");
		Reporter.log("Step 4");
		Reporter.log(mtd.getName()+"End");
		
	}
	
	//soft assert
	@Test
	public void LogohomePageTest(Method mtd) {
		Reporter.log(mtd.getName()+"Test Start");
		SoftAssert assertObj = new SoftAssert();
		Reporter.log("step1");
		Reporter.log("step2");
		assertObj.assertEquals("Home", "Home");
		//assertObj.assertTrue(true);
		Reporter.log("Step 3");
		Reporter.log("Step 4");
		assertObj.assertAll();
		Reporter.log(mtd.getName()+"End");
	}

}
