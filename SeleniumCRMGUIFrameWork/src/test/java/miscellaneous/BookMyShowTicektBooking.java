package miscellaneous;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class BookMyShowTicektBooking {

	@Test
	public void bookMyShow() {

		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.get("https://in.bookmyshow.com/explore/home/bengaluru");
		WebElement elemnt = driver.findElement(By.xpath("//div[text()='Su From So']"));
		Actions action = new Actions(driver);
		action.scrollToElement(elemnt).click().perform();
		
		driver.findElement(By.xpath("//span[contains(.,'Search for Movies')]")).click();
		
		

	}
}