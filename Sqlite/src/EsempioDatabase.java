import java.sql.SQLException;
import java.util.ArrayList;

public class EsempioDatabase {

	public static void main(String[] args) {
		
		String connectionString = "jdbc:sqlite:test.db";
		
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			System.exit(1);
		}
		
		DatabaseManager db = new DatabaseManager(connectionString);
		
//		ArrayList<Cliente> listaClienti;
//		try {
//			listaClienti = db.getAllClienti();
//			for(Cliente c: listaClienti) {
//				System.out.println(c.getNome() + " " +
//						c.getCognome());
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		
//		System.out.println("--------------------------------");
		
//		Cliente c1 = db.getClienteByID((5));
//		if(c1 != null) {
//			System.out.println(c1.getNome() + " " + c1.getCognome());
//		}
		
//		System.out.println("--------------------------------");
		
		// esatto match
//		ArrayList<Cliente> listaC = db.getAllClientiByNomeOCognome("Maria");
//		for(Cliente c: listaC) {
//			System.out.println(c.getNome() + " " + c.getCognome());
//		}
//		
		System.out.println("----------------------------------------------------------------");
		
//		Cliente nuovoCliente = new Cliente("Test", "Test", 1234, "Telefono", "Premium");
//		int idNuovoCliente = db.insertCliente(nuovoCliente);
//		System.out.println("ID nuovo cliente: " + idNuovoCliente);
		
		// Modifica del cliente che ha ID = 5;
//		Cliente c2 = db.getClienteByID((5));
//		c2.setNome("Franco");
//		int rigaModificata = db.updateCliente(c2);
//		System.out.println("Righe modificate: " + rigaModificata);
		
//		int rigaCancellata = db.deleteCliente(14);
//		System.out.println("Righe eliminate: " +  rigaCancellata);
		
//		ArrayList<Prodotto> listaProdotti;
//		try {
//			listaProdotti = db.getAllProdotti();
//			for(Prodotto p: listaProdotti) {
//				System.out.println(p.getNome() + " " + p.getFornitore().getNome());
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		ArrayList<Categoria> listaGiacenze = new ArrayList<Categoria>();
		try {
			listaGiacenze = db.getScorteG();
			for(Categoria c: listaGiacenze) {
				System.out.println("La categoria: " + c.getCategoria() + 
						" ha una giacenza totale di " + c.getGiacenza());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("----------------------------------------------------------------");
		
		
	}
	
	
}
