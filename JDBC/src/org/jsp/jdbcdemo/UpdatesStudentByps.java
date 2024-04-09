package org.jsp.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdatesStudentByps {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the student id to update");
		int id = s.nextInt();
		System.out.println("Enter the student name,age,phone and percentage to update");
		String name = s.next();
		int age = s.nextInt();
		long phone = s.nextLong();
		double perc = s.nextDouble();
		String qry = "update student set name=?,age=?,phone=?,perc=? where id=?";
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_demo?user=root&password=admin");
			pst = con.prepareStatement(qry);
			pst.setString(1, name);
			pst.setInt(2, age);
			pst.setLong(3, phone);
			pst.setDouble(4, perc);
			pst.setInt(5, id);
			int r = pst.executeUpdate();
			System.out.println(r + "row updated");
		} catch (SQLException e) {
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
			if (pst != null) {
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
