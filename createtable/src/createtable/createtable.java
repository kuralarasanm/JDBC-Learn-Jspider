package createtable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class createtable {
	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		String Query="create table Students(id int not null,Name varchar(45) not null,Age int ,percent decimal(4),phone bigint(10) unique)";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_demo","root", "admin");
			st=con.createStatement();
			boolean res=st.execute(Query); 
			System.out.println("Table Created");
			System.out.println(res);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}