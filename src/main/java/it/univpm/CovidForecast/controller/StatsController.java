package it.univpm.CovidForecast.controller;

import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.univpm.CovidForecast.exception.EccezionePersonalizzata;
import it.univpm.CovidForecast.model.CittaJSON;
import it.univpm.CovidForecast.model.MeteoCitta;
import it.univpm.CovidForecast.model.Stats;
import it.univpm.CovidForecast.scanner.TipoStatScanner;
import it.univpm.CovidForecast.stats.StatsPressione;
import it.univpm.CovidForecast.stats.StatsTemp;
import it.univpm.CovidForecast.stats.StatsTempMax;
import it.univpm.CovidForecast.stats.StatsTempMin;
import it.univpm.CovidForecast.stats.StatsTempPercepita;
import it.univpm.CovidForecast.stats.StatsUmidita;

/**
 * Classe contenente il controller dell'applicazione che gestisce le rotte delle
 * stats
 * 
 * @author domenicolaporta00
 *
 */
@RestController
public class StatsController extends Controller {

	@Autowired
	/**
	 * Oggetto StatsPressione utile per ricevere stats sulla pressione
	 */
	private StatsPressione sP = new StatsPressione();
	/**
	 * Oggetto StatsTemp utile per ricevere stats sulla temperatura
	 */
	private StatsTemp sT = new StatsTemp();
	/**
	 * Oggetto StatsTempMax utile per ricevere stats sulla temperatura massima
	 */
	private StatsTempMax sTM = new StatsTempMax();
	/**
	 * Oggetto StatsTempMin utile per ricevere stats sulla temperatura minima
	 */
	private StatsTempMin sTm = new StatsTempMin();
	/**
	 * Oggetto StatsTempPercepita utile per ricevere stats sulla temperatura
	 * percepita
	 */
	private StatsTempPercepita sTP = new StatsTempPercepita();
	/**
	 * Oggetto StatsUmidita utile per ricevere stats sull'umidità
	 */
	private StatsUmidita sU = new StatsUmidita();
	/**
	 * Oggetto TipoStatScanner utile per controllare se il tipo di stat dato in
	 * input è presente in quelli disponibili
	 */
	private TipoStatScanner tSS = new TipoStatScanner();

	/**
	 * Metodo che ritorna un Vector di CittaJSON contenente tutti gli oggetti con le
	 * stats desiderate secondo l'input ricevuto dall'utente
	 * 
	 * @param statsObj Stats
	 * @see it.univpm.CovidForecast.filters.FilterCity.getFromCityFilter
	 * @see it.univpm.CovidForecast.tools.ConvertitoreData.convertiDaString
	 * @see it.univpm.CovidForecast.filters.FilterData.getFromDataFilter
	 * @see it.univpm.CovidForecast.controller.StatsController.variabile
	 * @return Vector<CittaJSON>
	 * @throws Eccezioni personalizzate se ci sono errori di input nell'oggetto di
	 *                   tipo Stats statsObj
	 */
	@PostMapping("/stats")
	public Vector<CittaJSON> stats(@RequestBody Stats statsObj) {

		try {
			if (!cS.controlloCitta(statsObj.getCitta()))
				throw new EccezionePersonalizzata("Errore nell'input della città!");

			if (!vS.controlloVariabile(statsObj.getVariabile()))
				throw new EccezionePersonalizzata("Errore nell'input del tipo di parametro!");

			if (!tSS.controlloTipoStat(statsObj.getTipoStat()))
				throw new EccezionePersonalizzata("Errore di input del tipo di stat!");

			if (statsObj.getDataFin().charAt(2) != '-' || statsObj.getDataFin().charAt(5) != '-'
					|| statsObj.getDataInit().charAt(2) != '-' || statsObj.getDataInit().charAt(5) != '-'
					|| statsObj.getDataInit().charAt(10) != ' ' || statsObj.getDataFin().charAt(10) != ' '
					|| statsObj.getDataInit().charAt(13) != ':' || statsObj.getDataFin().charAt(13) != ':'
					|| statsObj.getDataInit().length() != 16 || statsObj.getDataFin().length() != 16)
				throw new EccezionePersonalizzata("Errore di input della data!");

		} catch (EccezionePersonalizzata e) {

			return EccezionePersonalizzata.getVCJError();
		}

		cJVect = new Vector<CittaJSON>();
		for (int i = 0; i < statsObj.getCitta().size(); i++) {
			/* Qui filtra per città */
			vettCitta = fC.getFromCityFilter(statsObj.getCitta().elementAt(i));
			/*
			 * Qui cambia il formato delle date da giorno-mese-anno a secondi passati dal
			 * 01/01/1970
			 */
			long dI = cD.convertiDaString(statsObj.getDataInit());
			long dF = cD.convertiDaString(statsObj.getDataFin());
			/* Qui filtra il vettore precedentemente filtrato per citta, per data */
			vettData = fD.getFromDataFilter(vettCitta, dI, dF);
			/*
			 * Qui crea un vettore e ci mette il massimo/minimo della statistica data in
			 * input
			 */
			Vector<MeteoCitta> mCVect1 = this.variabile(statsObj.getVariabile(), statsObj.getTipoStat(), vettData);
			/*
			 * Qui cambia il formato della data da secondi passati dal 01/01/1970 a
			 * giorno-mese-anno e aggiunge tutto ad un vettore di CittaJSON (con data
			 * formato giorno-mese-anno)
			 */
			cJVect.addAll(cCJ.getCittaJSON(mCVect1));
			/*
			 * Torna indietro e rifà tutto se nel parametro in entrata c'è più di una città
			 */
		}

		/*
		 * Ritorna il vettore finale filtrato per città, data e con la statistica
		 * desiderata
		 */
		return cJVect;
	}

