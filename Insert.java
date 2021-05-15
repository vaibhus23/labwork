package jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;

public class Insert {

	public static void main(String[] args) {
		insertEmployee(5, "Vaibhav", "CEO", 1, LocalDate.of(2010, Month.JUNE, 16), 21000, 2564, 23);

	}

	private static void insertEmployee(int empno, String ename, String job, int mgr, LocalDate hiredate, double salary,
			double comm, int deptNo) {

		Connection conn = null;
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE", "vaibhus", "vaibhu");

			String sql = "insert into employee values(?,?,?,?,?,?,?,?)";

			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, empno);
			pstmt.setString(2, ename);
			pstmt.setString(3, job);
			pstmt.setInt(4, mgr);
			pstmt.setDate(5, Date.valueOf(hiredate));
			pstmt.setDouble(6, salary);
			pstmt.setDouble(7, comm);
			pstmt.setInt(8, deptNo);

			int count = pstmt.executeUpdate();

			System.out.println("Record is inserted successfully " + count);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}
}
