package it.academy_modis;

public class GestioneConto {

	public static void main(String[] args) {
		ContoCorrente contoCorrente1 = new ContoCorrente("Mario Rossi", 1000);
		
//		contoCorrente1.versa(100);
//		
//		contoCorrente1.stampaSaldo();
//		
//		contoCorrente1.preleva(400);
//		
//		contoCorrente1.stampaSaldo();
		
		ContoCorrente contoCorrente2 = new ContoCorrente("Luigi Bianchi", 4000);
//		
//		contoCorrente2.versa(1500);
//		
//		contoCorrente2.stampaSaldo();
		
		ContoCorrente.setTassoInteresse(0.03);
		
		contoCorrente1.calcolaInteresse();
		
		contoCorrente1.stampaSaldo();
		
		contoCorrente2.calcolaInteresse();
		
		contoCorrente2.stampaSaldo();
	}

}
