package it.univpm.CovidForecast.scanner;

import java.util.Vector;

public class TipoStatScanner {

	Vector<String> tipiStats;

	public Vector<String> getTipiStats() {

		tipiStats = new Vector<String>();
		tipiStats.add("max");
		tipiStats.add("min");
		tipiStats.add("varianza");
		tipiStats.add("media");
		return tipiStats;
	}

	public boolean controlloTipoStat(String tipoStat) {

		this.getTipiStats();
		if (this.tipiStats.contains(tipoStat))
			return true;
		else
			return false;

	}

}
