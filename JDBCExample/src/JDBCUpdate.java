import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUpdate {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
		System.out.println("Connection Created");
		
		Statement st = con.createStatement();
		int result = st.executeUpdate("Update emp set salary=60000.00 WHERE id = 1 ");
		System.out.println(result+" record updated");
		
		con.close();
		System.out.println("Connection closed.");
	}

}
