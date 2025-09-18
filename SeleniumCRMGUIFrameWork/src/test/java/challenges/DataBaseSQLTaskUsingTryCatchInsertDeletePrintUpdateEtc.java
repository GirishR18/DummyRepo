package challenges;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DataBaseSQLTaskUsingTryCatchInsertDeletePrintUpdateEtc {

	public static void main(String[] args) throws Throwable {
		Connection conn = null;
		String url = "jdbc:mysql://127.0.0.1:3306/ems";
		String username = "root";
		String password = "root";
		String dbName = "DB3";
		String tbName = "TB3";

		try {
			// Step 1:- Load/Register the database driver
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);

			// Step 2:- connect to database
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("=====Connected to MySQL=======");

			// Step 3:- create sql statement
			Statement stmt = conn.createStatement();
			int dbcount = stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS " + dbName);
			System.out.println(dbcount+" Database checked/created.");

			// Step 4: Use the database using just exeute 
			stmt.execute("USE " + dbName);

			// Step 5: Create table if not exists
			String createTable1 = "CREATE TABLE IF NOT EXISTS " + tbName + " (" + "JercyNumber INT PRIMARY KEY, "
					+ "PlayerName VARCHAR(25), " + "HighestScore INT)";
			stmt.executeUpdate(createTable1);
			System.out.println("Table created.");

			// Step 6-> Insert Values
			String insertValues = "INSERT INTO " + tbName + " (JercyNumber, PlayerName, HighestScore) VALUES "
					+ "(18, 'Virat Kohli', 183), " + "(7, 'MS Dhoni', 183), " + "(45, 'Rohit Sharma', 264), "
					+ "(10, 'Sachin Tendulkar', 200), " + "(17, 'Rishabh Pant', 125)";
			int valuesInserted = stmt.executeUpdate(insertValues);
			System.out.println(valuesInserted+" Values have been inserted.");

			// Step 7: Print all values
			System.out.println("\n--- Data in " + tbName + " Table ---");
			ResultSet rs = stmt.executeQuery("SELECT * FROM " + tbName);
			while (rs.next()) {
				System.out.println(rs.getInt("JercyNumber") + "\t" + rs.getString("PlayerName") + "\t"
						+ rs.getInt("HighestScore"));
			}

			// Step 8: Delete a record
			int deletedRows = stmt.executeUpdate("DELETE FROM " + tbName + " WHERE PlayerName = 'Rishabh Pant'");
			System.out.println(deletedRows+" \nDeleted Rishabh Pant");

			// Step 9: Print updated table
			System.out.println("\n--- Updated " + tbName + " Table ---");
			rs = stmt.executeQuery("SELECT * FROM " + tbName);
			while (rs.next()) {
				System.out.println(rs.getInt("JercyNumber") + "\t" + rs.getString("PlayerName") + "\t"
						+ rs.getInt("HighestScore"));
			}

		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		} finally {

			conn.close();
			System.out.println("Connection Closed");

		}
	}
}