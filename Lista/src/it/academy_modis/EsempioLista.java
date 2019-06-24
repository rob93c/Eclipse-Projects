package it.academy_modis;

import java.util.ArrayList;

public class EsempioLista {

	public static void main(String[] args) {
		
		Pizza margherita = new Pizza("Margherita", 5);
		Pizza capricciosa = new Pizza("Capriocciosa", 7.5);
		Pizza napoli = new Pizza("Napoli", 7.5);
		
//		Pizza[] listaPizze = new Pizza[2];
//		
//		listaPizze[0] = margherita;
//		listaPizze[1] = capricciosa;
		
		ArrayList<Pizza> listaPizze = new ArrayList<Pizza>();
		listaPizze.add(margherita);
		listaPizze.add(capricciosa);
		listaPizze.add(margherita);
		listaPizze.add(napoli);
		listaPizze.add(margherita);
		
		listaPizze.remove(0);
		
//		System.out.println(listaPizze.size());
//		
//		for(Pizza p: listaPizze) {
//			System.out.println(p.getNome());
//		}
//		
		listaPizze.add(0, napoli);
		
		for(int i = 0; i < listaPizze.size(); i++) {
			System.out.println(listaPizze.get(i).getNome());
		}	

		//		stampaLista(listaPizze)
	}
	
	private static void stampaLista(ArrayList<Pizza> listaPizze) {
		for(int i = 0; i < listaPizze.size(); i++) {
			System.out.println(listaPizze.get(i).getNome());
		}
	}
	
	
}
