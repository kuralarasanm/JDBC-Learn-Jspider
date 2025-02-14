package org.jsp.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.protocol.Resultset;

public class FetchRecord {
	public static void main(String[] args) {
		String Query="select * from student where id=?";
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		Scanner input=new Scanner(System.in);
		System.out.println("enter the employee id");
		int id=input.nextInt();
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_demo?user=root&password=admin");
			pst=con.prepareStatement(Query);
			pst.setInt(1, id);
			rs=pst.executeQuery();
			if(rs.next()) {
				System.out.println(rs.getInt("id"));
				System.out.println(rs.getString("name"));
				System.out.println(rs.getInt("age"));
				System.out.println(rs.getDouble("perc"));
				System.out.println(rs.getLong("phone"));
			}
			else {
				System.out.println("invalid id");
			}
		}
		catch(SQLException e) {
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
		}
	}
}
