package working.datadrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SampleDataDrivenTesting {

	public static void main(String[] args) throws IOException {
		//Step 1:- get the java representation object of the physical file
		FileInputStream fis = new FileInputStream("C:\\Users\\DELL\\Desktop\\commonData.properties");
		
		//Step 2:- using Properties class load all the keys
		Properties prop = new Properties();
		prop.load(fis);
		
		//Step 3:- get the value based on key 
		//System.out.println(prop.getProperty("browser"));
		
		
		String BROWSER = prop.getProperty("browser");
		String URL = prop.getProperty("url");
		String USERNAME = prop.getProperty("username");
		String PASSWORD = prop.getProperty("password");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		
		driver.quit();
		
	}

}
