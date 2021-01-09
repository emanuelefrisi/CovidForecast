package it.univpm.CovidForecast.controller;

import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import it.univpm.CovidForecast.model.MeteoCitta;
import it.univpm.CovidForecast.stats.StatsPressione;
import it.univpm.CovidForecast.stats.StatsTemp;
import it.univpm.CovidForecast.stats.StatsTempMax;
import it.univpm.CovidForecast.stats.StatsTempMin;
import it.univpm.CovidForecast.stats.StatsTempPercepita;
import it.univpm.CovidForecast.stats.StatsUmidita;

@RestController
public class StatsController {

	@Autowired
	private StatsPressione sP = new StatsPressione();
	@Autowired
	private StatsTemp sT = new StatsTemp();
	@Autowired
	private StatsTempMax sTM = new StatsTempMax();
	@Autowired
	private StatsTempMin sTm = new StatsTempMin();
	@Autowired
	private StatsTempPercepita sTP = new StatsTempPercepita();
	@Autowired
	private StatsUmidita sU = new StatsUmidita();

	@GetMapping("/statsPressione")
	public Vector<MeteoCitta> statsPressione() {

		Vector<MeteoCitta> mC = new Vector<MeteoCitta>();
		mC.add(sP.getMin());
		mC.add(sP.getMax());
		return mC;

	}

	@GetMapping("/statsTemp")
	public Vector<MeteoCitta> statsTemp() {

		Vector<MeteoCitta> mC = new Vector<MeteoCitta>();
		mC.add(sT.getMin());
		mC.add(sT.getMax());
		return mC;

	}

	@GetMapping("/statsTempMax")
	public Vector<MeteoCitta> statsTempMax() {

		Vector<MeteoCitta> mC = new Vector<MeteoCitta>();
		mC.add(sTM.getMin());
		mC.add(sTM.getMax());
		return mC;

	}

	@GetMapping("/statsTempMin")
	public Vector<MeteoCitta> statsTempMin() {

		Vector<MeteoCitta> mC = new Vector<MeteoCitta>();
		mC.add(sTm.getMin());
		mC.add(sTm.getMax());
		return mC;

	}

	@GetMapping("/statsTempPercepita")
	public Vector<MeteoCitta> statsTempPercepita() {

		Vector<MeteoCitta> mC = new Vector<MeteoCitta>();
		mC.add(sTP.getMin());
		mC.add(sTP.getMax());
		return mC;

	}

	@GetMapping("/statsUmidita")
	public Vector<MeteoCitta> statsUmidita() {

		Vector<MeteoCitta> mC = new Vector<MeteoCitta>();
		mC.add(sU.getMin());
		mC.add(sU.getMax());
		return mC;

	}

}
