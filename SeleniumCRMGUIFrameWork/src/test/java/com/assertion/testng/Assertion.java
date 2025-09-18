package com.assertion.testng;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assertion {

	@Test
	public void homePageTest(Method mtd) {

		System.out.println(mtd.getName() + " Test start");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://localhost:8888/");
		String expectedPageName = "Homes";

		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("password");
		driver.findElement(By.id("submitButton")).click();

		String actName = driver.findElement(By.partialLinkText("Home")).getText();

		Assert.assertEquals(actName, expectedPageName);

		driver.close();
		System.out.println(mtd.getName() + " Test End");

	}

	@Test
	public void vtigerLogoTest(Method mtd) {

		System.out.println(mtd.getName() + " Test start");
		
		// soft assert
		SoftAssert assertObj = new SoftAssert();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://localhost:8888/");
		// String expectedPageName = "Home";

		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("password");
		driver.findElement(By.id("submitButton")).click();

		boolean status = driver.findElement(By.xpath("//img[@title='vtiger-crm-logo.gif']")).isEnabled();

		assertObj.assertTrue(status);
		assertObj.assertAll();

		driver.close();
		System.out.println(mtd.getName() + " Test End");
	}
}
