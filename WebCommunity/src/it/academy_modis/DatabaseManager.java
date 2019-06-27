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
	
	public void printListaUtenti(ArrayList<Utente> listaUtenti) {
		for(Utente u: listaUtenti) {
			System.out.println(u.getNickname() + " | " + u.getName() + " " + u.getSurname());
		}
	}
	
	public void printListaEventi(ArrayList<Evento> listaEventi) {
		for(Evento e: listaEventi) {
			String[] data = e.getData().split(" ");
			String[] formatted = data[0].split("-");
			String prettyData = formatted[2] + "/" + formatted[1] + "/" + formatted[0];
			
			System.out.println("L'evento " + e.getNome() + " si terrà a " + e.getLuogo() + 
					" il " +prettyData);
		}
	}
	
	public void printListaCategorie(ArrayList<Categoria> listaCategorie) {
		int i = 1;
		for(Categoria c: listaCategorie) {
			System.out.println(i + ") " + c.getNome());
			i++;
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
	
	public int insertEvento(int id_categoria, String nome, String luogo, String provincia, String data) {
		// TODO controllare i nomi dei parametri
		int num = 0;
		
		String query = "insert into sys.evento "
				+ "values ((select max(id_evento) "
				+ "from sys.evento) + 1, ?, ?, ?, ?, to_date(?, 'DD/MM/YYYY'))";
		
		PreparedStatement stm;
		try { 
			stm = this.connection.prepareStatement(query);
			stm.setInt(1, id_categoria);
			stm.setString(2, nome);
			stm.setString(3, luogo);	
			stm.setString(4, provincia);
			stm.setString(5, data);
			
			stm.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}
	
	public int insertCommento(String testo, int voto, int id_utente, int id_evento) {
		
		int num = 0;
		
		String query = "insert into sys.commenti "
				+ "values ((select max(id_commento) "
				+ "from sys.commenti) + 1, ?, ?, ?, ?)";
		
		PreparedStatement stm;
		try {
			stm = this.connection.prepareStatement(query);
			stm.setString(1, testo);
			stm.setInt(2, voto);
			stm.setInt(3, id_utente);
			stm.setInt(4, id_evento);
			
			stm.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}
	
	public int getIDUtente(String nickname, String password) {
		
		int id_utente = 0;
		
		String query = "select id_utente "
				+ "from sys.utente "
				+ "where nickname = ? "
				+ "and password = ?";
		
		PreparedStatement stm;
		try {
			stm = this.connection.prepareStatement(query);
			stm.setString(1, nickname);
			stm.setString(2, password);
			
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()) {
				id_utente = rs.getInt("id_utente");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id_utente;
	}
	
	public void getRecensione(int id_evento) {
		
		String query = "select testo, voto, id_utente\r\n" + 
						"from sys.commenti\r\n" + 
						"where id_evento = ?";
		
		PreparedStatement stm;
		try {
			stm = this.connection.prepareStatement(query);
			stm.setInt(1, id_evento);
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()) {
				String nick = getNickUtente(rs.getInt("id_utente"));
				System.out.println("Post dell'utente " + nick 
				+ "\nRecensione: " + rs.getString("testo") + "\nVoto: " + rs.getInt("voto"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private String getNickUtente(int id_utente) {
		
		String nick = "";
		
		String query = "select u.nickname\r\n" + 
						"from sys.utente u\r\n" + 
						"inner join sys.commenti c\r\n" + 
						"on u.id_utente = ?";
		
		PreparedStatement stm;
		try {
			stm = this.connection.prepareStatement(query);
			stm.setInt(1, id_utente);
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()) {
				nick = rs.getString("nickname");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nick;
	}
	
	public ArrayList<Categoria> getCategorie() {
		
		ArrayList<Categoria> listaCategorie = new ArrayList<Categoria>();
		
		String query = "select *"
					+ "from sys.categoria";
		PreparedStatement stm;
		try {
			stm = this.connection.prepareStatement(query);
			
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()) {
				listaCategorie.add(
						new Categoria(rs.getString("nome"))
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaCategorie;
	}
	
	public ArrayList<Evento> getEventiOrdinati() {
		
		ArrayList<Evento> listaEventi = new ArrayList<Evento>();
		
		String query = "select * "
				+ "from sys.evento "
				+ "order by data";
		
		PreparedStatement stm = null;
		
		try {
			stm = this.connection.prepareStatement(query);
			
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()) {
				listaEventi.add(
						new Evento(
								rs.getInt("id_categoria"),
								rs.getString("nome"),
								rs.getString("luogo"),
								rs.getString("provincia"),
								rs.getString("data")
								)
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaEventi;
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
