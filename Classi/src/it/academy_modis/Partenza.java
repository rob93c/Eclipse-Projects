package it.academy_modis;

public class Partenza {

	public static void main(String[] args) {
		
		TitoloDiStudio titoloMario = new TitoloDiStudio("Diploma", "Liceo");
		TitoloDiStudio titoloLuigi = new TitoloDiStudio("Laurea", "Università");
		Persona mario = new Persona("Mario", "Rossi", 34, "RSSMR", titoloMario);
		Persona luigi = new Persona("Luigi", "Bianchi", 56, "BNCLG", titoloLuigi);
		
		Persona[] arrayPersone = new Persona[2];
		arrayPersone[0] = mario;
		arrayPersone[1] = luigi;
		
		for(int i = 0; i < arrayPersone.length; i++) {
			//arrayPersone[i].printNomeECognome();
//			Persona p = arrayPersone[i];
//			String nome = p.getNome();
//			String cognome = p.getCognome();
//			
//			System.out.println(nome + " " + cognome);
			
			String pers = arrayPersone[i].printNomeECognome();
			System.out.println(pers);
		}
		
	}

}
