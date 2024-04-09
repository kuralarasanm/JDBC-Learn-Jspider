package org.jsp.jdbc.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Createusertable {
public static void main(String[] args) {
		
		
		Connection con=null;
		Statement st=null;
//		String qr="create table product(id int not null,name varchar(10) not null,brand varchar(15) not null,category varchar(20) not null,description varchar(100),cost decimal not null,imageurl varchar(30),primary key(id))";
		String qr="create table user(id int(10)not null,"
				+ "name varchar(20)not null,"
				+ "phone bigint(10)not null unique,"
				+ "email varchar(30)not null,"
				+ "password varchar(20)not null)";
		Properties p=new Properties();
		FileInputStream fis=null;
		try {
			fis=new FileInputStream("C:/Users/Yogesh/OneDrive/Desktop/JDBC/jdbc.properties");
			p.load(fis);
			Class.forName(p.getProperty("Driverclass"));
			con=DriverManager.getConnection(p.getProperty("url"), p);
			st=con.createStatement();
			st.execute(qr);
			System.out.println("user table is created");
			
			
		} 
		catch (IOException |ClassNotFoundException |SQLException e)  {
			
			 e.printStackTrace();
		}
		
	}
}

