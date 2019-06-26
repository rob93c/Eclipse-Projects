package it.academy_modis;

import java.util.HashSet;
import java.util.Scanner;

public class ParoleRipetute {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		HashSet <String> hashSet = new HashSet <String>();
		
		for(int i = 0; i < 10; i++) {
			String s = input.nextLine();
			if(!hashSet.add(s))
				System.out.println("Parola ripetuta: " + s);
		}
		input.close();
		System.out.println("\nInserimento terminato.\n");
		for(String str: hashSet) {
			System.out.println(str);
		}
	}

}
