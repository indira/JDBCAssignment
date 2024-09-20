import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDelete {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
				// Step1: register the driver
				Class.forName("com.mysql.cj.jdbc.Driver");
				//Step2: Establish the connection
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
				System.out.println("Connection created");
				
				//Step3: create Statement
				Statement st = con.createStatement();
				
				//Step4: add query into statement and send it for execution
				int result = st.executeUpdate("Delete from emp where id= 5");
				System.out.println(result+" record deleted.");
				//Step5 close the connection
				con.close();
				System.out.println("Connection Closed");

	}

}
