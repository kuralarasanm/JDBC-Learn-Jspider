package org.jsp.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateStudent {
	public static void main(String[] args) {
		String sql="update student set name='xyz',perc=65.0 where id =1";
		Connection con=null;
		Statement st=null;
		
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_demo?user=root&password=admin");
				st = con.createStatement();
				int r = st.executeUpdate(sql);
				System.out.println(r+"rows updated");

			} catch (ClassNotFoundException | SQLException e) {
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
