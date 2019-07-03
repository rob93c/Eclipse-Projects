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

import it.academy_modis.model.Impiegato;
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
	
	public void printLista(ArrayList<Impiegato> listaImpiegati) {
		for(Impiegato i: listaImpiegati) {
			System.out.println(i.getNome() + " " + i.getCognome());
		}
	}
	
	public ArrayList<Impiegato> getImpiegatiBySalDesc() {
		
		ArrayList<Impiegato> listaImpiegati = new ArrayList<Impiegato>();
		
		String query = "select *\r\n" + 
						"from SYS.impiegati i\r\n" + 
						"inner join SYS.salari s\r\n" + 
						"on i.id_impiegato = s.id_impiegato\r\n" + 
						"order by s.NR_QTA_SALARIO desc";
		
		PreparedStatement stm = null;
		
		try {
			stm = this.connection.prepareStatement(query);
			
			ResultSet rs = stm.executeQuery(); 
			// rs contiene i record risultato della query
			
			while(rs.next()) {
				listaImpiegati.add(
						new Impiegato(rs.getString("DS_NOME"), 
									rs.getString("DS_COGNOME"), 
									rs.getInt("ID_IMPIEGATO_SUPERIORE")));
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
		
		return listaImpiegati;
		
	}
	
	public ArrayList<Impiegato> getAllImpiegatiDiplomati() {
		
		return getImpiegatiByTitolo("DIPLOMA%");
		
	}
	
	public ArrayList<Impiegato> getAllImpiegatiLaureati() {
		
		return getImpiegatiByTitolo("LAUREA%");
		
	}
	
	public void getResponsabile(String descrizione) {
		
		String query = "select i.ds_nome, i.ds_cognome\r\n" + 
						"from sys.impiegati i\r\n" + 
						"inner join sys.responsabili_dipartimenti r\r\n" + 
						"on i.id_impiegato = r.id_impiegato\r\n" + 
						"inner join sys.dipartimenti d\r\n" + 
						"on d.id_dipartimento = r.id_dipartimento\r\n" + 
						"and d.ds_dipartimento = ?";
		
		PreparedStatement stm;
		try {
			stm = this.connection.prepareStatement(query);
			stm.setString(1, descrizione);
			
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getString("ds_nome") + " " + rs.getString("ds_cognome")
				+ " è il responsabile del " + descrizione.toLowerCase() + ".");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	private ArrayList<Impiegato> getImpiegatiByTitolo(String titolo) {
		
		ArrayList<Impiegato> listaImpiegati = new ArrayList<Impiegato>();
		
		String query = "select *\r\n" + 
						"from sys.impiegati i\r\n" + 
						"inner join sys.titoli t\r\n" + 
						"on i.id_impiegato = t.id_impiegato\r\n" + 
						"and t.ds_titolo like '" + titolo + "'";
		
		PreparedStatement stm;
		
		try {
			stm = this.connection.prepareStatement(query);
			
			ResultSet rs = stm.executeQuery(); 
			// rs contiene i record risultato della query
			
			while(rs.next()) {
				listaImpiegati.add(
						new Impiegato(rs.getString("DS_NOME"), 
									rs.getString("DS_COGNOME"), 
									rs.getInt("ID_IMPIEGATO_SUPERIORE")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listaImpiegati;
		
	}
	
	public int insertDipartimento(String descrizione) {
		
		int nuovoIndice = 0;
		
		String query = "insert into sys.dipartimenti\r\n" + 
						"values ((select max(to_number(id_dipartimento)) "
						+ "from sys.dipartimenti) + 1, ?)";

		PreparedStatement stm;
		try {
			stm = this.connection.prepareStatement(query);
			stm.setString(1, descrizione);
			
			stm.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nuovoIndice;
	}
	
	public void addImpiegatoToDipartimento(String id_dip, String id_imp) {
		
		try {
			String query = "insert into sys.impiegati_dipartimenti\r\n" + 
					"values ('" + id_dip + "', '" + id_imp + "', sysdate, null)";
			
			// 2. Creazione dello Statement sulla connessione attiva
			PreparedStatement stm = connection.prepareStatement(query);
			
			stm.executeUpdate();
			
			ResultSet rs = stm.getGeneratedKeys();
			
			while(rs.next()) {
				System.out.println("\nIl dipendente è stato aggiunto al dipartimento con successo.\n");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void deleteImpiegatoFromDipartimento(String id_dip, String id_imp) {
		
		try {
			String query = "delete from sys.impiegati_dipartimenti\r\n" + 
							"where id_dipartimento = '" + id_dip + "', "
							+ "and id_impiegato = '" + id_imp + "')";
			
			PreparedStatement stm = connection.prepareStatement(query);
			
			stm.executeUpdate();
			
			System.out.println("\nIl dipendente è stato elimminato dal dipartimento con successo.\n");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public String isImpiegato(String cognome) {
		
		String ide = null;
		String query = "select id_impiegato\r\n" + 
						"from sys.impiegati\r\n" + 
						"where ds_cognome = ?";
		
		PreparedStatement stm;
		try {
			stm = this.connection.prepareStatement(query);
			stm.setString(1, cognome);
			
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()) {
				ide = rs.getString("id_impiegato");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ide;
	}
	
	public String isDipartimento(String descrizione) {
		
		String ds = null;
		String query = "select id_dipartimento\r\n" + 
						"from sys.dipartimenti\r\n" + 
						"where ds_dipartimento = ?";
		
		PreparedStatement stm;
		try {
			stm = this.connection.prepareStatement(query);
			stm.setString(1, descrizione);
			
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()) {
				ds = rs.getString("id_dipartimento");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ds;
	}
	
	public void updateSalario(int salario, String id) {
		
		try {
			String query = "update sys.salari s\r\n" + 
							"set s.NR_QTA_SALARIO = " + salario + "\r\n" + 
							"where s.id_impiegato = '" + id + "'";
			
			PreparedStatement stm = connection.prepareStatement(query);
			
			stm.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void closeConnection() {
		
		try {
			this.connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}