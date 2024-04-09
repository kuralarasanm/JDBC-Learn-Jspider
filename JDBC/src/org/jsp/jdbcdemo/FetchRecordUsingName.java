package org.jsp.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class FetchRecordUsingName {
	public static void main(String[] args) {
		String query="select * from Student where name=?";
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		Scanner input=new Scanner(System.in);
		System.out.println("enter the name");
		String name=input.next();
		try {
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_demo?user=root&password=admin");
		pst=con.prepareStatement(query);
		pst.setString(1, name);
		rs=pst.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getInt("id"));
			System.out.println(rs.getString("name"));
			System.out.println(rs.getInt("age"));
			System.out.println(rs.getDouble("perc"));
			System.out.println(rs.getLong("phone"));
			System.out.println("--------------------------------------");
		}
		}catch(SQLException e) {
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
			if (pst != null) {
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
