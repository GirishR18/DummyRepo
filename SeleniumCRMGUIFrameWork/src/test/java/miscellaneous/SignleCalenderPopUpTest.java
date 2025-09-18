package miscellaneous;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class SignleCalenderPopUpTest {
	@Test
	public void signleCalenderPopUp() throws Throwable {
		String from= "Bangalore";
		String to ="Chennai";
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.redbus.in");

		driver.findElement(By.xpath("//div[contains(text(),'From')]")).click();
		//dynamic Xpath
		driver.findElement(By.xpath("//div[contains(@aria-label,'"+from+"')]")).click();
	
		WebElement desination = driver.findElement(By.xpath("//i[@class='icon___be1a22 icon icon-dropping_point']/following-sibling::div"));
		Actions action = new Actions(driver);
		action.sendKeys(desination, to).perform();
		action.click(driver.findElement(By.xpath("//div[contains(@aria-label,'"+to+"')]"))).perform();

		driver.findElement(By.xpath("//div[@class='dojWrapper___1f3d15']")).click();
        driver.findElement(By.xpath("//span[.='31']")).click();

		driver.quit();
	}
}