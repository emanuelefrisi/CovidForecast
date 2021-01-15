package it.univpm.CovidForecast.controller;

import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.univpm.CovidForecast.exception.EccezioniPersonalizzate;
import it.univpm.CovidForecast.filters.FilterCity;
import it.univpm.CovidForecast.filters.FilterData;
import it.univpm.CovidForecast.model.CittaJSON;
import it.univpm.CovidForecast.model.MeteoCitta;
import it.univpm.CovidForecast.model.Stats;
import it.univpm.CovidForecast.scanner.CittaScanner;
import it.univpm.CovidForecast.scanner.TipoStatScanner;
import it.univpm.CovidForecast.scanner.VariabileScanner;
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

	private CittaScanner cS = new CittaScanner();
	private VariabileScanner vS = new VariabileScanner();
	private TipoStatScanner tSS = new TipoStatScanner();

	@PostMapping("/stats")
	public Vector<CittaJSON> stats(@RequestBody Stats statsObj) {

		try {
			if (!cS.controlloCitta(statsObj.getCitta()))
				throw new EccezioniPersonalizzate("Errore nell'input della città!");

			if (!vS.controlloVariabile(statsObj.getVariabile()))
				throw new EccezioniPersonalizzate("Errore nell'input del tipo di parametro!");

			if (!tSS.controlloTipoStat(statsObj.getTipoStat()))
				throw new EccezioniPersonalizzate("Errore di input del tipo di stat!");

			if (statsObj.getDataFin().charAt(2) != '-' || statsObj.getDataFin().charAt(5) != '-'
					|| statsObj.getDataInit().charAt(2) != '-' || statsObj.getDataInit().charAt(5) != '-'
					|| statsObj.getDataInit().charAt(10) != ' ' || statsObj.getDataFin().charAt(10) != ' '
					|| statsObj.getDataInit().charAt(13) != ':' || statsObj.getDataFin().charAt(13) != ':'
					|| statsObj.getDataInit().length() != 15 || statsObj.getDataFin().length() != 15)
				throw new EccezioniPersonalizzate("Errore di input della data!");

		} catch (EccezioniPersonalizzate e) {

			return EccezioniPersonalizzate.getVCJError();
		}

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
			vettCitta = filtroC.getFromCityFilter(citta[i]);
			/*
			 * Qui cambia il formato delle date da giorno-mese-anno a secondi passati dal
			 * 01/01/1970
			 */
			/* Qui filtra il vettore precedentemente filtrato per citta, per data */
			vettData = filtroD.getFromDataFilter(vettCitta, dataInit, dataFin);
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

		case "umidita":
			return sU.getStats(tipoStat, vectPerStats);

		default: {
			/*Vector<MeteoCitta> VMCError = new Vector<MeteoCitta>();
			MeteoCitta mCError = new MeteoCitta(0, "Errore di input del tipo di parametro",
					"Errore di input del tipo di parametro", 0, 0, null, null, null, null, 0);
			VMCError.add(mCError);
			return VMCError;*/
		}

		}
		return null;

	}

}
