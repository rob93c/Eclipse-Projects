package it.academy_modis;

public class EccezioniEsempio {

	public static void main(String[] args) {

//		try {
//			FileWriter fw = new FileWriter("C:\\Utenti\\pippo.txt");
//			System.out.println("Try");
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//			System.out.println("Catch");
//		}
		
//		System.out.println(metodoIntermedio(0));
		
		try {
			System.out.println(metodoIntermedio(0));
		}
		catch(ArithmeticException e) {
			System.out.println("Operazione non possibile: " + e);
		}
		
		
		
	}

	public static double metodoIntermedio(int quantiValori) {
		return calcolaMedia(quantiValori);
	}
	
	
	public static double calcolaMedia(int quantiValori) {
		
		int[] a = {4, 6, 7, 3, 4, 6, 8, 8};		
		double somma = 0;
		
		for(int i = 0; i < quantiValori; i++) {
			somma += a[i];
		}
		if(quantiValori > 0) {
			return somma / quantiValori;
		} else {
			throw new ArithmeticException();
		}
		
		
	}
	
	
	
	
}
