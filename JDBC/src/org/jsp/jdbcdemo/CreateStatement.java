package org.jsp.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class CreateStatement {
	public static void main(String[] args) {
		Connection con = null;
		java.sql.Statement st = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?", "root", "admin");
			st = con.createStatement();
			System.out.println("platform created");
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
