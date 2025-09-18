package miscellaneous;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BrokenLinksTest {

	@Test
	public void brokenLink() throws Throwable {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.epfindia.gov.in");
		
		List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
		System.out.println(allLinks.size());
		//or
		//List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		
		for (WebElement links : allLinks) {
			//String eachLink = links.getDomAttribute("href");
			String eachLink = links.getAttribute("href");
			try {
			URL url = new URL(eachLink);// depricated
			//URI uri = new URI(eachLink);
			 HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
			 int statusCode = httpConn.getResponseCode();
			 if(statusCode >=400) {
				 System.out.println(eachLink +"===>"+ statusCode);
			 }
			}
			catch (Exception e) {
				// TODO: handle exception
			}
			
		}
	}
}
