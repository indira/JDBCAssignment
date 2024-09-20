import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCPreparedInsert {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// Step1: register the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// Step2: Establish the connection
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "root");
		System.out.println("Connection created");
		
		// Step3: Create PreparedStatement for insert query
		PreparedStatement ps = con.prepareStatement("INSERT INTO EMP values(?,?,?)");
		
		ps.setInt(1, 5);
		ps.setString(2, "Sarthak");
		ps.setDouble(3, 80000);
		
		// Step 4: Execute the INSERT query
		int rowsAffected = ps.executeUpdate();
		System.out.println(rowsAffected + " record(s) inserted.");
		
		// Step5 close the connection
		con.close();
		System.out.println("Connection Closed");
	}

}
