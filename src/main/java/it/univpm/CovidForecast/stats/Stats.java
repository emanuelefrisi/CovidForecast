package it.univpm.CovidForecast.stats;

import java.util.Vector;

import it.univpm.CovidForecast.model.MeteoCitta;

/**
 * Classe madre da cui ereditano le sottoclassi utili per eseguire le varie
 * stats
 * 
 * @author domenicolaporta00
 *
 */
public class Stats {

	/**
	 * Oggetto MeteoCitta che contiene il massimo
	 */
	protected MeteoCitta mCMax;
	/**
	 * Oggetto MeteoCitta che contiene il minimo
	 */
	protected MeteoCitta mCMin;
	/**
	 * Vector di MeteoCitta che contiene gli oggetti desiderati dall'utente, secondo
	 * il tipo di stat dato in input dall'utente
	 */
	protected Vector<MeteoCitta> mCVect;

	/**
	 * Metodo che trova il tipo di statistica desiderata, data in input dall'utente
	 * 
	 * @param tipoStat     String
	 * @param vectPerStats Vector<MeteoCitta>
	 * @return mCVect
	 * 
	 */
	public Vector<MeteoCitta> getStats(String tipoStat, Vector<MeteoCitta> vectPerStats) {
		return mCVect;
	};

}
