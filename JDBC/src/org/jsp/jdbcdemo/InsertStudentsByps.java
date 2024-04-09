package org.jsp.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertStudentsByps {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pst=null;
		String qry="insert into student values(?,?,?,?,?)";
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_demo?user=root&password=admin");
			pst=con.prepareStatement(qry);
			//insert 1st record
			pst.setInt(1,14);
			pst.setString(2, "abdev");
			pst.setInt(3, 35);
			pst.setLong(4, 13478L);
			pst.setDouble(5,86);
			pst.executeUpdate();
			//insert 2nd record
			pst.setInt(1,12);
			pst.setString(2, "rohit");
			pst.setInt(3, 35);
			pst.setLong(4, 123458L);
			pst.setDouble(5,86);
			pst.executeUpdate();
			//insert 3rd record
			pst.setInt(1,13);
			pst.setString(2, "dhoni");
			pst.setInt(3, 35);
			pst.setLong(4, 123678L);
			pst.setDouble(5,86);
			pst.executeUpdate();
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
