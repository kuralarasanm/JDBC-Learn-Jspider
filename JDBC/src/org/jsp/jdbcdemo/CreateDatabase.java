package org.jsp.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class CreateDatabase {

	public static void main(String[] args) {
		String query = "create database jdbc_demo";
		Connection con = null;
		java.sql.Statement st = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?", "root", "admin");
			st = con.createStatement();
			boolean res = st.execute(query);
			System.out.println("database created");
			System.out.println(res);
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
