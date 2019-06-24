package it.academy_modis;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
//		Amico amico1 = new Amico("Davide", "Bertola", 27);
//		Amico amico2 = new Amico("Davide", "Bertola", 27);
		
		Foto foto1 = new Foto("dog.png");
		Foto foto2 = new Foto("meme.jpg");
		
		ArrayList<Foto> album = new ArrayList<>();
		
		album.add(foto1);
		album.add(foto2);
		
		Tag tag = new Tag(album);
		
		tag.aggAmico("Sofia", "Scarpa", 29);
		tag.aggAmico("Sofia", "Scarpa", 29);
		tag.aggAmico("So221fia", "Scarpa", 42);
		tag.aggAmico("Sia", "Scarpa", 79);
		
//		tag.stampaAmici();
		
//		tag.rimuoviAmico("Sofia", "Scarpa", 29);
		tag.rimuoviAmico("Giorgio", "Merdolo", 28);
		
//		tag.stampaAmici();
		
		tag.addTag("Foto vacanze", "Sofia", "Scarpa", 29);
		System.out.println(tag.calcolaEtaMedia());
		System.out.println(tag.calcolaMaxApparizioni().getNome() + " " +
				tag.calcolaMaxApparizioni().getCognome());
	}

}
