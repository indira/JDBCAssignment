import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCSelect {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// Step1: register the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		//Step2: Establish the connection
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
		System.out.println("Connection created");
		
		//Step3: create Statement
		Statement st = con.createStatement();
		
		//Step4: add query into statement and send it for execution
		ResultSet rs = st.executeQuery("Select * from emp");
		while(rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			double salary = rs.getDouble("salary");
			System.out.println(id+" "+name+" "+salary);
		}
		
		ResultSet rs1 = st.executeQuery("Select * from emp where id = 1");
		if(rs1.next()) {
			int id = rs1.getInt("id");
			String name = rs1.getString("name");
			double salary = rs1.getDouble("salary");
			System.out.println("Selecting only one element from the table.");
			System.out.println(id+" "+name+" "+salary);
		}
		//Step5 close the connection
		con.close();
		System.out.println("Connection Closed");
	}
}
