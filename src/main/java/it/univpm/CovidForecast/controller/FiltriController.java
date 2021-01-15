package it.univpm.CovidForecast.controller;

import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import it.univpm.CovidForecast.exception.EccezioniPersonalizzate;
import it.univpm.CovidForecast.filters.FilterCity;
import it.univpm.CovidForecast.filters.FilterData;
import it.univpm.CovidForecast.filters.FilterFL;
import it.univpm.CovidForecast.filters.FilterHumidity;
import it.univpm.CovidForecast.filters.FilterPressure;
import it.univpm.CovidForecast.filters.FilterTemperature;
import it.univpm.CovidForecast.model.CittaJSON;
import it.univpm.CovidForecast.model.Filtri;
import it.univpm.CovidForecast.model.MeteoCitta;
import it.univpm.CovidForecast.scanner.CittaScanner;
import it.univpm.CovidForecast.scanner.VariabileScanner;
import it.univpm.CovidForecast.tools.ConvertitoreData;
import it.univpm.CovidForecast.tools.CreaCittaJSON;

@RestController
public class FiltriController {

	@Autowired
	private FilterCity fC = new FilterCity();
	private FilterData fD = new FilterData();
	private ConvertitoreData cD = new ConvertitoreData();
	private CreaCittaJSON cCJ = new CreaCittaJSON();
	@Autowired
	private FilterFL fFL = new FilterFL();
	@Autowired
	private FilterHumidity fH = new FilterHumidity();
	@Autowired
	private FilterPressure fP = new FilterPressure();
	@Autowired
	private FilterTemperature fT = new FilterTemperature();
	private Vector<CittaJSON> cJVect;
	private Vector<MeteoCitta> vettCitta;
	private Vector<MeteoCitta> vettData;

	private CittaScanner cS = new CittaScanner();
	private VariabileScanner vS = new VariabileScanner();

	@PostMapping("/filters")
	public Vector<CittaJSON> filters(@RequestBody Filtri filtriObj) {

		try {
			if (!cS.controlloCitta(filtriObj.getCitta()))
				throw new EccezioniPersonalizzate("Errore nell'input della città!");

			if (!vS.controlloVariabile(filtriObj.getVariabile()))
				throw new EccezioniPersonalizzate("Errore nell'input del tipo di parametro!");

			if (filtriObj.getDataFin().charAt(2) != '-' || filtriObj.getDataFin().charAt(5) != '-'
					|| filtriObj.getDataInit().charAt(2) != '-' || filtriObj.getDataInit().charAt(5) != '-'
					|| filtriObj.getDataInit().charAt(10) != ' ' || filtriObj.getDataFin().charAt(10) != ' '
					|| filtriObj.getDataInit().charAt(13) != ':' || filtriObj.getDataFin().charAt(13) != ':'
					|| filtriObj.getDataInit().length() != 15 || filtriObj.getDataFin().length() != 15)
				throw new EccezioniPersonalizzate("Errore di input della data!");

		} catch (EccezioniPersonalizzate e) {

			return EccezioniPersonalizzate.getVCJError();
		}

		cJVect = new Vector<CittaJSON>();
		for (int i = 0; i < filtriObj.getCitta().size(); i++) {
			/* Qui filtra per città */
			vettCitta = fC.getFromCityFilter(filtriObj.getCitta().elementAt(i));
			/*
			 * Qui cambia il formato delle date da giorno-mese-anno a secondi passati dal
			 * 01/01/1970
			 */
			long dI = cD.convertiDaString(filtriObj.getDataInit());
			long dF = cD.convertiDaString(filtriObj.getDataFin());
			/* Qui filtra il vettore precedentemente filtrato per citta, per data */
			vettData = fD.getFromDataFilter(vettCitta, dI, dF);
			/*
			 * Il metodo esegue il filtro desiderato e cambia il formato della data da
			 * secondi passati dal 01/01/1970 a giorno-mese-anno e aggiunge tutto ad un
			 * vettore di CittaJSON (con data formato giorno-mese-anno)
			 */
			String longOrDouble = filtriObj.getVariabile();
			Vector<MeteoCitta> mCVect1 = this.variabile(longOrDouble, vettData, filtriObj.getValInit(),
					filtriObj.getValFin());
			cJVect.addAll(cCJ.getCittaJSON(mCVect1));
			/*
			 * Torna indietro e rifà tutto se nel parametro in entrata c'è più di una città
			 */
		}
		/*
		 * Ritorna il vettore finale filtrato per città, data e per la variabile
		 * desiderata
		 */
		return cJVect;
	}

	public Vector<MeteoCitta> variabile(String var, Vector<MeteoCitta> vectPerFiltri, Double valInit, Double valFin) {

		switch (var) {

		case "pressione":
			return fP.getFromPressureFilter(vectPerFiltri, valInit.longValue(), valFin.longValue());

		case "temperatura":
			return fT.getFromTemperatureFilter(vectPerFiltri, valInit, valFin);

		case "tempPercepita":
			return fFL.getFromPTemperatureFilter(vectPerFiltri, valInit, valFin);

		case "umidita":
			return fH.getFromHumidityFilter(vectPerFiltri, valInit.longValue(), valFin.longValue());

		default: {
			/*
			 * Vector<MeteoCitta> VMCError = new Vector<MeteoCitta>(); MeteoCitta mCError =
			 * new MeteoCitta(0, "Errore di input del tipo di parametro",
			 * "Errore di input del tipo di parametro", 0, 0, null, null, null, null, 0);
			 * VMCError.add(mCError); return VMCError;
			 */
		}

		}
		return null;

	}

}