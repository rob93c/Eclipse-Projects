package it.academy_modis;

import java.util.ArrayList;

public class EsempioEreditarieta {

	public static void main(String[] args) {
		
//		Veicolo veicolo = new Veicolo("Fiat", "Punto", 1200, 4);
		
		Automobile automobile = new Automobile("Fiat", "Punto", 1200, 4, 5);
		
		Autocarro autocarro = new Autocarro("Fiat", "Doblò", 1500, 4, 2000);
		
		Motocicletta moto = new Motocicletta("BMW", "Viper", 3000);
		
//		automobile.stampaMarcaModello();
//		autocarro.stampaMarcaModello();
		
		ArrayList<Veicolo> listaVeicoli = new ArrayList<Veicolo>();
		listaVeicoli.add(automobile);
		listaVeicoli.add(autocarro);
		listaVeicoli.add(moto);
		
//		System.out.println(moto.getNumeroRuore());
		
		for(Veicolo v: listaVeicoli) {
			v.stampaMarcaModello();
		}
		
		
		
		
		

	}

}
