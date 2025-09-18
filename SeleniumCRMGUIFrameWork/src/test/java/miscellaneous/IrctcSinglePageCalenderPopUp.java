package miscellaneous;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class IrctcSinglePageCalenderPopUp {
	
	@Test
	public void IrctcPopUp() throws Exception {
		ChromeOptions options= new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.findElement(By.xpath("//button[.='OK']")).click();
		
		driver.findElement(By.id("origin")).click();
		driver.findElement(By.xpath("//input[@aria-controls='pr_id_1_list']")).sendKeys("KSR BENGALURU - SBC");
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).click().perform();
		
		Thread.sleep(2000);
		//driver.findElement(By.id("origin")).sendKeys("KSR BENGALURU - SBC");
		
		driver.findElement(By.id("destination")).click();
		driver.findElement(By.xpath("//input[@aria-controls='pr_id_2_list']")).sendKeys("BELAGAVI - BGM");
		action.sendKeys(Keys.ENTER);
		
		driver.findElement(By.id("journeyQuota")).click();
		WebElement ele = driver.findElement(By.xpath("//span[.='TATKAL']"));
		ele.click();
		
		
		driver.findElement(By.id("journeyClass")).click();
		WebElement journeyClass = driver.findElement(By.xpath("//span[.='Vistadome AC (EV)']"));
		journeyClass.click();
		
		driver.findElement(By.id("jDate")).click();
		//driver.findElement(By.xpath("//span[@role='presentation']")).click();
		driver.findElement(By.linkText("31")).click();
		driver.quit();
	}

}
