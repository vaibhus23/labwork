package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Tired {
	
	public static void main(String args[]) throws SQLException
	{

try {
	DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
	Connection conn  = DriverManager.getConnection(
			"jdbc:oracle:thin:@localhost:1521/XE","vaibhus","vaibhu");
	
	Statement stmt = conn.createStatement();
	int count = stmt.executeUpdate("insert into employee values(3,'Sanjay','Testing',12,'15-Jan-21',19000,2563,32)");
	
	
			System.out.println("Record is inserted Successfully!!"+count);
			
	 }	
	catch(SQLException e)
					{
					System.out.println(e.getMessage());
				    }
				
  }
}
