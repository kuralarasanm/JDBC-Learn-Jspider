package org.jsp.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FetchStudents {
	public static void main(String[] args) {
		String dql="select * from student";
		String dml="insert into student values(5,'kural',23,93883378,80.0)";
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_demo?user=root&password=admin");
			st = con.createStatement();
			System.out.println(st.execute(dml));
			System.out.println(st.getResultSet());
			
			System.out.println(st.execute(dql));
			System.out.println(st.getResultSet());
			
		}catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			if (con != null) {

				try {
					con.close();
					System.out.println("connected closed");
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
