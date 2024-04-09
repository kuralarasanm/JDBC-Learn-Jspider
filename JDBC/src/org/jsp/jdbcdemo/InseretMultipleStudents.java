package org.jsp.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InseretMultipleStudents {
	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_demo?user=root&password=admin");
			st = con.createStatement();
			st.execute("insert into student values(1,'ak',25,78824,45)");
			st.execute("insert into student values(2,'str',25,788467,75)");
			st.execute("insert into student values(3,'ss',25,78823243,85)");
			}
		catch (SQLException e) {
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
