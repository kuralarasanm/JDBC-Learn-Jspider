package org.jsp.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteStudentByps {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the Student ID to delete the record");
		int id=s.nextInt();
		String qry="delete from Student where id=?";
		Connection con=null;
		PreparedStatement pst=null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_demo?user=root&password=admin");
			pst = con.prepareStatement(qry);
			pst.setInt(1, id);
			int r=pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
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
