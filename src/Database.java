import java.sql.Connection;
import java.sql.DriverManager;

public class Database {

	// Database connection

	public static Connection databaseConn() {

		try {
			Class.forName("org.sqlite.JDBC");

			Connection connect = DriverManager.getConnection("jdbc:sqlite:/Users/macbook/Documents/Group_Project_Implementation/lib/patientInfo.db");
			System.out.println("Database connection successfully established.");
			return connect;
		} catch (Exception e) {
			System.out.print("connectdd");
			e.printStackTrace();
			System.out.println("Database not connected");
			return null;
		}
	}
	

}
