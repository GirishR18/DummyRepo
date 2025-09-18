package working.datadrivenTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

public class SampleUnitTestCheckProjectInBackEnd {
	@Test
	public void projectCheckTest() throws Throwable {

		String expectedProjectName = "Insta_0109";
		boolean flag = false;
		Connection conn = null;
		try {

			// Step 1:- Load/Register the database driver
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);

			// Step 2:- connect to database
			conn = DriverManager.getConnection("jdbc:mysql://49.249.28.218:3307/ninza_hrm", "root@%", "root");
			System.out.println("=====Done=======");

			// Step 3:- create sql statement
			Statement stat = conn.createStatement();

			//// Step 4:-execute select query and get result
			ResultSet resultSet = stat.executeQuery("select * from project");
			while (resultSet.next()) {
				String actualProjectName = resultSet.getString(4);
				if (expectedProjectName.equals(actualProjectName)) {
					flag = true;
					System.out.println(expectedProjectName + "is available = PASS");
				}
			}
			if (flag == false) {
				System.out.println(expectedProjectName + "is not available = FALSE");
				Assert.fail();
			}
		} catch (Exception e) {
			System.out.println("Handle Exception");
		}

		finally {
			// step 5:- close The Connection
			conn.close();
			System.out.println("Connection Closed");

		}

	}

}
