package it.univpm.CovidForecast.tools;

import java.util.List;
import java.util.Vector;

import it.univpm.CovidForecast.model.MeteoCitta;
import it.univpm.CovidForecast.service.MeteoCittaService;

public class ErroreCitta {

	private MeteoCittaService mCS;
	private List<MeteoCitta> lMC;
	private Vector<String> elencoCitta;
	private boolean indice = false;

	public boolean errorCity(Vector<String> citta) {

		elencoCitta = new Vector<String>(9);
		lMC = mCS.getMeteoCittaFromDB();
		for (int i = 0; i < elencoCitta.size(); i++) {
			elencoCitta.add(lMC.get(i).getCitta());
		}
		for (int i = 0; i < citta.size(); i++) {
			indice = elencoCitta.contains(citta.elementAt(i));
			if(indice==false) break;
		}
		return indice;

	}

}
