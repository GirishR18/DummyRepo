
package miscellaneous;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class AirIndiaBooking {

	@Test
	public void airIndiaBooking() {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		WebDriver driver = new ChromeDriver(options);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.get("https://www.airindia.com/");
		driver.findElement(By.id("onetrust-accept-btn-handler")).click();
		
//		 // Step 1️⃣: Locate <ai-tab-group> (this is the first shadow host)
        WebElement outerHost = driver.findElement(By.cssSelector("ai-tab-group"));
        SearchContext shadow1 = outerHost.getShadowRoot();

//        // Step 2️⃣: Inside shadow1, find ai-search-flight directly (no ai-tab)
        WebElement searchFlight = shadow1.findElement(By.cssSelector("ai-search-flight"));
        SearchContext shadow2 = searchFlight.getShadowRoot();

        // Step 3️⃣: Inside ai-search-flight → ai-origin-destination
        WebElement originDest = shadow2.findElement(By.cssSelector("ai-origin-destination"));
        SearchContext shadow3 = originDest.getShadowRoot();

        // Step 4️⃣: Inside ai-origin-destination → click FROM wrapper
        WebElement fromWrapper = shadow3.findElement(By.xpath("//div[@class='ai-od-input-wrapper ai-od-origin-wrapper']"));
        fromWrapper.click();

        // Step 5️⃣: Inside ai-origin-destination → ai-autocomplete
        WebElement autoComplete = shadow3.findElement(By.id("originAutoComplete"));
        SearchContext shadow4 = autoComplete.getShadowRoot();

        // Step 6️⃣: Locate the FROM input field and send text
        WebElement fromInput = shadow4.findElement(By.xpath("//input[@data-id='ai-autocomplete-input-FROM']"));
        fromInput.clear();
        fromInput.sendKeys("Delhi");
	    System.out.println("✅ Clicked on FROM input field successfully");
		driver.findElement(By.xpath("//label[@data-id='FROM']")).click();
		driver.findElement(By.id("dpFromDate")).click();
		driver.findElement(By.xpath("//div[.=' September 2025 ']"));
		driver.findElement(By.xpath("//div[@aria-label='Friday, September 26, 2025']")).click();
		}
	
}