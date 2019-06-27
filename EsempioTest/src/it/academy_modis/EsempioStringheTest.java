package it.academy_modis;

public class EsempioStringheTest {
	
	
	public int contaOccorrenze(String str1, String token) {
		int nOccorrenze = 0;
		
		for(int i = 0; i <= str1.length() - token.length(); i++) {
			String temp = str1.substring(i, i + token.length());
			if(temp.equals(token)) {
				nOccorrenze++;
			}
		}
		return nOccorrenze;
	}
}
