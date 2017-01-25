package edu.ap.jdbc;

import java.sql.*;
import java.util.ArrayList;

public class JDBConnection {
	
	private static JDBConnection instance = null;
	private Connection conn = null;
	
	private JDBConnection() {}
	
	public void openConnection(String database, String user, String pwd) {        
		try {
			Class.forName("com.mysql.jdbc.Driver");
		    String url = "jdbc:mysql://127.0.0.1/" + database;
		    conn = DriverManager.getConnection (url, user, pwd);
		}
		catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}
	
	public void closeConnection() {
		
		if (conn != null) {
			try {
				conn.close();
		     }
		     catch (SQLException ex) {
		    	 System.out.println("Error: " + ex);
		     }
		}
	}

	public static synchronized JDBConnection getJDBConnection() {
	
		if(instance == null) {
            instance = new JDBConnection();
        }
        return instance;
	}

	public void executeInsert(String table, String date, String name; String dateOfBirth, String doctorName, String diagnosis) {
		
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("INSERT INTO " + table + " VALUES('" + date + "','" + name + "','" + dateOfBirth + "','" + 
			doctorName + "','" + diagnosis + ")");
			stmt.close();
		}
		catch(SQLException ex) {
			System.out.println("Error: " + ex);
		}
	}

	public String selectName(String lastName){
		
		ResultSet rs = null;
		String result = "";
		try {
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM STUDENT WHERE LASTNAME='" + lastName + "'");
			if(rs.next()){
				result = rs.getString(1) + " " + rs.getString(2) + " " + rs.getInt(3);
			}
			stmt.close();
		}
		catch(SQLException ex) {
			System.out.println("Error: " + ex);
		}
		
		return result;
	}
	
	public ArrayList<String> selectAll() {
		
		ResultSet rs = null;
		ArrayList<String> result = new ArrayList<String>();
		try {
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM STUDENTS ORDER BY LASTNAME DESC");
			while(rs.next()) {
				result.add(rs.getString(1) + ";" + rs.getString(2) + ";" + rs.getInt(3));
			}
			stmt.close();
		}
		catch(SQLException ex) {
			System.out.println("Error: " + ex);
		}
		
		return result;
	}
}
