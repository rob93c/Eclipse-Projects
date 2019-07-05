package it.testSpring.model;

import java.sql.Connection;
import java.sql.SQLException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import oracle.jdbc.pool.OracleDataSource;

@Service(value="databaseManager")
@Scope(value="singleton")
public class DatabaseManager {
	
	private Connection connection;
	
	public Connection getConnection() {
		return this.connection;
	}
	
	@PostConstruct
	public void init() {
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
	}
	
	@PreDestroy
	public void destroy() {
		try {
			this.connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

