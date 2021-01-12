package it.univpm.CovidForecast.controller;

import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.univpm.CovidForecast.filters.FilterCity;
import it.univpm.CovidForecast.filters.FilterData;
import it.univpm.CovidForecast.model.CittaJSON;
import it.univpm.CovidForecast.model.MeteoCitta;
import it.univpm.CovidForecast.model.Stats;
import it.univpm.CovidForecast.stats.StatsPressione;
import it.univpm.CovidForecast.stats.StatsTemp;
import it.univpm.CovidForecast.stats.StatsTempMax;
import it.univpm.CovidForecast.stats.StatsTempMin;
import it.univpm.CovidForecast.stats.StatsTempPercepita;
import it.univpm.CovidForecast.stats.StatsUmidita;
import it.univpm.CovidForecast.tools.ConvertitoreData;
import it.univpm.CovidForecast.tools.CreaCittaJSON;

@RestController
public class StatsController {

	@Autowired
	private FilterCity filtroC = new FilterCity();
	private FilterData filtroD = new FilterData();
	private ConvertitoreData cD = new ConvertitoreData();
	private CreaCittaJSON cCJ = new CreaCittaJSON();
	private StatsPressione sP = new StatsPressione();
	private StatsTemp sT = new StatsTemp();
	private StatsTempMax sTM = new StatsTempMax();
	private StatsTempMin sTm = new StatsTempMin();
	private StatsTempPercepita sTP = new StatsTempPercepita();
	private StatsUmidita sU = new StatsUmidita();
	private Vector<CittaJSON> cJVect;
	private Vector<MeteoCitta> vettCitta;
	private Vector<MeteoCitta> vettData;

	@PostMapping("/stats")
	public Vector<CittaJSON> stats(@RequestBody Stats statsObj) {

		cJVect = new Vector<CittaJSON>();
		for (int i = 0; i < statsObj.getCitta().size(); i++) {
			/* Qui filtra per città */
			vettCitta = filtroC.getFromCityFilter(statsObj.getCitta().elementAt(i));
			/*
			 * Qui cambia il formato delle date da giorno-mese-anno a secondi passati dal
			 * 01/01/1970
			 */
			long dI = cD.convertiDaString(statsObj.getDataInit());
			long dF = cD.convertiDaString(statsObj.getDataFin());
			/* Qui filtra il vettore precedentemente filtrato per citta, per data */
			vettData = filtroD.getFromDataFilter(vettCitta, dI, dF);
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
			 * Torna indietro e rifà tutto se nel parametro in entrata c'è più di una
			 * città
			 */
		}

		/* Ritorna il vettore finale filtrato per città, data e con la statistica desiderata*/
		return cJVect;
	}

	public Vector<MeteoCitta> variabile(String var, String tipoStat, Vector<MeteoCitta> vectPerStats) {

		switch (var) {

		case "pressione":
			return sP.getStats(tipoStat, vectPerStats);

		case "temperatura":
			return sT.getStats(tipoStat, vectPerStats);

		case "tempMax":
			return sTM.getStats(tipoStat, vectPerStats);

		case "tempMin":
			return sTm.getStats(tipoStat, vectPerStats);

		case "tempPercepita":
			return sTP.getStats(tipoStat, vectPerStats);

		case "umidità":
			return sU.getStats(tipoStat, vectPerStats);

		}
		return null;

	}

}
