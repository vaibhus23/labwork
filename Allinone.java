package jdbc;

import java.sql.*;
import java.time.LocalDate;

public class Allinone
{
	private Connection connect()
	{
		Connection conn = null;
		try 
		{
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521/XE","vaibhus","vaibhu");
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return conn;
	}
	
	void insertValues(int empno,String ename, String job, int mgr,LocalDate hireDate, 
			int sal, int comm, int deptno)
	{
		String sql = "insert into employee(empno,ename,job,mgr,hiredate,sal,comm,deptno)"
				+ " values(?,?,?,?,?,?,?,?)";
		
		try (Connection conn = this.connect();
            PreparedStatement stmt = conn.prepareStatement(sql)) 
		{
			stmt.setInt(1,empno);
			stmt.setString(2, ename);
			stmt.setString(3, job);
			stmt.setInt(4, mgr);
			stmt.setDate(5, Date.valueOf(hireDate));
			stmt.setInt(6,sal);
			stmt.setInt(7,comm);
			stmt.setInt(8,deptno);
			
			int count1 = stmt.executeUpdate();
			System.out.println("Rows added: " + count1);
        } 
		catch (SQLException e) 
		{
            System.out.println(e.getMessage());
        }
	}

	void deleteRecord(int empno)
	{
		String sql = "delete from employee where empno > ?";	
		 try (Connection conn = this.connect();
	                PreparedStatement del = conn.prepareStatement(sql))
		 {
			 	
				del.setInt(1, empno);
				int count2 = del.executeUpdate();
				System.out.println("Rows Deleted: " + count2);
	     } 
		 catch (SQLException e)
		 {
	            System.out.println(e.getMessage());
	     }
	}
	
	public static void main(String[] args)
	{
		Allinone all = new Allinone();
		all.insertValues(3, "FL3X", "Covert", 1147, LocalDate.of(2020, 04, 11),
				30000, 1147, 23);
		//all.deleteRecord(3);
	}
}
