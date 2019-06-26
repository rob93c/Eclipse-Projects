package it.academy_modis;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.TreeSet;

public class TombolaConRipetizioni {

	public static void main(String[] args) {
		
//		HashSet <Integer> numeriEstratti2 = new HashSet <Integer>();
//		
//		int i = 1;
//		while(i <= 90) {
//			numeriEstratti2.add(i);
//			i++;
//		}
//		
//		Random generator2 = new Random();
//		int count2 = 0;
//		while(numeriEstratti2.size() > 0) {
//			int numero2 = 1 + generator2.nextInt(90);
//			if(numeriEstratti2.remove(numero2)) {
//				count2++;
//				if(numero2 < 10)
//					System.out.println("Passo numero " + count2 + ": numero estratto -->  " + numero2 +
//										" (Numeri rimasti da estrarre: " + numeriEstratti2.size() + ")");
//				else
//					if(numeriEstratti2.size() < 10)
//						System.out.println("Passo numero " + count2 + ": numero estratto --> " + numero2 +
//								" (Numeri rimasti da estrarre:  " + numeriEstratti2.size() + ")");
//					else
//						System.out.println("Passo numero " + count2 + ": numero estratto --> " + numero2 +
//								" (Numeri rimasti da estrarre: " + numeriEstratti2.size() + ")");
//			}
//		}
		
//		HashSet <Integer> numeriEstratti = new HashSet <Integer>();
//		Random generator = new Random();
//		
//		int count = 0;
//		while(numeriEstratti.size() != 90) {
//			int numero = 1 + generator.nextInt(90);
//			count++;
//			numeriEstratti.add(numero);
//			System.out.println(count + ": numero estratto --> " + numero + 
//					" (Numeri diversi estratti: " + numeriEstratti.size() + ")");
//		}
		
		
//		HashSet<String> s1 = new HashSet<String>();
//		TreeSet<String> s2 = new TreeSet<String>();
//		LinkedHashSet<String> s3 = new LinkedHashSet<String>();
//		
//		Random generator3 = new Random();
//		
//		while(s1.size() < 10) {
//			int n = generator3.nextInt(10);
//			if(s1.add("str " + n) && s2.add("str " + n) && s3.add("str " + n)) {
//				System.out.println("Inserisco str " + n);
//			}
//		}
//		
//		System.out.println("s1 = " + s1);
//		System.out.println("s2 = " + s2);
//		System.out.println("s3 = " + s3);
		
		HashSet<Prodotto> s1 = new HashSet<Prodotto>();
		TreeSet<Prodotto> s2 = new TreeSet<Prodotto>();
		LinkedHashSet<Prodotto> s3 = new LinkedHashSet<Prodotto>();
		
		Random generator3 = new Random();
		
		Prodotto p = null;
		while(s1.size() < 10) {
			int i = generator3.nextInt(10);
			
			p = new Prodotto("str " + i);
			
			if(s1.add(p) && s2.add(p) && s3.add(p)) {
				System.out.println("Inserisco " + p.getName());
			}
		}
		
		System.out.println("s1 = " + s1);
		System.out.println("s2 = " + s2);
		System.out.println("s3 = " + s3);
		
	}

}
