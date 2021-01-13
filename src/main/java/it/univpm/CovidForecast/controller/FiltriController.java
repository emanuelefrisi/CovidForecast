package it.univpm.CovidForecast.controller;

import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import it.univpm.CovidForecast.filters.FilterCity;
import it.univpm.CovidForecast.filters.FilterData;
import it.univpm.CovidForecast.filters.FilterFL;
import it.univpm.CovidForecast.filters.FilterHumidity;
import it.univpm.CovidForecast.filters.FilterPressure;
import it.univpm.CovidForecast.filters.FilterTemperature;
import it.univpm.CovidForecast.model.CittaJSON;
import it.univpm.CovidForecast.model.Filtri;
import it.univpm.CovidForecast.model.MeteoCitta;
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

	@PostMapping("/filtri")
	public Vector<CittaJSON> filtri(@RequestBody Filtri filtriObj) {

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
			 * A seconda del tipo di filtro che si vuole, il programma chiama il metodo che
			 * prende in input i dati con il giusto tipo. Il metodo esegue il filtro
			 * desiderato e cambia il formato della data da secondi passati dal 01/01/1970 a
			 * giorno-mese-anno e aggiunge tutto ad un vettore di CittaJSON (con data
			 * formato giorno-mese-anno)
			 */
			String longOrDouble = filtriObj.getVariabile();
//			if (longOrDouble.equals("temperatura") || longOrDouble.equals("tempPercepita")) {
//				Vector<MeteoCitta> mCVect1 = this.variabilePerDouble(longOrDouble, vettData,
//						filtriObj.getValInit_perDouble(), filtriObj.getValFin_perDouble());
//				cJVect.addAll(cCJ.getCittaJSON(mCVect1));
//			}else if (longOrDouble.equals("pressione") || longOrDouble.equals("umidita")) {
//				Vector<MeteoCitta> mCVect1 = this.variabilePer_long(longOrDouble, vettData,
//						filtriObj.getValInit_per_long(), filtriObj.getValFin_per_long());
//				cJVect.addAll(cCJ.getCittaJSON(mCVect1));
//			} else {
//				Vector<MeteoCitta> VMCError = new Vector<MeteoCitta>();
//				MeteoCitta mCError = new MeteoCitta(0, "Errore", "Errore", 0, 0, null, null, null, null, 0);
//				VMCError.add(mCError);
//				cJVect.addAll(cCJ.getCittaJSON(VMCError));
//			}
			/*
			 * Torna indietro e rifà tutto se nel parametro in entrata c'è più di una città
			 */
			Vector<MeteoCitta> mCVect1 = this.variabile(longOrDouble, vettData,
					filtriObj.getValInit_perDouble(), filtriObj.getValFin_perDouble());
			cJVect.addAll(cCJ.getCittaJSON(mCVect1));
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
//			return sT.getStats(tipoStat, vectPerStats);

		case "tempMax":
//			return sTM.getStats(tipoStat, vectPerStats);

		case "tempMin":
//			return sTm.getStats(tipoStat, vectPerStats);

		case "tempPercepita":
			return fFL.getFromPTemperatureFilter(vectPerFiltri, valInit, valFin);

		case "umidita":
//			return sU.getStats(tipoStat, vectPerStats);

		default: {
			Vector<MeteoCitta> VMCError = new Vector<MeteoCitta>();
			MeteoCitta mCError = new MeteoCitta(0, "Errore", "Errore", 0, 0, null, null, null, null, 0);
			VMCError.add(mCError);
			return VMCError;
			}

		}

	}
	
	
	
//	public Vector<MeteoCitta> variabilePerDouble(String var, Vector<MeteoCitta> vectPerFiltri, Double valInit,
//			Double valFin) {
//
//		switch (var) {
//
//		case "temperatura":
//			return fT.getFromTemperatureFilter(valInit, valFin);
//
//		case "tempPercepita":
//			return fFL.getFromPTemperatureFilter(vectPerFiltri, valInit, valFin);
//
//		}
//		return null;
//
//	}
//
//	public Vector<MeteoCitta> variabilePer_long(String var, Vector<MeteoCitta> vectPerStats, long valInit,
//			long valFin) {
//
//		switch (var) {
//
//		case "pressione":
//			return fP.getFromPressureFilter(valInit, valFin);
//
//		case "umidita":
//			return fH.getFromHumidityFilter(valInit, valFin);
//
//		}
//		return null;
//
//	}
}