package it.univpm.CovidForecast;

import it.univpm.CovidForecast.tools.ConvertitoreData;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ConvertitoreDataTest {

	private ConvertitoreData cD;
	
	@BeforeEach
	public void setUp() {
		cD = new ConvertitoreData();
	}

	@AfterEach
	public void tearDown() {
	}

	@Test
	@DisplayName("Test metodo convertiDaString")
	public void convertiDaStringTest() {
		assertEquals(cD.convertiDaString("01-01-2021 00:00"), 1609455600);
	}
	
	@Test
	@DisplayName("Test metodo convertiDaUnix")
	public void convertiDaUnixTest() {
		assertEquals(cD.convertiDaUnix(1611139620), "20-01-2021 11:47");
	}

}
