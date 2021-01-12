package it.univpm.CovidForecast.model;

import java.util.Vector;

public class Filtri {

	private Vector<String> citta;
	private String dataInit;
	private String dataFin;
	private String variabile;/* pressione, temperatura, temp max, temp min, temp percepita, umidità */

	public Filtri(Vector<String> c, String dI, String dF, String var) {
		this.citta = c;
		this.dataInit = dI;
		this.dataFin = dF;
		this.variabile = var;
	}

	public Vector<String> getCitta() {
		return citta;
	}

	public void setCitta(Vector<String> citta) {
		this.citta = citta;
	}

	public String getDataInit() {
		return dataInit;
	}

	public void setDataInit(String dataInit) {
		this.dataInit = dataInit;
	}

	public String getDataFin() {
		return dataFin;
	}

	public void setDataFin(String dataFin) {
		this.dataFin = dataFin;
	}

	public String getVariabile() {
		return variabile;
	}

	public void setVariabile(String variabile) {
		this.variabile = variabile;
	}

}
