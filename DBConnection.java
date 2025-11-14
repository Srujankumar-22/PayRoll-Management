package com.payroll.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection {
private static final String URL = "jdbc:mysql://localhost:3306/payrolldb?useSSL=false&serverTimezone=UTC";
private static final String USER = "root"; // change if needed
private static final String PASS = "password"; // change if needed


static {
try {
Class.forName("com.mysql.cj.jdbc.Driver");
} catch (ClassNotFoundException e) {
System.err.println("MySQL JDBC driver not found. Add the driver to classpath.");
e.printStackTrace();
}
}


public static Connection getConnection() throws SQLException {
return DriverManager.getConnection(URL, USER, PASS);
}
}

