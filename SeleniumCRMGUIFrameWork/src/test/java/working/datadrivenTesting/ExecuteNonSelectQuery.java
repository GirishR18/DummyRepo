package working.datadrivenTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class ExecuteNonSelectQuery {

	public static void main(String[] args) throws Throwable {
		// Step 1:- Load/Register the database driver

		Connection conn = null;
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);

			// Step 2:- connect to database
			conn = DriverManager.getConnection("jdbc:mysql://49.249.28.218:3307/ninza_hrm", "root@%", "root");
			System.out.println("=====Done=======");

			// Step 3:- create sql statement
			Statement stat = conn.createStatement();

			//// Step 4:-execute noselect query(insert) and get result
			int resultSet = stat.executeUpdate(
					"insert into project values('TY_PROJ_002', 'NewUser','26/08/2025','Insta_0109','Started',200)");
			System.out.println(resultSet);

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
