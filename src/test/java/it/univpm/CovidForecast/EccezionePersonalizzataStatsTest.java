package it.univpm.CovidForecast;


import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Vector;

import org.junit.jupiter.api.Test;

import it.univpm.CovidForecast.exception.EccezionePersonalizzata;
import it.univpm.CovidForecast.model.Stats;
import it.univpm.CovidForecast.scanner.TipoStatScanner;

class EccezionePersonalizzataStatsTest {

	public void erroreTipoStat(Stats statsObj) throws EccezionePersonalizzata {
		TipoStatScanner tSS = new TipoStatScanner();
		if (!tSS.controlloTipoStat(statsObj.getTipoStat()))
			throw new EccezionePersonalizzata("Errore nell'input del tipo di stat!");
	}

	@Test
	void testEccezionePersonalizzata() {
		Vector<String> vS = new Vector<String>();
		vS.add("Ancona");
		Stats s = new Stats(vS, "01-01-2021 09:00", "03-01-2021 09:00", "temp", "varianz");
		assertThrows(EccezionePersonalizzata.class, () -> this.erroreTipoStat(s),
				"Errore nell'input del tipo di stat!");

	}

}
