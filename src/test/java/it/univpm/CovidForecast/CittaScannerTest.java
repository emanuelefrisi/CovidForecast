package it.univpm.CovidForecast;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Vector;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import it.univpm.CovidForecast.scanner.CittaScanner;

class CittaScannerTest {

	private CittaScanner cS;
	private Vector<String> citta;
	
	@BeforeEach
	public void setUp() {
		cS = new CittaScanner();
		citta = new Vector<String>();
		citta.add("Ancona");
		citta.add("Cagliari");
		citta.add("Firenze");
		citta.add("Foggia");
		citta.add("Milano");
		citta.add("Napoli");
		citta.add("Palermo");
		citta.add("Perugia");
		citta.add("Torino");
		citta.add("Venezia");
	}

	@AfterEach
	public void tearDown(){
	}

	@Test
	@DisplayName("Test di controllo dei vettori")
	public void test() {
		assertEquals(cS.getCitta(), this.citta);
	}

}
