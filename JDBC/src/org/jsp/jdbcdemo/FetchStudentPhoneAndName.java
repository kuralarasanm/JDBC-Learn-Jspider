package org.jsp.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FetchStudentPhoneAndName {
	public static void main(String[] args) {
		String qry="select * from student";
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_demo?user=root&password=admin");
			st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			rs=st.executeQuery(qry);
			if(rs.absolute(1)) {
				System.out.println("Student id:"+rs.getInt(1));//rs.getInt("id")
				System.out.println("Student name:"+rs.getString(2));//rs.getString("name")
				System.out.println("age:"+rs.getInt(3));//rs.getInt("age")
				System.out.println("phone number:"+rs.getLong(4));//rs.getLong("phone");
				System.out.println("percentage:"+rs.getDouble(5));//rs.getDouble("perc");
				System.out.println("-------------------------------");
			}
			
		}
		catch (SQLException e) {
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
