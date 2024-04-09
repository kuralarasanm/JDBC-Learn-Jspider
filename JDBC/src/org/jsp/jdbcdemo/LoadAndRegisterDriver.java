package org.jsp.jdbcdemo;

public class LoadAndRegisterDriver {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.driver");
			System.out.println("Driver class Loaded and Registered");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
