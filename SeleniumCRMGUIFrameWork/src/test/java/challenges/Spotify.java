package challenges;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Spotify {

	@Test
	public void playTopSongTest() throws Throwable {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://open.spotify.com/");
		driver.findElement(By.xpath("//span[.='Log in']")).click();
//		driver.findElement(By.id("username")).sendKeys("girishrayamane18@gmail.com");
//		driver.findElement(By.xpath("//span[.='Continue']")).click();
		Actions action = new Actions(driver);

		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@aria-label='Home']")));

		driver.findElement(By.xpath("//input[@data-testid='search-input']")).sendKeys("Arijit Singh");
		driver.findElement(By.xpath("//span[.='Artists']")).click();
		driver.findElement(By.xpath(
				"//div[@role='button' and @aria-labelledby='card-title-spotify:artist:4YRxDV8wJFPHPTeXepOstw-0 card-subtitle-spotify:artist:4YRxDV8wJFPHPTeXepOstw-0']"))
				.click();
		action.scrollToElement(driver.findElement(By.xpath("//div[.='See more']"))).perform();

		ExcelUtility excelUtil = new ExcelUtility();
		String sheetName = "SpotifyTop5";
		excelUtil.writeDataToExcel(sheetName, 0, 0, "Song Name");
		excelUtil.writeDataToExcel(sheetName, 0, 1, "Streams");

		// Loop through top 5 songs using XPath index
		for (int i = 1; i <= 5; i++) {
			String baseXPath = "(//div[@data-testid='tracklist-row'])[" + i + "]";

			WebElement songRow = driver.findElement(By.xpath(baseXPath));

			String songName = songRow
					.findElement(By.xpath(".//a[@data-testid='internal-track-link']//div[@dir='auto']")).getText();
			String streams = songRow
					.findElement(By.xpath(".//div[contains(@class,'e-91000-text') and contains(text(),',')]"))
					.getText();

			// Write to Excel
			excelUtil.writeDataToExcel(sheetName, i, 0, songName);
			excelUtil.writeDataToExcel(sheetName, i, 1, streams);

			System.out.println(i + ". " + songName + " --> " + streams);
		}

		WebElement songElement = driver.findElement(By.xpath("//div[contains(text(),'Humdard')]"));
		songElement.click();

		// Wait until the play button becomes clickable (after DOM update)
		By playButtonLocator = By.xpath("(//button[contains(@aria-label, 'Play')])[4]");
		WebElement playBtn = wait.until(ExpectedConditions.elementToBeClickable(playButtonLocator));
		playBtn.click();

		// Optional: wait for 5 seconds to let the song play
		Thread.sleep(5000);
		driver.quit();
	}
}

//action.scrollByAmount(0, 500).perform();
//driver.findElement(By.id("username")).sendKeys("girishrayamane18@gmail.com");
//driver.findElement(By.xpath("//span[.='Continue']")).click();

//action.scrollToElement(driver.findElement(By.xpath("//span[.='Continue with phone number']"))).perform();
////driver.findElement(By.xpath("//a[.='Continue with Google']")).click();
//
//driver.findElement(By.xpath("//span[.='Continue with phone number']")).click();
//ChromeOptions options = new ChromeOptions();
//options.addArguments("--headless=new"); // for headless
//// or don't add this line at all for non-headless mode
//
//
//driver.findElement(By.id("phonelogin-phonenumber")).sendKeys("9008130944");
//driver.findElement(By.name("identifier")).sendKeys("girishrayamane18@gmail.com");
//driver.findElement(By.xpath("//span[.='Next']")).click();
//
////driver.findElement(By.xpath("//div[@data-identifier='girishrayamane18@gmail.com']")).click();
//driver.findElement(By.name("Passwd")).sendKeys("Girish@2699");
////enter otp 
//driver.findElement(By.xpath("//span[.='Next']")).click();