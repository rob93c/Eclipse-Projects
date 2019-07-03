package it.corsoWebapp.servlet;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;

import oracle.jdbc.pool.OracleDataSource;

public class ServiceLoaderServlet extends HttpServlet {

	private static final long serialVersionUID = 9172531409816773387L;
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
			
		//	System.out.println("Connessione valida.");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Connessione non funzionante.");
		}
		return this.connection;
	}
}
