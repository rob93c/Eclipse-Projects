package it.academy_modis;

public class Main {

	public static void main(String[] args) {
		
		EsempioStringheTest es = new EsempioStringheTest();
		
		int occorrenze = es.contaOccorrenze("lorem ipsum lorem", "re");
		
		System.out.println("Numero di occorrenze: " + occorrenze);
		
	}

}
