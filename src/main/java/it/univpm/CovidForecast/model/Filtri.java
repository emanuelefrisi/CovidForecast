package it.univpm.CovidForecast.model;

import java.util.Vector;

public class Filtri {

	private Vector<String> citta;
	private String dataInit;
	private String dataFin;
	private String variabile;/* pressione, temperatura, temp max, temp min, temp percepita, umidità */
	private Double valInit_perDouble;
	private Double valFin_perDouble;
	private long valInit_per_long;
	private long valFin_per_long;

	public Filtri(Vector<String> c, String dI, String dF, String var, Double valInit, Double valFin) {
		this.citta = c;
		this.dataInit = dI;
		this.dataFin = dF;
		this.variabile = var;
		this.valInit_perDouble = valInit;
		this.valFin_perDouble = valFin;
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
	
	public Double getValInit_perDouble() {
		return valInit_perDouble;
	}

	public void setValInit_perDouble(Double valInit_perDouble) {
		this.valInit_perDouble = valInit_perDouble;
	}

	public Double getValFin_perDouble() {
		return valFin_perDouble;
	}

	public void setValFin_perDouble(Double valFin_perDouble) {
		this.valFin_perDouble = valFin_perDouble;
	}

//	public long getValInit_per_long() {
//		return valInit_per_long;
//	}
//
//	public void setValInit_per_long(long valInit_per_long) {
//		this.valInit_per_long = valInit_per_long;
//	}
//
//	public long getValFin_per_long() {
//		return valFin_per_long;
//	}
//
//	public void setValFin_per_long(long valFin_per_long) {
//		this.valFin_per_long = valFin_per_long;
//	}

}
