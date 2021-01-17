package it.univpm.CovidForecast.scanner;

import java.util.Vector;

/**
 * Classe utile per ottenere un Vector contenente i tipi di stats richiedibili
 * dall'utente e controllare se la stat data in input sia presente in tale
 * Vector
 * 
 * @author
 *
 */
public class TipoStatScanner {

	/**
	 * Vector contenente i tipi di stats richiedibili dall'utente
	 */
	Vector<String> tipiStats;

	/**
	 * Metodo che ritorna un Vector contenente i tipi di stats richiedibili
	 * dall'utente
	 * 
	 * @return Vector<String>
	 */
	public Vector<String> getTipiStats() {

		tipiStats = new Vector<String>();
		tipiStats.add("max");
		tipiStats.add("min");
		tipiStats.add("varianza");
		tipiStats.add("media");
		return tipiStats;
	}

	/**
	 * Metodo che controlla se il tipo di stat dato in input è presente tra
	 * quelli disponibili nel Vector precedentemente creato
	 * 
	 * @param tipoStat String
	 * @return boolean
	 */
	public boolean controlloTipoStat(String tipoStat) {

		this.getTipiStats();
		if (this.tipiStats.contains(tipoStat))
			return true;
		else
			return false;

	}

}
