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
import java.util.UUID;

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

// -------------------------------------------------------------------------------------
	
	public void registrazioneUtente(String nome, String cognome, String patente, 
			String scadenzaPatente, String datiAuto, String telefono, String mail) {
		
		String query = "insert into sys.utente_autista\r\n" + 
				"values ((select max(id_autista) \r\n" + 
				"from sys.utente_autista) + 1, ?, ?, ?, "
				+ "to_date(?, 'DD/MM/YYYY'), ?, ?, ?, null)";
		
		PreparedStatement stm;
		try {
			stm = this.connection.prepareStatement(query);
			stm.setString(1, nome);
			stm.setString(2, cognome);
			stm.setString(3, patente);
			stm.setString(4, scadenzaPatente);
			stm.setString(5, datiAuto);
			stm.setString(6, telefono);
			stm.setString(7, mail);
			
			stm.executeUpdate(); 
			System.out.println("\nRegistrazione avvenuta con successo!\n");
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
// -------------------------------------------------------------------------------------
	
	public void registrazioneUtente(String nome, String cognome, String documento,
							String telefono, String mail) {
		
		String query = "insert into sys.utente_passeggero\r\n" + 
				"values ((select max(id_passeggero) \r\n" + 
				"from sys.utente_passeggero) + 1, ?, ?, ?, ?, ?)";
		
		PreparedStatement stm;
		try {
			stm = this.connection.prepareStatement(query);
			stm.setString(1, nome);
			stm.setString(2, cognome);
			stm.setString(3, documento);
			stm.setString(4, telefono);
			stm.setString(5, mail);
			
			stm.executeUpdate(); 
			System.out.println("\nRegistrazione avvenuta con successo!\n");
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

// -------------------------------------------------------------------------------------
	
	public ArrayList<Viaggio> getViaggi(String partenza, String arrivo, String data) {
		
		ArrayList<Viaggio> listaViaggi = new ArrayList<Viaggio>();
		
		String query = "select * "
				+ "from sys.viaggio "
				+ "where prenotazione = 0 "
				+ "and partenza = ? "
				+ "and arrivo = ? "
				+ "and data = to_date(?, 'DD/MM/YYYY') "
				+ "order by data, ora";
		
		PreparedStatement stm = null;
		try {
			stm = this.connection.prepareStatement(query);
			stm.setString(1, partenza);
			stm.setString(2, arrivo);
			stm.setString(3, data);
			
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()) {
				listaViaggi.add(new Viaggio(rs.getInt(1), rs.getInt(2), rs.getString(3), 
						rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), 
						rs.getInt(8), rs.getInt(9), rs.getInt(10), rs.getInt(11), rs.getInt(12)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaViaggi;
	}
	
// -------------------------------------------------------------------------------------

	public void printViaggio(ArrayList<Viaggio> listaViaggi) {
		for(Viaggio v: listaViaggi) {
			System.out.println("Viaggio da " + v.getPartenza() + " a " + v.getArrivo());
		}
	}
	
// -------------------------------------------------------------------------------------
	
	public ArrayList<UtenteAutista> getAutistaFromViaggio(ArrayList<Viaggio> listaViaggi) {
		
		ArrayList<UtenteAutista> listaAutisti = new ArrayList<UtenteAutista>();
		
		for(Viaggio v: listaViaggi) {
			String query = "select * from sys.utente_autista where id_autista = " + v.getId_autista();
			
			PreparedStatement stm;
			try {
				stm = this.connection.prepareStatement(query);
				
				ResultSet rs = stm.executeQuery();
				
				while(rs.next()) {
					listaAutisti.add(new UtenteAutista(rs.getInt(1), rs.getString(2),
							rs.getString(3), rs.getString(4), 
							rs.getString(5), rs.getString(6),
							rs.getString(7), rs.getString(8)));
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return listaAutisti;
	}
	
// -------------------------------------------------------------------------------------
	
	public String prenota(String mail, int id_viaggio) {
		
		int id_passeggero = recuperaPasseggeroFromMail(mail);
		String uuid = UUID.randomUUID().toString();
		
		String query = "insert into sys.prenotazione "
				+ "values (?, ?, ?)";
		
		PreparedStatement stm;
		try {
			stm = this.connection.prepareStatement(query);
			stm.setString(1, uuid);
			stm.setInt(2, id_passeggero);
			stm.setInt(3, id_viaggio);
			
			stm.executeUpdate();
			
			System.out.println("Prenotazione " + uuid + " aggiunta con successo.");
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return uuid;
	}
	
// -------------------------------------------------------------------------------------

	public Viaggio getViaggio(String id_prenotazione) {
		
		String query = "select *\r\n" + 
				"from sys.viaggio v\r\n" + 
				"inner join sys.prenotazione p\r\n" + 
				"on p.id_prenotazione = ?\r\n" + 
				"and v.id_viaggio = p.id_viaggio";
		
		Viaggio viaggio = null;
		PreparedStatement stm;
		try {
			stm = this.connection.prepareStatement(query);
			stm.setString(1, id_prenotazione);
			
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()) {
				viaggio = new Viaggio(rs.getInt(1), rs.getInt(2), 
						rs.getString(3), rs.getString(4), 
						rs.getString(5), rs.getString(6), 
						rs.getInt(7), rs.getInt(8), 
						rs.getInt(9), rs.getInt(10), 
						rs.getInt(11), rs.getInt(12));
				
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return viaggio;
	}
	
// -------------------------------------------------------------------------------------
	
	private int recuperaPasseggeroFromMail(String mail) {
		
		int id = 0;
		
		String query = "select id_passeggero "
				+ "from sys.utente_passeggero "
				+ "where mail = ?";
		
		PreparedStatement stm;
		try {
			stm = this.connection.prepareStatement(query);
			stm.setString(1, mail);
			
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()) {
				id = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}
	
// -------------------------------------------------------------------------------------
	
	private int recuperaAutistaFromMail(String mail) {
		
		int id = 0;
		
		String query = "select id_autista "
				+ "from sys.utente_autista "
				+ "where mail = ?";
		
		PreparedStatement stm;
		try {
			stm = this.connection.prepareStatement(query);
			stm.setString(1, mail);
			
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()) {
				id = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}
		
// -------------------------------------------------------------------------------------

	public void getPasseggeri(String mail, int id_viaggio, double voto) {
		
		int id_autista = recuperaAutistaFromMail(mail);
		
		String query = "SELECT P.NOME, P.COGNOME, AVG(F.VOTO) "
				+ "FROM SYS.UTENTE_PASSEGGERO P \r\n" 
				+ "INNER JOIN SYS.VIAGGIO V \r\n" 
				+ "ON V.ID_AUTISTA = ? \r\n" 
				+ "INNER JOIN SYS.FEEDBACK_AUTISTA F \r\n" 
				+ "ON F.ID_PASSEGGERO = P.ID_PASSEGGERO "
				+ "INNER JOIN SYS.PRENOTAZIONE Z \r\n" 
				+ "ON Z.ID_PASSEGGERO = P.ID_PASSEGGERO \r\n" 
				+ "AND Z.ID_VIAGGIO = ? \r\n" 
				+ "GROUP BY P.NOME, P.COGNOME";
		
		PreparedStatement stm;
		try {
			stm = this.connection.prepareStatement(query);
			stm.setInt(1, id_autista);
			stm.setInt(2, id_viaggio);
			
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()) {
				if(rs.getDouble(3) > voto) {
					UtentePasseggero p = new UtentePasseggero(rs.getString(1), rs.getString(2));
					p.printPasseggero();
					System.out.println("La media delle valutazioni è " + rs.getDouble(3));
				}
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
// -------------------------------------------------------------------------------------

	public void closeConnection() {
		
		try {
			this.connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
//-------------------------------------------------------------------------------------

}
