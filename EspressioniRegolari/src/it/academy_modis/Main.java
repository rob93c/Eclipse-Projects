package it.academy_modis;

import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) {
		
		/**
		 * [A-Z] A, B... Z
		 * [a-z] a, b... z
		 * [A-Za-z] A, B... Z, a, b... z
		 * [cfg] solo le lettere c, f e g
		 * [^cfg] la stringa deve iniziare per cfg
		 * 
		 * [A-Z]* 0 o più caratteri
		 * [A-Z]+ almeno 1 carattere
		 * [A-Z]{2} due caratteri fissi
		 * [0-9]{2,6} tra i 2 e i 6 caratteri
		 * [a-z]{2,} minimo 2 caratteri
		 */
		
		
//		String targa = "AB123VV";
//		String regex = "[A-Z]{2}[0-9]{3}[A-Z]{2}";
		
//		if(Pattern.matches(regex, targa))
//			System.out.println("La stringa rappresenta una targa valida.");
//		else
//			System.out.println("La stringa non rappresenta una targa valida.");
		
//		String[] targheDaValidare = new String[] {
//				"AB123VV",
//				"VN3211D",
//				"1C125MM",
//				"as352ew"
//		};
//		
//		for(String s: targheDaValidare) {
//			System.out.println(s);
//			if(s.matches(regex)) {
//				System.out.println(s + " è una targa valida.");
//			} else {
//				System.out.println(s + " non è una targa valida.");
//			}
//		}
		
//		String numero1 = "339123456";
//		String numero2 = "339-123456";
//		
//		String regexCellulare = "[0-9]{3}-{0,1}[0-9] {6,}";
//		if(Pattern.matches(regexCellulare, numero1))
//			System.out.println("Numero valido.");
//		else
//			System.out.println("Numero non valido.");
		
		String regexCellulare = "[0-9]{3}-{0,1}[0-9]{6,}";
		String[] numeriDaValidare = new String[] {
				"339123456",
				"339-123456",
				"339--123456",
				"242325432",
				"24311292"
		};
		
		for(String s: numeriDaValidare) {
			if(s.matches(regexCellulare)) {
				System.out.println(s + " numero valido.");
			} else {
				System.out.println(s + " numero non valido.");
			}
		}
		
		System.out.println("-----------------------------------");
	}

}
