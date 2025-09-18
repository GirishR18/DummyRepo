package crm.contacttest;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
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
import org.testng.annotations.Test;

public class CreateContactWithSupportDate_TC__005 {

	@Test
	public void createContactTest() throws Throwable {
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
		String lastName = wb.getSheet("Contacts").getRow(4).getCell(2).toString() + randomInt;

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
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(lastName);

		WebElement supportStartdate = driver.findElement(By.name("support_start_date"));
		supportStartdate.clear();
		
		// date class in java
		Date date = new Date();

		// simpleDateformatClassInJava
		SimpleDateFormat simp = new SimpleDateFormat("yyyy-MM-dd");
		simp.format(date);

		// calendar class
		Calendar cal = simp.getCalendar();
		// static variables 30 for next 30 days -30 for last 30days
		cal.add(Calendar.DAY_OF_MONTH, 30);
		String startdateRequired = simp.format(cal.getTime());
		
		supportStartdate.sendKeys(startdateRequired);
		
		WebElement supportEnddate = driver.findElement(By.name("support_end_date"));
		supportEnddate.clear();
		
		Calendar cal1 = simp.getCalendar();
		cal1.add(Calendar.DAY_OF_MONTH,60);
		String endDateRequired = simp.format(cal1.getTime());
		supportEnddate.sendKeys(endDateRequired);

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		//String headerText = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();


		String actualStartDate = driver.findElement(By.id("dtlview_Support Start Date")).getText();
		if (actualStartDate.equals(startdateRequired)) {
			System.out.println(startdateRequired + " is ==> PASS");
		} else {
			System.out.println(startdateRequired + " is ==> FAIL");
		}
		
		String actualEndDate = driver.findElement(By.id("dtlview_Support End Date")).getText();
		if (actualEndDate.equals(endDateRequired)) {
			System.out.println(endDateRequired + " is ==> PASS");
		} else {
			System.out.println(startdateRequired + " is ==> FAIL");
		}

		//Thread.sleep(2000);
		WebElement logoutEle = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions action = new Actions(driver);
		action.moveToElement(logoutEle).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();

	}

}
