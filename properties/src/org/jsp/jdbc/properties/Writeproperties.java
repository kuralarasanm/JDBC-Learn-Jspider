package org.jsp.jdbc.properties;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Writeproperties {
	public static void main(String[] args) {
		Properties p=new Properties();
		p.setProperty("Driverclass","com.mysql.cj.jdbc.Driver");
		p.setProperty("url","jdbc:mysql://localhost:3306/jdbc_demo");
		p.setProperty("user", "root");
		p.setProperty("password", "admin");
		FileOutputStream fout=null;
		try {
		fout=new FileOutputStream("C:/Users/Yogesh/OneDrive/Desktop/JDBC/jdbc.properties");
		p.store(fout, "adding the properties for jdbc");
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			if(fout!=null) {
			try {
				fout.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}}
