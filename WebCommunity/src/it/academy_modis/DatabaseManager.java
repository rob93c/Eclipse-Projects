package it.academy_modis;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import oracle.jdbc.pool.OracleDataSource;

public class DatabaseManager {
	
	private Connection connection;
	private static final String DB_PROPERTIES = "db.properties";
	
	// dati necessari a collegarsi al DB
	public DatabaseManager() {

		OracleDataSource dataSource;
		try {
			
			Properties properties = new Properties();
			File dbFileProperties = new File(DB_PROPERTIES);
			InputStream is = new FileInputStream(dbFileProperties);
			
			properties.load(is);
			
			dataSource = new OracleDataSource();
			
			String dbhost = properties.getProperty("dbhost");
			String dbname = properties.getProperty("dbname");
			String dbuser = properties.getProperty("dbuser");
			String dbpass = properties.getProperty("dbpass");
			
			// jdbc:oracle
			dataSource.setURL(dbhost);
			dataSource.setDatabaseName(dbname);
			dataSource.setUser(dbuser);
			dataSource.setPassword(dbpass);
			
			this.connection = dataSource.getConnection();
			
		//	System.out.println("Connessione valida.");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Connessione non funzionante.");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void printLista(ArrayList<Utente> listaUtenti) {
		for(Utente u: listaUtenti) {
			System.out.println(u.getNickname() + " | " + u.getName() + " " + u.getSurname());
		}
	}
	
	public int insertUtente(String nickname, String name, String surname, 
												String mail, String password) {
		
		int nuovoIndice = 0;
		
		String query = "insert into sys.utente \r\n" + 
				"values ((select max(id_utente)\r\n" + 
				"from sys.utente) + 1, ?, ?, ?, ?, ?)";

		PreparedStatement stm;
		try {
			stm = this.connection.prepareStatement(query);
			stm.setString(1, nickname);
			stm.setString(2, name);
			stm.setString(3, surname);
			stm.setString(4, mail);
			stm.setString(5, password);
			
			stm.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nuovoIndice;
	}
	
	public ArrayList<Utente> getAllUtenti() {
		
		ArrayList<Utente> listaUtenti = new ArrayList<Utente>();
		
		String query = "select *"
					+ "from sys.utente";
		
		PreparedStatement stm = null;
		
		try {
			stm = this.connection.prepareStatement(query);
			
			ResultSet rs = stm.executeQuery(); 
			// rs contiene i record risultato della query
			
			while(rs.next()) {
				listaUtenti.add(
						new Utente(
									rs.getString("nickname"),
									rs.getString("nome"), 
									rs.getString("cognome"), 
									rs.getString("mail"),
									rs.getString("password")
									)
						);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stm.close();
				this.connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return listaUtenti;
		
	}
	
	public void closeConnection() {
		
		try {
			this.connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean login(String nickname, String password) {
		
		boolean logged = false;
		
		String query = "select nickname, password\r\n" + 
						"from sys.utente";
		
		PreparedStatement stm;
		
		try {
			stm = this.connection.prepareStatement(query);
			
			ResultSet rs = stm.executeQuery(); 
			// rs contiene i record risultato della query
			
			while(rs.next()) {
				if(rs.getString("nickname").equals(nickname) &
						rs.getString("password").equals(password))
					logged = true;
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return logged;
	}
	
	
	
}
