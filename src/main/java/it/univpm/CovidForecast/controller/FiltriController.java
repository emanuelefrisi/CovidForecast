package it.univpm.CovidForecast.controller;

import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import it.univpm.CovidForecast.exception.EccezionePersonalizzata;
import it.univpm.CovidForecast.filters.FilterFL;
import it.univpm.CovidForecast.filters.FilterHumidity;
import it.univpm.CovidForecast.filters.FilterPressure;
import it.univpm.CovidForecast.filters.FilterTemperature;
import it.univpm.CovidForecast.model.CittaJSON;
import it.univpm.CovidForecast.model.Filtri;
import it.univpm.CovidForecast.model.MeteoCitta;

/**
 * Classe contenente il controller dell'applicazione che gestisce le rotte dei
 * filtri
 * 
 * @author domenicolaporta00
 *
 */
@RestController
public class FiltriController extends Controller {

	@Autowired
	/**
	 * Oggetto FilterFL utile per eseguire il filtraggio per temperatura percepita
	 */
	private FilterFL fFL = new FilterFL();
	@Autowired
	/**
	 * Oggetto FilterHumidity utile per eseguire il filtraggio per umidità
	 */
	private FilterHumidity fH = new FilterHumidity();
	@Autowired
	/**
	 * Oggetto FilterPressure utile per eseguire il filtraggio per pressione
	 */
	private FilterPressure fP = new FilterPressure();
	@Autowired
	/**
	 * Oggetto FilterTemperature utile per eseguire il filtraggio per temperatura
	 */
	private FilterTemperature fT = new FilterTemperature();

	/**
	 * Metodo che ritorna un Vector di CittaJSON contenente tutti gli oggetti
	 * filtati secondo l'input ricevuto dall'utente
	 * 
	 * @param filtriObj Filtri
	 * @see it.univpm.CovidForecast.filters.FilterCity.getFromCityFilter
	 * @see it.univpm.CovidForecast.tools.ConvertitoreData.convertiDaString
	 * @see it.univpm.CovidForecast.filters.FilterData.getFromDataFilter
	 * @see it.univpm.CovidForecast.controller.FiltriController.variabile
	 * @return Vector<CittaJSON>
	 * @throws Eccezioni personalizzate se ci sono errori di input nell'oggetto di
	 *                   tipo Filtri filtriObj
	 */
	@PostMapping("/filters")
	public Vector<CittaJSON> filters(@RequestBody Filtri filtriObj) {

		try {
			if (!cS.controlloCitta(filtriObj.getCitta()))
				throw new EccezionePersonalizzata("Errore nell'input della città!");

			if (!vS.controlloVariabile(filtriObj.getVariabile()))
				throw new EccezionePersonalizzata("Errore nell'input del tipo di parametro!");

			if (filtriObj.getDataInit().length() != 16 || filtriObj.getDataFin().length() != 16
					|| filtriObj.getDataFin().charAt(2) != '-' || filtriObj.getDataFin().charAt(5) != '-'
					|| filtriObj.getDataInit().charAt(2) != '-' || filtriObj.getDataInit().charAt(5) != '-'
					|| filtriObj.getDataInit().charAt(10) != ' ' || filtriObj.getDataFin().charAt(10) != ' '
					|| filtriObj.getDataInit().charAt(13) != ':' || filtriObj.getDataFin().charAt(13) != ':')
				throw new EccezionePersonalizzata("Errore di input della data!");

		} catch (EccezionePersonalizzata e) {

			return EccezionePersonalizzata.getVCJError();

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
			if (vettData.isEmpty())
				return new Vector<CittaJSON>();
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

	/**
	 * Metodo che esegue il filtraggio desiderato, restituendo un oggetto MeteoCitta
	 * (formato data String). A seconda del var dato in input, parte una funzione
	 * che esegue il filtraggio
	 * 
	 * @param var           String
	 * @param vectPerFiltri Vector<MeteoCitta>
	 * @param valInit       Double
	 * @param valFin        Double
	 * @return Vector<MeteoCitta>
	 */
	public Vector<MeteoCitta> variabile(String var, Vector<MeteoCitta> vectPerFiltri, Double valInit, Double valFin) {

		switch (var) {

		case "pressione":
			return fP.getFromPressureFilter(vectPerFiltri, valInit.longValue(), valFin.longValue());

		case "temp":
			return fT.getFromTemperatureFilter(vectPerFiltri, valInit, valFin);

		case "tempPercepita":
			return fFL.getFromPTemperatureFilter(vectPerFiltri, valInit, valFin);

		case "umidita":
			return fH.getFromHumidityFilter(vectPerFiltri, valInit.longValue(), valFin.longValue());

		}
		return null;

	}

}