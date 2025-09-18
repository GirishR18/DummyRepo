package miscellaneous;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MakeMyTripBooking {
	
	@Test
	public void makemytrip() {
		String from ="Bengaluru";
		String to= "London";
		String date ="Fri Sep 26 2025";

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.get("https://www.makemytrip.com/");
		driver.findElement(By.xpath("//span[@data-cy='closeModal']")).click();
		driver.findElement(By.id("fromCity")).click();
		//driver.findElement(By.xpath("//input[@placeholder='From']")).click();
		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys(from);
		driver.findElement(By.xpath("//span[.='"+from+"']")).click();
		driver.findElement(By.id("toCity")).click();
		driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys(to);
		driver.findElement(By.xpath("//span[.='"+to+"']")).click();
		driver.findElement(By.xpath("//p[.='26']/../../..//div[@aria-label='"+date+"']")).click();
		
		driver.quit();

}
}


