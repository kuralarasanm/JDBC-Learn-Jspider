package org.jsp.olafactory;

public class Testloading {
    public static void main(String[] args) {
		System.out.println("main starts");
		demo.hello();
		System.out.println("main ends");
	}
    static {
    	System.out.println("test loading class is loaded into JVM Memory");
    }
}
