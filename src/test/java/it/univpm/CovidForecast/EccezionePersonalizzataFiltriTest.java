package it.univpm.CovidForecast;


import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Vector;

import org.junit.jupiter.api.Test;

import it.univpm.CovidForecast.exception.EccezionePersonalizzata;
import it.univpm.CovidForecast.model.Filtri;
import it.univpm.CovidForecast.scanner.VariabileScanner;

class EccezionePersonalizzataFiltriTest {

	public void erroreVariabile(Filtri filtriObj) throws EccezionePersonalizzata {
		VariabileScanner vS = new VariabileScanner();
		if (!vS.controlloVariabile(filtriObj.getVariabile()))
			throw new EccezionePersonalizzata("Errore nell'input del tipo di parametro!");
	}

	@Test
	void testEccezionePersonalizzata() {
		Vector<String> vS = new Vector<String>();
		vS.add("Ancona");
		Filtri f = new Filtri(vS, "01-01-2021 09:00", "03-01-2021 09:00", "temeratura", 0.5, 1.5);
		assertThrows(EccezionePersonalizzata.class, () -> this.erroreVariabile(f),
				"Errore nell'input del tipo di parametro!");

	}

}