	@GetMapping("/stats")
	public Vector<CittaJSON> stats(@RequestParam(value = "citta1") String citta1,
			@RequestParam(value = "citta2") String citta2, @RequestParam(value = "dataInit") long dataInit,
			@RequestParam(value = "dataFin") long dataFin, @RequestParam(value = "variabile") String variabile,
			@RequestParam(value = "tipoStat") String tipoStat) {

		cJVect = new Vector<CittaJSON>();
		String[] citta = new String[] { citta1, citta2 };

		for (int i = 0; i < citta.length; i++) {
			/* Qui filtra per città */
			vettCitta = fC.getFromCityFilter(citta[i]);
			/*
			 * Qui cambia il formato delle date da giorno-mese-anno a secondi passati dal
			 * 01/01/1970
			 */
			/* Qui filtra il vettore precedentemente filtrato per citta, per data */
			vettData = fD.getFromDataFilter(vettCitta, dataInit, dataFin);
			/*
			 * Qui crea un vettore e ci mette il massimo/minimo della statistica data in
			 * input
			 */
			Vector<MeteoCitta> mCVect1 = this.variabile(variabile, tipoStat, vettData);
			/*
			 * Qui cambia il formato della data da secondi passati dal 01/01/1970 a
			 * giorno-mese-anno e aggiunge tutto ad un vettore di CittaJSON (con data
			 * formato giorno-mese-anno)
			 */
			cJVect.addAll(cCJ.getCittaJSON(mCVect1));
			/*
			 * Torna indietro e rifà tutto se nel parametro in entrata c'è più di una città
			 */
		}

		/*
		 * Ritorna il vettore finale filtrato per città, data e con la statistica
		 * desiderata
		 */
		return cJVect;
	}

	/**
	 * Metodo che restituisce le stats desiderate, restituendo un oggetto MeteoCitta
	 * (formato data String). A seconda del var dato in input, parte una funzione
	 * che genera le stats di tale var
	 * 
	 * @param var String
	 * @param tipoStat String
	 * @param vectPerStats Vector<MeteoCitta>
	 * @return
	 */
	public Vector<MeteoCitta> variabile(String var, String tipoStat, Vector<MeteoCitta> vectPerStats) {

		switch (var) {

		case "pressione":
			return sP.getStats(tipoStat, vectPerStats);

		case "temp":
			return sT.getStats(tipoStat, vectPerStats);

		case "tempMax":
			return sTM.getStats(tipoStat, vectPerStats);

		case "tempMin":
			return sTm.getStats(tipoStat, vectPerStats);

		case "tempPercepita":
			return sTP.getStats(tipoStat, vectPerStats);

		case "umidita":
			return sU.getStats(tipoStat, vectPerStats);

		}
		return null;

	}

}
