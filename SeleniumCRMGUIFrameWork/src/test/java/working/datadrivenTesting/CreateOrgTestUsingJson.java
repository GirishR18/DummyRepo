package working.datadrivenTesting;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateOrgTestUsingJson {

	public static void main(String[] args) throws Exception, IOException, ParseException {
		

		//Step 1: Parse json physical file into java object using json parse class
		JSONParser parser = new JSONParser();
				
		Object obj = parser.parse(new FileReader("C:\\Users\\DELL\\Desktop\\CommonDataJson.json"));
				
		//step 2:- convert java object into Json Object using downcasting
		JSONObject map = (JSONObject) obj;
		
		String BROWSER = map.get("browser").toString();
		String URL =  map.get("url").toString();
		String USERNAME =  map.get("username").toString();
		String PASSWORD =  map.get("password").toString();
		
		Random random = new Random();
		int randomInt = random.nextInt(1000);
		
		FileInputStream fis1 = new FileInputStream("C:\\Users\\DELL\\Desktop\\AdvanceSeleniumTestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		String orgName = wb.getSheet("CreateOrg").getRow(1).getCell(1).toString()+randomInt;
		


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
		String headerText = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();

		if (headerText.contains(orgName)) {
			System.out.println("Passed----");
		} else {
			System.out.println("failed");
		}

		WebElement logoutEle = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions action = new Actions(driver);
		action.moveToElement(logoutEle).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();

	}

}


