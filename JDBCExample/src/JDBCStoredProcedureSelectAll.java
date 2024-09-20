import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCStoredProcedureSelectAll {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// Step 1: Register the driver
		Class.forName("com.mysql.cj.jdbc.Driver");

		// Step 2: Establish the connection
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "root");
		System.out.println("Connection created");

		// Step 3: Prepare the stored procedure call
		CallableStatement cs = con.prepareCall("{CALL SelectAllEmployee()}");
		
		// Step 4: Execute the stored procedure
		ResultSet rs = cs.executeQuery();

		// Step 5: Process the result set
		while (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			double salary = rs.getDouble("salary");
			System.out.println("ID: " + id + ", Name: " + name + ", Salary: " + salary);
		}

		// Step 4: Execute the stored procedure
		cs.executeUpdate();
		System.out.println("Record selected using stored procedure.");

		// Step 5: Close the connection
		con.close();
		System.out.println("Connection Closed");
	}
}