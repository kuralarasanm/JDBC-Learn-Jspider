package org.jsp.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.cj.jdbc.Driver;

public class EstablishConnection {
	public static void main(String[] args) {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver class is loaded and registered");
//			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin"); OR
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?", "root", "admin");
			System.out.println("connection has been established");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.out.println("invalid credentials");
		} finally {
			if (con != null) {
				try {
					con.close();
					System.out.println("connection has been closed");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
