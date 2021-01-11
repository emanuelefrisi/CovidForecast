package it.univpm.CovidForecast.model;

import java.util.Vector;

public class Stats {

	private Vector<String> citta;
	private String dataInit;
	private String dataFin;
	private String variabile;
	private String tipoStat;
	
	public Stats(Vector<String> c, String dI, String dF, String var, String tS) {
		this.citta=c;
		this.dataInit=dI;
		this.dataFin=dF;
		this.variabile=var;
		this.tipoStat=tS;
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
	public String getTipoStat() {
		return tipoStat;
	}
	public void setTipoStat(String tipoStat) {
		this.tipoStat = tipoStat;
	}
	
}
