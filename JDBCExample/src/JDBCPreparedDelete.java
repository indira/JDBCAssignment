import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCPreparedDelete {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// Step1: register the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		// Step2: Establish the connection
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "root");
		System.out.println("Connection created");
		// Step3: Create PreparedStatement for DELETE query
		PreparedStatement ps = con.prepareStatement("DELETE FROM EMP WHERE id=?");
		ps.setInt(1, 5);
		// Step 4: Execute the DELETE query
		int rowsAffected = ps.executeUpdate();
		System.out.println(rowsAffected + " record(s) deleted.");

		// Step5 close the connection
		con.close();
		System.out.println("Connection Closed");
	}
}
