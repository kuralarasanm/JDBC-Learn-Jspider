package org.jsp.jdbc.properties;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Readproperties {
	public static void main(String[] args) {
		FileInputStream fin=null;
		Properties p=new Properties();
		try {
		fin=new FileInputStream("C:\\Users\\Yogesh\\OneDrive\\Desktop\\JDBC\\jdbc.properties");
		p.load(fin);
		System.out.println(p.getProperty("url"));
		System.out.println(p.getProperty("Driverclass"));
		System.out.println(p.getProperty("user"));
		System.out.println(p.getProperty("password"));
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fin.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
}
