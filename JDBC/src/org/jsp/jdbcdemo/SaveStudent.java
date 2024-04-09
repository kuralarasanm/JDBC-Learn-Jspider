package org.jsp.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SaveStudent {
	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		String qrt = "insert into student values(2,'ak',25,38957,75.0)";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_demo?user=root&password=admin");
			st = con.createStatement();
			int r = st.executeUpdate(qrt);
			System.out.println(r+"rows inserted");

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
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
		}
	}
}
