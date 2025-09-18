package miscellaneous;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class KsrtcBooking {
	@Test
	public void IrctcPopUp() throws Exception {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.get("https://ksrtc.in/");
		Actions action = new Actions(driver);
		action.scrollByAmount(0, 500).perform();

		driver.findElement(By.id("fromCity_chosen")).click();
		action.sendKeys("Belagavi").perform();
		action.sendKeys(Keys.ENTER).perform();


		driver.findElement(By.id("toCity_chosen")).click();
		action.sendKeys("Bangalore").perform();

		action.sendKeys(Keys.ENTER).perform();
		

		driver.findElement(By.id("departDate")).click();

		driver.findElement(By.xpath("//td[@data-month='8']/../..//a[.='26']")).click();
		driver.quit();

	}
}