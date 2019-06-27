package it.academy_modis;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

public class StringheTest {

	private static EsempioStringheTest es;
	private static String s;
	
	@BeforeClass
	public static void beforeClassFunction() {
		es = new EsempioStringheTest();
		s = "Lorem ipsum lorem";
	}
	
	@Test
	public void testContaOccorrenzeCon2Occorrenze() {
		
		// input
		String daCercare = "re";
		
		// risultato
		int occorrenze = 2;
		
		EsempioStringheTest es = new EsempioStringheTest();
		
		assertEquals(occorrenze, es.contaOccorrenze(s, daCercare));
	
	}
	
	@Test
	public void testContaOccorrenzeConNessunaOccorrenza() {
		
		// input
		String daCercare = "pippo";
		
		// risultato
		int occorrenze = 0;
		
		EsempioStringheTest es = new EsempioStringheTest();
		
		assertEquals(occorrenze, es.contaOccorrenze(s, daCercare));
	}

}
