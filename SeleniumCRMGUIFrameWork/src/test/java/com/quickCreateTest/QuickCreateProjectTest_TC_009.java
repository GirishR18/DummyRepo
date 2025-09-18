package com.quickCreateTest;

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

public class QuickCreateProjectTest_TC_009 {
	 String monthYear= "September, 2025";
	 String date="26";

	@Test
	public void createOrg() throws Throwable {
		
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
		String projectName = wb.getSheet("Orgnization").getRow(7).getCell(2).toString()+randomInt;


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
		WebElement quickCreate = driver.findElement(By.id("qccombo"));
		
		Select createProject = new Select(quickCreate);
		createProject.selectByValue("Project");
		
		driver.findElement(By.name("projectname")).sendKeys(projectName);
		
		driver.findElement(By.id("jscal_trigger_targetenddate")).click();
		for(;;) {
			try {
				
				if(driver.findElement(By.xpath("//td[@class='title']")) != null)
					driver.findElement(By.xpath("//td[.='"+date+"']")).click();
				break;
			}
			catch (Exception e) {
				driver.findElement(By.xpath("//td[.='›']")).click();
			}
		}
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String headerText = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();

		if (headerText.contains(projectName)) {
			System.out.println(projectName +" is Created ==> PASSED---");
		} else {
			System.out.println(projectName +" is not Created ==> FAILED");
		}
		
		String actualProjectName = driver.findElement(By.id("dtlview_Project Name")).getText();
		if (actualProjectName.equals(projectName)) {
			System.out.println(projectName +" is Created ==> PASS");
		} else {
			System.out.println(projectName +" information is not Created ==> FAIL");
		}
		
		String actualEndDate = driver.findElement(By.xpath("//td[.='Target End Date']/following-sibling::td[@class='dvtCellInfo']")).getText();
		if (actualEndDate.contains(date)) {
			System.out.println(date +" is Created ==> PASS");
		} else {
			System.out.println(date +" information is not Created ==> FAIL");
		}


		WebElement logoutEle = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions action = new Actions(driver);
		action.moveToElement(logoutEle).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();

	}

}
		

