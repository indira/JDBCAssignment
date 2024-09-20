import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCPreparedSelect {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// Step1: register the driver
				Class.forName("com.mysql.cj.jdbc.Driver");
				// Step2: Establish the connection
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "root");
				System.out.println("Connection created");
				// Step3: Create PreparedStatement for insert query
				PreparedStatement ps = con.prepareStatement("SELECT * FROM EMP");
				// Step 4: Execute the INSERT query
				ResultSet rs = ps.executeQuery();
				System.out.println( "Selected records for select all: ");
				while(rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("name");
					Double sal = rs.getDouble("salary");
					System.out.println(id+" "+name+" "+sal);
				}
				PreparedStatement ps1 = con.prepareStatement("SELECT * FROM EMP WHERE id=?");
				// Set the id (parameter index 1)
				ps1.setInt(1, 4);
				// Step 4: Execute the SELECT query
				ResultSet rs1 = ps1.executeQuery();
				System.out.println("Single id selection: ");
				if(rs1.next()) {
					int id = rs1.getInt("id");
					String name = rs1.getString("name");
					double Sal = rs1.getDouble("salary");
					
					System.out.println(id+" "+name+" "+" "+Sal);
				}
				
				
				// Step5 close the connection
				con.close();
				System.out.println("Connection Closed");

	}

}
