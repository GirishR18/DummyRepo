package miscellaneous;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class MultipleCalenderPopUpTest {

	@Test
	public void MultiCalenderPopUp() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		String monthYear ="September 2025";
		String date ="26";

		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.goibibo.com/flights");
		driver.findElement(By.xpath("//span[@role='presentation']")).click();
		WebElement fromEle = driver.findElement(By.xpath("//span[.='From']/following-sibling::p"));
		Actions action = new Actions(driver);
		action.click(fromEle).perform();
		action.sendKeys(fromEle, "Bangalore").perform();
		action.click(driver.findElement(By.xpath("//span[contains(.,'Bengaluru, India')]"))).perform();
		
		WebElement toEle = driver.findElement(By.xpath("//span[.='To']/following-sibling::p"));
		action.sendKeys(toEle,"Goa").perform();
		action.click(driver.findElement(By.xpath("//span[contains(.,'Goa - Dabolim Airport, India')]"))).perform();
		driver.findElement(By.xpath("//span[.='Departure']")).click();
		for(;;) {
			try {
				driver.findElement(By.xpath("//div[.='"+monthYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[.='"+date+"']")).click();
				break;
			}
			catch (Exception e) {
				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
			}
		}
	
		driver.quit();
	}
}
