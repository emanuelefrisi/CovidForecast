package it.univpm.CovidForecast.model;

import java.util.Vector;

/**
 * 
 * Classe utile a descrivere l'input inserito dall'utente in FiltriController
 * 
 * @author domenicolaporta00
 *
 */
public class Filtri {

	/**
	 * Vettore contenente città
	 */
	private Vector<String> citta;
	/**
	 * Valore della data di inizio
	 */
	private String dataInit;
	/**
	 * Valore della data finale
	 */
	private String dataFin;
	/**
	 * Tipo di variabile
	 */
	private String variabile; //pressione, temperatura, tempMax, tempMin, temPercepita, umidita
	/**
	 * Valore iniziale della varibaile
	 */
	private Double valInit;
	/**
	 * Valore finale della variabile
	 */
	private Double valFin;

	/**
	 * 
	 * Costruttore che prende in ingresso tutti i parametri di questa classe
	 * 
	 * @param c citta
	 * @param dI datatInit
	 * @param dF dataFin
	 * @param var variabile
	 * @param vI valInit
	 * @param vF valFin
	 * 
	 */
	public Filtri(Vector<String> c, String dI, String dF, String var, Double vI, Double vF) {
		this.citta = c;
		this.dataInit = dI;
		this.dataFin = dF;
		this.variabile = var;
		this.valInit = vI;
		this.valFin = vF;
	}

	/**
	 * Metodo getter del vettore citta
	 * 
	 * @return citta
	 */
	public Vector<String> getCitta() {
		return citta;
	}

	/**
	 * Metodo setter del vettore citta
	 * 
	 * @param citta
	 */
	public void setCitta(Vector<String> citta) {
		this.citta = citta;
	}

	/**
	 * Metodo getter dell'attributo dataInit
	 * 
	 * @return dataInit
	 */
	public String getDataInit() {
		return dataInit;
	}

	/**
	 * Metodo setter dell'attributo dataInit
	 * 
	 * @param dataInit
	 */
	public void setDataInit(String dataInit) {
		this.dataInit = dataInit;
	}
	
	/**
	 * Metodo getter dell'attributo dataFin
	 * 
	 * @return dataFIn
	 */
	public String getDataFin() {
		return dataFin; 
	}

	/**
	 * Metodo setter dell'attributo dataFin
	 * 
	 * @param dataFin
	 */
	public void setDataFin(String dataFin) {
		this.dataFin = dataFin;
	}
	
	/**
	 * Metodo getter dell'attributo variabile
	 * 
	 * @return variabile
	 */
	public String getVariabile() {
		return variabile;
	}

	/**
	 * Metodo setter dell'attributo variabile
	 * 
	 * @param variabile
	 */
	public void setVariabile(String variabile) {
		this.variabile = variabile;
	}

	/**
	 * Metodo getter dell'attributo valInit
	 * 
	 * @return valInit
	 */
	public Double getValInit() {
		return valInit;
	}

	/**
	 * Metodo setter dell'attributo valInit
	 * 
	 * @param valInit
	 */
	public void setValInit(Double valInit) {
		this.valInit = valInit;
	}

	/**
	 * Metodo getter dell'attributo valFin
	 * 
	 * @return valFin
	 */
	public Double getValFin() {
		return valFin;
	}

	/**
	 * Metodo setter dell'attributo valFin
	 * 
	 * @param valFin
	 */
	public void setValFin(Double valFin) {
		this.valFin = valFin;
	}

}
