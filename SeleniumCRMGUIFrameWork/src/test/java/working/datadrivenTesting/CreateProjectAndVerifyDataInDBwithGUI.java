package working.datadrivenTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import com.mysql.jdbc.Driver;

public class CreateProjectAndVerifyDataInDBwithGUI {

	public static void main(String[] args) throws Throwable {

		// create aproject in GUI or Front End using selenium code
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");

		WebDriver driver = new ChromeDriver(options);
		String expectedProjectName = "FaceBook205";

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://49.249.28.218:8091/");
		// driver.get("http://localhost:8091");

		driver.findElement(By.id("username")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[.='Sign in']")).click();
		driver.findElement(By.linkText("Projects")).click();
		driver.findElement(By.xpath("//span[.='Create Project']")).click();
		driver.findElement(By.name("projectName")).sendKeys(expectedProjectName);
		driver.findElement(By.name("createdBy")).sendKeys("me");
		driver.findElement(By.name("status"));
		WebElement status = driver.findElement(By.name("status"));
		Select projStatus = new Select(status);
		projStatus.selectByValue("Created");
		driver.findElement(By.xpath("//input[@value='Add Project']")).click();
		System.out.println("projectCreated");

		// verify The project in DB using JDBC

		boolean flag = false;
		Connection conn = null;
		try {

			// Step 1:- Load/Register the database driver
			Driver driver1 = new Driver();
			DriverManager.registerDriver(driver1);

			// Step 2:- connect to database
			conn = DriverManager.getConnection("jdbc:mysql://49.249.28.218:3307/projects", "root@%", "root");
			System.out.println("=====Done=======");

			// Step 3:- create sql statement
			Statement stat = conn.createStatement();

			// Step 4:-execute select query and get result
			ResultSet resultSet = stat.executeQuery("select * from project");
			while (resultSet.next()) {
				String actualProjectName = resultSet.getString(4);
				if (expectedProjectName.equals(actualProjectName)) {
					flag = true;
					System.out.println(expectedProjectName + " is available = PASS");
				}
			}
			if (flag == false) {
				System.out.println(expectedProjectName + " is not available = FALSE");
				//Assert.fail();
			}
		} catch (Exception e) {
			System.out.println("Handle Exception");
		}

		finally {
			// step 5:- close The Connection
			conn.close();
			System.out.println("Connection Closed");

		}
		driver.quit();

	}

}