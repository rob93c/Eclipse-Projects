package it.testSpring.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UtenteDao {

	private DatabaseManager dbm;

	public List<UtenteVo> getAllUsers() {

		List<UtenteVo> listaUtenti = new ArrayList<UtenteVo>();

		String query = "select * " + "from sys.utente";

		PreparedStatement stm;

		try {
			stm = dbm.startConnection().prepareStatement(query);
			ResultSet rs = stm.executeQuery();

			while (rs.next()) {
				listaUtenti.add(new UtenteVo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return listaUtenti;
	}

	public UtenteVo getUtenteByPK(int id) {

		String query = "select * " + "from sys.utente " + "where id_utente = ?";

		UtenteVo utente = null;
		PreparedStatement stm;
		try {
			stm = dbm.startConnection().prepareStatement(query);
			stm.setInt(1, id);

			ResultSet rs = stm.executeQuery();

			if (rs.next()) {
				utente = new UtenteVo(rs.getInt(1), rs.getString(2), rs.getString(3), 
						rs.getString(4), rs.getString(5), rs.getString(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return utente;
	}

	public void setDbm(DatabaseManager database) {
		this.dbm = database;
	}
}
