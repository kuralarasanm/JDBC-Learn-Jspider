package org.jsp.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class CreateStudentTable {
	public static void main(String[] args) {
		Connection con = null;
		java.sql.Statement st = null;
		String qry = "create table Student(" + "id int not null," + "name varchar(45)not null," + "age int not null,"
				+ "phone bigint(20)unique not null," + "perc decimal not null," + "primary key(id))";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_demo?user=root&password=admin");
			st = con.createStatement();
			boolean res = st.execute(qry);
			System.out.println("student table created");
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
