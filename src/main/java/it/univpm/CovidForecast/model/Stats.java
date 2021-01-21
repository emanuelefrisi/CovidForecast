package it.univpm.CovidForecast.model;

import java.util.Vector;

/**
 * 
 * Classe utile a descrivere l'input inserito dall'utente in StatsController
 * 
 * @author emanuelefrisi
 *
 */
public class Stats {

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
	 * Tipo di statistica
	 */
	private String tipoStat; //max, min, media, varianza

	/**
	 * 
	 * Costruttore che prende in ingresso tutti i parametri di questa classe
	 * 
	 * @param c citta
	 * @param dI dataInit
	 * @param dF dataFin
	 * @param var variabile
	 * @param tS tipoStat
	 * 
	 */
	public Stats(Vector<String> c, String dI, String dF, String var, String tS) {
		this.citta = c;
		this.dataInit = dI;
		this.dataFin = dF;
		this.variabile = var;
		this.tipoStat = tS;
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
	 * Metodo getter dell'attributo tipoStat
	 * 
	 * @return tipoStat
	 */
	public String getTipoStat() {
		return tipoStat;
	}

	/**
	 * Metodo setter dell'attributo tipoStat
	 * 
	 * @param tipoStat
	 */
	public void setTipoStat(String tipoStat) {
		this.tipoStat = tipoStat;
	}

}
