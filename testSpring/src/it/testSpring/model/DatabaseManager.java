package it.testSpring.model;

import java.sql.Connection;
import java.sql.SQLException;

import oracle.jdbc.pool.OracleDataSource;

public class DatabaseManager {

	private Connection connection;
	
	public Connection startConnection() {
		
		OracleDataSource dataSource;
		try {
			dataSource = new OracleDataSource();
			dataSource.setURL("jdbc:oracle:thin:@localhost:1521/xe");
			dataSource.setDatabaseName("XE");
			dataSource.setUser("SYSTEM");
			dataSource.setPassword("password");
			
			this.connection = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Connessione non funzionante.");
		}
		return this.connection;
	}
	
	public Connection getConnection() {
		return this.connection;
	}
}

