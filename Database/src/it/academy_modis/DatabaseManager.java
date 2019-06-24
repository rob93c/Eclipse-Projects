package it.academy_modis;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import oracle.jdbc.pool.OracleDataSource;

public class DatabaseManager {
	
	private Connection connection;
//	private ArrayList<Impiegati> listaImpiegati;
	
	// dati necessari a collegarsi al DB
	public DatabaseManager() {

		OracleDataSource dataSource;
		try {
			dataSource = new OracleDataSource();
			// jdbc:sqlite
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
	
	}
	
	public void printLista(ArrayList<Impiegati> listaImpiegati) {
		for(Impiegati i: listaImpiegati) {
			System.out.println(i.getNome() + " " + i.getCognome());
		}
	}
	
	public ArrayList<Impiegati> getImpiegatiBySalDesc() {
		
		ArrayList<Impiegati> listaImpiegati = new ArrayList<Impiegati>();
		
		String query = "select *\r\n" + 
						"from SYS.impiegati i\r\n" + 
						"inner join SYS.salari s\r\n" + 
						"on i.id_impiegato = s.id_impiegato\r\n" + 
						"order by s.NR_QTA_SALARIO desc";
		
		PreparedStatement stm;
		
		try {
			stm = this.connection.prepareStatement(query);
			
			ResultSet rs = stm.executeQuery(); 
			// rs contiene i record risultato della query
			
			while(rs.next()) {
				listaImpiegati.add(
						new Impiegati(rs.getString("DS_NOME"), 
									rs.getString("DS_COGNOME"), 
									rs.getInt("ID_IMPIEGATO_SUPERIORE")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listaImpiegati;
		
	}
	
	public ArrayList<Impiegati> getAllImpiegatiDiplomati() {
		
		return getImpiegatiByTitolo("DIPLOMA%");
		
	}
	
	public ArrayList<Impiegati> getAllImpiegatiLaureati() {
		
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

	private ArrayList<Impiegati> getImpiegatiByTitolo(String titolo) {
		
		ArrayList<Impiegati> listaImpiegati = new ArrayList<Impiegati>();
		
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
						new Impiegati(rs.getString("DS_NOME"), 
									rs.getString("DS_COGNOME"), 
									rs.getInt("ID_IMPIEGATO_SUPERIORE")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listaImpiegati;
		
	}
	
}
	
