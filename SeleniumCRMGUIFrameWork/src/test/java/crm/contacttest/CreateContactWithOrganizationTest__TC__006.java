package crm.contacttest;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

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

public class CreateContactWithOrganizationTest__TC__006 {
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
		String lastName = wb.getSheet("Contacts").getRow(7).getCell(2).toString() + randomInt;
		String orgName = wb.getSheet("Contacts").getRow(7).getCell(3).toString()+ randomInt;
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
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		 //Go to Contacts (re-locate element freshly to avoid StaleElementReferenceException)
        try {
            driver.findElement(By.linkText("Contacts")).click();
        } catch (org.openqa.selenium.StaleElementReferenceException e) {
            // Retry once
            driver.findElement(By.linkText("Contacts")).click();
        }
        
     
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(lastName);

		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
	
		//switching the winodw
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		
		while(it.hasNext()) {
			String windowId =it.next();
			driver.switchTo().window(windowId);
			
			String actualUrl = driver.getCurrentUrl();
			if(actualUrl.contains("module=Accounts")) {
				break;
			}
		}
		
		driver.findElement(By.id("search_txt")).sendKeys(orgName);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[.='"+orgName+"']")).click();
		Set<String> set1 = driver.getWindowHandles();
		Iterator<String> it1 = set1.iterator();
		
		while(it1.hasNext()) {
			String windowId =it1.next();
			driver.switchTo().window(windowId);
			
			String actualUrl = driver.getCurrentUrl();
			if(actualUrl.contains("Contacts&action")) {
				break;
			}
		}

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		//String headerText = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();


		String actualLastName = driver.findElement(By.id("dtlview_Last Name")).getText();
		if (actualLastName.equals(lastName)) {
			System.out.println(lastName + " is created==> PASS");
		} else {
			System.out.println(lastName + " is not Created ==> FAIL");
		}
		
		String actualOrgName = driver.findElement(By.xpath("//td[@id='mouseArea_Organization Name']//a")).getText();
		if (actualOrgName.equals(orgName)) {
			System.out.println(orgName + " is Selected  ==> PASS");
		} else {
			System.out.println(orgName + " is  not Selected ==> FAIL");
		}

		//Thread.sleep(2000);
		WebElement logoutEle = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions action = new Actions(driver);
		action.moveToElement(logoutEle).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();

	}

}
