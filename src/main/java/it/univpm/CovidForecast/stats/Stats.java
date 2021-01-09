package it.univpm.CovidForecast.stats;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;

import it.univpm.CovidForecast.model.MeteoCitta;
import it.univpm.CovidForecast.service.MeteoCittaService;

//@Service
public class Stats {
	
	@Autowired
	protected MeteoCittaService mCS;
	protected List<MeteoCitta> listaPerStats;
	protected MeteoCitta mCMax;
	protected MeteoCitta mCMin;
	
	public MeteoCitta getMax() {
		return mCMax;
	};
	
	public MeteoCitta getMin() {
		return mCMin;
	}

}
