package crm.org.test;

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

public class CreateOrganizationWithIndustryAndTypeTest_TC__002 {

	@Test
	public void createOrganizationWithIndustryType() throws Throwable {
		
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
		String orgName = wb.getSheet("Orgnization").getRow(4).getCell(2).toString()+randomInt;
		String industry = wb.getSheet("Orgnization").getRow(4).getCell(3).toString()+randomInt;
		String type = wb.getSheet("Orgnization").getRow(4).getCell(4).toString()+randomInt;
		

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
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		
		//Industry
		WebElement selIndustry = driver.findElement(By.name("industry"));
		Select sel1 = new Select(selIndustry);
		sel1.selectByVisibleText("Energy");
		
		//type 
		WebElement selIndustryType = driver.findElement(By.name("accounttype"));
		Select sel2 = new Select(selIndustryType);
		sel2.selectByVisibleText("Press");
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String actualIndustry = driver.findElement(By.id("dtlview_Industry")).getText();
		

		if (actualIndustry.equals(industry)) {
			System.out.println(industry +" is Created ==> PASSED---");
		} else {
			System.out.println(industry +" is not Created ==> FAILED");
		}
		
		String actualType = driver.findElement(By.id("dtlview_Type")).getText();
		if (actualType.equals(type)) {
			System.out.println(type +" is Created ==> PASS");
		} else {
			System.out.println(type +" information is not Created ==> FAIL");
		}


		WebElement logoutEle = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions action = new Actions(driver);
		action.moveToElement(logoutEle).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();

	}

}
		

