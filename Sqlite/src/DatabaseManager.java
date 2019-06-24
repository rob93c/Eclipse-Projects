import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DatabaseManager {
	
	private String connectionString;
	
	public DatabaseManager(String connectionString) {
		this.connectionString = connectionString;
	}
	
	public ArrayList<Cliente> getAllClienti() throws SQLException {
		
//		String premium = "V";
//		String like = "%";
		ArrayList<Cliente> listaClienti = new ArrayList<Cliente>();
		
		// 1. Connessione
		Connection connection = DriverManager.getConnection(connectionString);
		
		String query = "select * from Cliente order by cognome, nome";
		
		// 2. Creazione dello Statement sulla connessione attiva
		PreparedStatement stm = connection.prepareStatement(query);
//			stm.setString(1, premium);
//			stm.setString(2, like);
		
		ResultSet rs = stm.executeQuery();
		
//			String nome = null;
		
		while(rs.next()) {
			
//				nome = rs.getString("nome") + " " + rs.getString("cognome") + 
//						" " + rs.getInt("telefono");
//				System.out.println(nome);
			
			listaClienti.add(
					new Cliente(rs.getInt("id"),
					rs.getString("nome"), 
					rs.getString("cognome"), 
					rs.getInt("cap"),
					rs.getString("telefono"),
					rs.getString("premium")
					));
		}
		
//			for(Cliente c: listaClienti) {
//				System.out.println(c.getNome() + " " + 
//						c.getCognome());
//			}
		
		return listaClienti;
	}
	
	public Cliente getClienteByID(int id) {
		
		Cliente cliente = null;
		
	// 1. Connessione
		try {
			Connection connection = DriverManager.getConnection(connectionString);
			
			String query = "select * from Cliente where id = ?";
			
			// 2. Creazione dello Statement sulla connessione attiva
			PreparedStatement stm = connection.prepareStatement(query);
			stm.setInt(1, id);
			
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()) {
				cliente = new Cliente(rs.getInt("id"),
						rs.getString("nome"), 
						rs.getString("cognome"), 
						rs.getInt("cap"),
						rs.getString("telefono"),
						rs.getString("premium")
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cliente;
	}
	
	public ArrayList<Cliente> getAllClientiByNomeOCognome(String s) {
		
ArrayList<Cliente> listaClienti = new ArrayList<Cliente>();
		
		// 1. Connessione
		try {
			Connection connection = DriverManager.getConnection(connectionString);
			
			String query = "select * from Cliente where nome = ?"
					+ "or cognome = ?";
			
			// 2. Creazione dello Statement sulla connessione attiva
			PreparedStatement stm = connection.prepareStatement(query);
			stm.setString(1, s);
			stm.setString(2, s);
			
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()) {
				
				listaClienti.add(
						new Cliente(rs.getInt("id"),
						rs.getString("nome"), 
						rs.getString("cognome"), 
						rs.getInt("cap"),
						rs.getString("telefono"),
						rs.getString("premium")
						));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listaClienti;

	}

	public int insertCliente(Cliente c) {
			
		int nuovoIndice = 0;
			
		// 1. Connessione
			try {
				Connection connection = DriverManager.getConnection(connectionString);
				
				String query = "insert into cliente (nome, cognome, cap, telefono, premium)" + 
						"values (?, ?, ?, ?, ?);";
				
				// 2. Creazione dello Statement sulla connessione attiva
				PreparedStatement stm = connection.prepareStatement(query);
				stm.setString(1, c.getNome());
				stm.setString(2, c.getCognome());
				stm.setString(3, (String.valueOf(c.getCap())));
				stm.setString(4, c.getTelefono());
				stm.setString(5, c.getPremium());
				
				stm.executeUpdate();
				
				ResultSet rs = stm.getGeneratedKeys();
				
				if(rs.next()) {
					nuovoIndice = rs.getInt(1);
				}
				
//				while(rs.next()) {
//					cliente = new Cliente(rs.getInt("id"),
//							rs.getString("nome"), 
//							rs.getString("cognome"), 
//							rs.getInt("cap"),
//							rs.getString("telefono"),
//							rs.getString("premium")
//							);
//				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return nuovoIndice;
		}
	
	public int updateCliente(Cliente c) {
		
		int rigaModificata = 0;
			
		// 1. Connessione
			try {
				Connection connection = DriverManager.getConnection(connectionString);
				
				String query = "update cliente set nome = ?, "
						+ "cognome = ?, "
						+ "cap = ?, "
						+ "telefono = ?,"
						+ " premium = ?" + 
						"where id = ?;";
				
				// 2. Creazione dello Statement sulla connessione attiva
				PreparedStatement stm = connection.prepareStatement(query);
				stm.setString(1, c.getNome());
				stm.setString(2, c.getCognome());
				stm.setString(3, (String.valueOf(c.getCap())));
				stm.setString(4, c.getTelefono());
				stm.setString(5, c.getPremium());
				stm.setInt(6, c.getId());
				
				rigaModificata = stm.executeUpdate();
				
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return rigaModificata;
		}
	
	public int deleteCliente(int id) {
			
			int rigaCancellata = 0;
				
			// 1. Connessione
				try {
					Connection connection = DriverManager.getConnection(connectionString);
					
					String query = "delete from cliente where id = ?";
					
					// 2. Creazione dello Statement sulla connessione attiva
					PreparedStatement stm = connection.prepareStatement(query);
					
					stm.setInt(1, id);
					
					rigaCancellata = stm.executeUpdate();
					
					
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return rigaCancellata;
			}

	public ArrayList<Prodotto> getAllProdotti() throws SQLException{
		
		ArrayList<Prodotto> listaProdotti = new ArrayList<Prodotto>();
				
				// 1. Connessione
				Connection connection = DriverManager.getConnection(connectionString);
				
				String query = 	"select \r\n" + 
								"p.id as prodotto_id,\r\n" + 
								"p.nome as prodotto_nome,\r\n" + 
								"p.categoria as prodotto_categoria,\r\n" + 
								"p.prezzoU as prodotto_prezzo_unitario,\r\n" + 
								"p.scorta as prodotto_scorta,\r\n" + 
								"p.descrizione as prodotto_descrizione,\r\n" + 
								"f.id as fornitore_id,\r\n" + 
								"f.nome as fornitore_nome,\r\n" + 
								"f.indirizzo as fornitore_indirizzo,\r\n" + 
								"f.telefono as fornitore_telefono,\r\n" + 
								"f.costoTrasporto as fornitore_costo_trasporto\r\n" + 
								"from prodotto p\r\n" + 
								"inner join fornitore f\r\n" + 
								"on p.fornitore = f.id;";
				
				// 2. Creazione dello Statement sulla connessione attiva
				PreparedStatement stm = connection.prepareStatement(query);
				
				ResultSet rs = stm.executeQuery();
				
				Fornitore fornitore = null;
				
				while(rs.next()) {
					fornitore = new Fornitore(
							rs.getInt("fornitore_id"), 
							rs.getString("fornitore_nome"),
							rs.getString("fornitore_indirizzo"), 
							rs.getString("fornitore_telefono"), 
							rs.getDouble("fornitore_costo_trasporto")
							);
							
							
					listaProdotti.add(
							new Prodotto(rs.getInt("prodotto_id"),
							rs.getString("prodotto_nome"), 
							rs.getString("prodotto_categoria"), 
							rs.getDouble("prodotto_prezzo_unitario"),
							rs.getInt("prodotto_scorta"),
							rs.getString("prodotto_descrizione"),
							fornitore));
				}
				
				return listaProdotti;
			}
	
	public ArrayList<Categoria> getScorteG() throws SQLException{
			
		ArrayList<Categoria> listaGiacenze = new ArrayList<Categoria>(); 	
					
		// 1. Connessione
		Connection connection = DriverManager.getConnection(connectionString);
		
		String query = 	"select categoria, sum(scorta) as tot\r\n" + 
						"from prodotto\r\n" + 
						"group by categoria;";
		
		// 2. Creazione dello Statement sulla connessione attiva
		PreparedStatement stm = connection.prepareStatement(query);
		
		ResultSet rs = stm.executeQuery();
		
		while(rs.next()) {
			listaGiacenze.add(new Categoria(rs.getString("categoria"), rs.getInt("tot")));
			}
		return listaGiacenze;
		
		}
}
