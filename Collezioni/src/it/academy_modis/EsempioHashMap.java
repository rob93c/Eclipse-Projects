package it.academy_modis;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class EsempioHashMap {

	public static void main(String[] args) {
		
//		Map<String, Smartphone> mappa = new HashMap<String, Smartphone>();
//		
//		Smartphone sm = new Smartphone();
//		sm.setMarca("Apple");
//		sm.setModello("iPhone");
//		
//		mappa.put(sm.getModello(), sm);
//		
//		Smartphone sm2 = new Smartphone();
//		sm2.setMarca("Samsung");
//		sm2.setModello("Galaxy");
//		
//		mappa.put(sm2.getModello(), sm2);
//		
//		Set<String> chiavi = mappa.keySet();
//		
//		for(String str: chiavi) {
//			System.out.println(str);
//		}
//		
//		System.out.println("-------------------");
//		
//		System.out.println(mappa.size());
//		
//		System.out.println("-------------------");
//		
//		System.out.println(mappa.containsKey("Galaxy"));
//		
//		System.out.println("-------------------");
//		
//		Smartphone sm3 = mappa.get("iPhone");
		
		TreeMap<String, String> rubrica = new TreeMap<String, String>();
		
		rubrica.put("Rossi", "Mario");
		rubrica.put("Bianchi", "Luigi");
		rubrica.put("Magenta", "Osvaldo");
		
		
		Set<String> chiavi2 = rubrica.keySet();
		for(String s: chiavi2) {
			System.out.println(s);
		}
		
		System.out.println("---------------------");
		
		Collection<String> valori = rubrica.values();
		for(String s: valori) {
			System.out.println(s);
		}
		
		System.out.println("---------------------");
		
		for(Map.Entry<String, String> entry: rubrica.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
	}

}
