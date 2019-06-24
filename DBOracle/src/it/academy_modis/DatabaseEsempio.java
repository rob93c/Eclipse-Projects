package it.academy_modis;

public class DatabaseEsempio {

	public static void main(String[] args) {
		
		DatabaseManager db = new DatabaseManager();
		
//		db.getAllImpiegati();
//		
//		String sesso = "M";
//		sesso = "F";
//		db.getAllImpiegatiBySesso(sesso);
		
//		String colonna = "CD_GENDER";
//		String condizione = "M";
//		String where = "where cd_gender = ?";
//		db.getImpiegatiWhere(where, condizione);
		
//		db.getAllImpiegatiByCF("CLLRRT");
//		db.getAllImpiegati();
		
		
//		db.getAllImpiegatiBySesso("M", "DESC");
		db.getAllImpiegatiByNomeECognome("Sofia", "Scarpa");
		
		System.out.println("-------------------------------------------");
	
	}

}
