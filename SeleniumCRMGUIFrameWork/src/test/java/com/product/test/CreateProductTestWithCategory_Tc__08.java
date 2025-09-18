package com.product.test;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class CreateProductTestWithCategory_Tc__08 {
	@Test
	public void createProductTest() throws Throwable {
		FileInputStream fis = new FileInputStream("C:\\Users\\DELL\\Desktop\\commonData.properties");
		Properties prop = new Properties();
		prop.load(fis);

		String BROWSER = prop.getProperty("browser");
		String URL = prop.getProperty("url");
		String USERNAME = prop.getProperty("username");
		String PASSWORD = prop.getProperty("password");

		Random random = new Random();
		int randomInt = random.nextInt(1000);

		FileInputStream fis1 = new FileInputStream("C:\\Users\\DELL\\Desktop\\AdvanceSeleniumTestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		String productName = wb.getSheet("Product").getRow(1).getCell(2).toString() + randomInt;
		String productCategoryName = wb.getSheet("Product").getRow(1).getCell(3).toString();

		WebDriver driver = null;

		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equals("Edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}

		// WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
		driver.findElement(By.name("productname")).sendKeys(productName);
		WebElement category = driver.findElement(By.name("productcategory"));
		Select selCategory = new Select(category);
		selCategory.selectByValue(productCategoryName);
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		
		String actualproductName = driver.findElement(By.id("dtlview_Product Name")).getText();
		if (actualproductName.equals(productName)) {
			System.out.println(productName +" is ==> PASS");
		} else {
			System.out.println(productName +" is ==> FAIL");
		}
		

		String actualproductCatgory = driver.findElement(By.id("dtlview_Product Category")).getText();
		if (actualproductCatgory.equals(productCategoryName)) {
			System.out.println(productCategoryName +" is ==> PASS");
		} else {
			System.out.println(productCategoryName +" is ==> FAIL");
		}

		WebElement logoutEle = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions action = new Actions(driver);
		action.moveToElement(logoutEle).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();

	}

}
