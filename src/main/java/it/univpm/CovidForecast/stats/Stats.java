package it.univpm.CovidForecast.stats;

//import java.util.List;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;

import it.univpm.CovidForecast.model.MeteoCitta;
import it.univpm.CovidForecast.service.MeteoCittaService;

public class Stats {
	
	@Autowired
	protected MeteoCittaService mCS;
//	protected List<MeteoCitta> listaPerStats;
	protected MeteoCitta mCMax;
	protected MeteoCitta mCMin;
	protected Vector<MeteoCitta> mCVect;
	
	public Vector<MeteoCitta> getStats(String tipoStat, Vector<MeteoCitta> vectPerStats) {
		return mCVect;
	};

}
