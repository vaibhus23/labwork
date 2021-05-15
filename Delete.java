package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Delete {

  public static void main(String[] args) {
    String jdbcUrl = "jdbc:oracle:thin:@localhost:1521/XE";
    String username = "vaibhus";
    String password = "vaibhu";
    String sql = "delete from employee where empno=3";

    try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password); 
        Statement stmt = conn.createStatement();) {
      
      stmt.executeUpdate(sql);
      System.out.println("Record deleted successfully");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}