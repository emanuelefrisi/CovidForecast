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
import it.univpm.CovidForecast.filters.FilterFL;
import it.univpm.CovidForecast.filters.FilterHumidity;
import it.univpm.CovidForecast.filters.FilterNation;
import it.univpm.CovidForecast.filters.FilterPressure;
import it.univpm.CovidForecast.filters.FilterTemperature;
import it.univpm.CovidForecast.model.CittaJSON;
import it.univpm.CovidForecast.model.Filtri;
import it.univpm.CovidForecast.model.MeteoCitta;

@RestController
public class FiltriController {

	@Autowired
	private FilterCity fC = new FilterCity();
	@Autowired
	private FilterData fD = new FilterData();
	@Autowired
	private FilterFL fFL = new FilterFL();
	@Autowired
	private FilterHumidity fH = new FilterHumidity();
	@Autowired
	private FilterNation fN = new FilterNation();
	@Autowired
	private FilterPressure fP = new FilterPressure();
	@Autowired
	private FilterTemperature fT = new FilterTemperature();
	private Vector<CittaJSON> cJVect;
	
	@PostMapping
	public Vector<CittaJSON> filtri(@RequestBody Filtri filtriObj) {
		
		cJVect = new Vector<CittaJSON>();
		
		/*Da completare*/
		
		return cJVect;
		
	}
	
	public Vector<MeteoCitta> variabile(String var, Vector<MeteoCitta> vectPerStats) {

		switch (var) {

		case "pressione":
			return fP.getFromPressureFilter(0, 0);

		case "temperatura":
			return fT.getFromTemperatureFilter(null, null);

		case "tempPercepita":
			return fFL.getFromPTemperatureFilter(null, null);

		case "umidità":
			return fH.getFromHumidityFilter(0, 0);

		}
		return null;

	}

	@GetMapping("/filterCity")
	public Vector<MeteoCitta> filterCity(@RequestParam(name = "citta", defaultValue = "") String citta) {

		return fC.getFromCityFilter(citta);

	}

//	@GetMapping("/filterData")
//	public Vector<MeteoCitta> filterData(@RequestParam(name = "dataInit") long dataInit,
//			@RequestParam(name = "dataFin") long dataFin) {
//
//		return fD.getFromDataFilter(dataInit, dataFin);
//
//	}

	@GetMapping("/filterFL")
	public Vector<MeteoCitta> filterFL(@RequestParam(name = "TPInit") Double TPInit,
			@RequestParam(name = "TPFin") Double TPFin) {

		return fFL.getFromPTemperatureFilter(TPInit, TPFin);

	}

	@GetMapping("/filterHumidity")
	public Vector<MeteoCitta> filterHumidity(@RequestParam(name = "umiditaInit") long umiditaInit,
			@RequestParam(name = "umiditaFin") long umiditaFin) {

		return fH.getFromHumidityFilter(umiditaInit, umiditaFin);

	}

	@GetMapping("/filterNation")
	public Vector<MeteoCitta> filterNation(@RequestParam(name = "nazione", defaultValue = "") String nazione) {

		return fN.getFromNationFilter(nazione);

	}

	@GetMapping("/filterPressure")
	public Vector<MeteoCitta> filterPressure(@RequestParam(name = "pressioneInit") long pressioneInit,
			@RequestParam(name = "pressioneFin") long pressioneFin) {

		return fP.getFromPressureFilter(pressioneInit, pressioneFin);

	}

	@GetMapping("/filterTemperature")
	public Vector<MeteoCitta> filterTemperature(@RequestParam(name = "tempInit") Double tempInit,
			@RequestParam(name = "tempFin") Double tempFin) {

		return fT.getFromTemperatureFilter(tempInit, tempFin);

	}

}
