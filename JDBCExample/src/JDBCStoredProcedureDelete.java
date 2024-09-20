import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCStoredProcedureDelete {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // Step 1: Register the driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Step 2: Establish the connection
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "root");
        System.out.println("Connection created");

        // Step 3: Prepare the stored procedure call
        CallableStatement cs = con.prepareCall("{CALL DeleteEmployee(?)}");
        
        cs.setInt(1, 6);               

        // Step 4: Execute the stored procedure
        cs.executeUpdate();
        System.out.println("Record deleted using stored procedure.");

        // Step 5: Close the connection
        con.close();
        System.out.println("Connection Closed");
    }
}