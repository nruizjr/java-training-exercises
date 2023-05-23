package com.java_training.exercises.exercise5;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.ibatis.jdbc.ScriptRunner;

public class DatabaseConnectionManager {
	private static final String url = "jdbc:postgresql://localhost/grocery_items";
	private static final String user = "postgres";
	private static final String password = "1234";	
    private static final String tableName = "groceries";
	
	
	public Connection connect() {
	    Connection conn = null;
	    try {
	        conn = DriverManager.getConnection(url, user, password);	
	    } catch (SQLException e) {
	    	// Database does not exist
	    	System.err.println("Error connecting to the database: " + e.getMessage());
	    }	    
	
	    return conn;
	}
	
	public boolean initializeDatabase(Connection conn) {
		boolean flag = true;
		
		try {
			DatabaseMetaData metadata = conn.getMetaData();
            ResultSet resultSet = metadata.getTables(null, null, tableName, null);
            
            if (!resultSet.next()) {
            	System.out.println("Table '" + tableName + "' does not exist. Creating it...");

                ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        		InputStream inputStream = classloader.getResourceAsStream("schema.sql");
        		InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        		BufferedReader reader = new BufferedReader(streamReader);
        		
        		ScriptRunner sr = new ScriptRunner(conn);
        		//Running the script to initialize the DB
        		sr.runScript(reader);
            }
		} catch (SQLException e) {
			flag = false;
            e.printStackTrace();
        }
		
		return flag;
	}
}
