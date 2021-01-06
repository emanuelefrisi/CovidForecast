package it.univpm.CovidForecast.stats;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import it.univpm.CovidForecast.model.MeteoCitta;
import it.univpm.CovidForecast.service.MeteoCittaService;

public class Stats {
	
	@Autowired
	protected MeteoCittaService mCS;
	protected List<MeteoCitta> listaPerStats = mCS.getMeteoCittaFromDB();
	protected MeteoCitta mCMax;
	protected MeteoCitta mCMin;
	
	public MeteoCitta getMax() {
		return mCMax;
	};
	
	public MeteoCitta getMin() {
		return mCMin;
	}

}
