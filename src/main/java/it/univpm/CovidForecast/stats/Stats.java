package it.univpm.CovidForecast.stats;

import java.util.Vector;

import it.univpm.CovidForecast.model.MeteoCitta;

public class Stats {
	
	protected MeteoCitta mCMax;
	protected MeteoCitta mCMin;
	protected Vector<MeteoCitta> mCVect;
	
	public Vector<MeteoCitta> getStats(String tipoStat, Vector<MeteoCitta> vectPerStats) {
		return mCVect;
	};

}
