package it.academy_modis;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.jdbc.pool.OracleDataSource;
	
public class DatabaseManager {
	
	private Connection connection;
	
	// mettiamo i dati necessari a collegarsi al DB
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
	
	private void getImpiegatiBase(String[] where, String[] params, String orderBy) {
		
		String query = 	"SELECT * " + 
						"FROM SYS.IMPIEGATI " +
						"WHERE ID_IMPIEGATO > 0";
		
//		if(!where.isEmpty()) 
//			query += " AND " + where;
		
		for(int i = 0; i < where.length; i++) {
			query += " AND " + where[i] + " = ?";
		}
		
		if(!orderBy.isEmpty())
			query += " ORDER BY DS_COGNOME " + orderBy;
		
		PreparedStatement stm;
		try {
			stm = this.connection.prepareStatement(query);
			
			for(int i = 0; i < params.length; i++) {
				stm.setString(i + 1, params[i]);
			}
			
			ResultSet rs = stm.executeQuery(); 
			// rs contiene i record risultato della query
			
			while(rs.next()) {
				System.out.println(rs.getString("ds_cognome") + 
							 " " + rs.getString("ds_nome"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void getAllImpiegati(String orderBy) {
		
		getImpiegatiBase(new String[] {}, new String[] {}, orderBy);
			
	}
	
	public void getAllImpiegatiBySesso(String sesso, String orderBy) {
	
		getImpiegatiBase(new String[] {"CD_GENDER"}, new String[] {sesso}, "");

	}
	
	public void getAllImpiegatiByCF(String cf, String orderBy) {
		
		getImpiegatiBase(new String[] {"CD_FISCALE"}, new String[] {cf}, "");

	}
	
	public void getAllImpiegatiByNomeECognome(String nome, String cognome) {

		getImpiegatiBase(new String[] {"DS_NOME","DS_COGNOME"}, 
				new String[] {nome, cognome}, "");

	}
	
	
}
