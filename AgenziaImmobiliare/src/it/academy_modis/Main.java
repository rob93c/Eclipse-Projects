package it.academy_modis;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		Villa villa1 = new Villa(100, 15, false);
		Villa villa2 = new Villa(500, 8, true);
		Villa villa3 = new Villa(760, 11, true);
		
		Appartamento app1 = new Appartamento(300, 5, 8);
		Appartamento app2 = new Appartamento(400, 6, 3);
		Appartamento app3 = new Appartamento(1300, 12, 9);
		
		ArrayList<Casa> listaCase = new ArrayList<Casa>();
		listaCase.add(villa1);
		listaCase.add(villa2);
		listaCase.add(villa3);
		listaCase.add(app1);
		listaCase.add(app2);
		listaCase.add(app3);
		
		Archivio archivio = new Archivio(listaCase);
		
		System.out.println(archivio.getMediaOver(100));
		
		
		
		
		
		
	}

}
