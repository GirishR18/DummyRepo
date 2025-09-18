package working.datadrivenTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class ReadTheDataFromJDBCSelectQueryTest {

	public static void main(String[] args) throws Throwable {

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
			// to get all values of table
			while (resultSet.next()) {
				System.out.println(
						resultSet.getString(1) + "\t" + resultSet.getString(2) + "\t" + resultSet.getString(3) + "\t"
								+ resultSet.getString(4) + "\t" + resultSet.getString(5) + "\t" + resultSet.getInt(6));
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
