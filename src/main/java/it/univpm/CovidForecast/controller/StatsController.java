package it.univpm.CovidForecast.controller;

import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.univpm.CovidForecast.filters.FilterCity;
import it.univpm.CovidForecast.filters.FilterData;
import it.univpm.CovidForecast.model.CittaJSON;
import it.univpm.CovidForecast.model.MeteoCitta;
import it.univpm.CovidForecast.model.Stats;
import it.univpm.CovidForecast.stats.StatsPressione;
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
	private Vector<CittaJSON> cJVect;
	private Vector<MeteoCitta> vettCitta;
	private Vector<MeteoCitta> vettData;

	@PostMapping("/stats")
	public Vector<CittaJSON> stats(@RequestBody Stats statsObj) {

		cJVect = new Vector<CittaJSON>();
		for (int i = 0; i < statsObj.getCitta().size(); i++) {
			System.out.println(statsObj.getVariabile());
			System.out.println(statsObj.getTipoStat());
			System.out.println(statsObj.getCitta().elementAt(i));
			vettCitta = filtroC.getFromCityFilter(statsObj.getCitta().elementAt(i));
			long dI = cD.convertiDaString(statsObj.getDataInit());
			long dF = cD.convertiDaString(statsObj.getDataFin());
			vettData = filtroD.getFromDataFilter(vettCitta, dI, dF);
			Vector<MeteoCitta> mCVect1 = this.variabile(statsObj.getVariabile(), statsObj.getTipoStat(), vettData);
			cJVect.addAll(cCJ.getCittaJSON(mCVect1));
		}

		return cJVect;
	}

	public Vector<MeteoCitta> variabile(String var, String tipoStat, Vector<MeteoCitta> vectPerStats) {

		switch (var) {

		case "pressione":
			return sP.getStats(tipoStat, vectPerStats);

		}
		return null;

	}

}
