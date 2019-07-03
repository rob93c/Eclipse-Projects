package it.corsoWebapp.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import it.corsoWebapp.servlet.ServiceLoaderServlet;

public class UtenteDao {
	
	public List<UtenteVo> getAllUsers() {
		
		List<UtenteVo> listaUtenti = new ArrayList<UtenteVo>();
		ServiceLoaderServlet sls = new ServiceLoaderServlet();
		
		String query = "select * "
					+ "from sys.utente";
		
		PreparedStatement stm;
		
		try {
			stm = sls.startConnection().prepareStatement(query);
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()) {
				listaUtenti.add(new UtenteVo(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return listaUtenti;
	}
}
