package it.academy_modis;

public class Gioca {
	public static void main(String[] args) {
		
		Eroe eroe = new Eroe();
		
		Vampiro vampiro = new Vampiro();
		
		Licantropo licantropo = new Licantropo(true);
		
		eroe.combatti();
		eroe.combatti();
		eroe.combatti();
		
		vampiro.azzanna();
		
		licantropo.azzanna();
		licantropo.azzanna();
		
		eroe.stampaForza();
		vampiro.stampaForza();
		licantropo.stampaForza();
	}
}
