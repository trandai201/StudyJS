package temp;

import java.sql.Connection;
import java.sql.*;

public class Main {
	String temp;
	private static String DB_URL = "jdbc:sqlserver://localhost:1433;" + "databaseName=DanhBa;"
			+ "integratedSecurity=true";
	private static String USER_NAME = "sa";
	private static String PASSWORD = "12345";

	 public static Connection getConnection(){
	      Connection conn = null;
	        try {
	            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//	            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=demo;username:sa;password=12345");
	            String url = "jdbc:sqlserver://localhost:1433; databaseName= DanhBa";
	            String user = "sa";
	            String pass = "12345";
	            conn = DriverManager.getConnection(url, user, pass);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return conn;
	    }

	public static void main(String[] args) {
		System.out.println(getConnection());
	}
}
