package it.univpm.CovidForecast.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * Classe che descrive i valori che vengono salvati sul database
 * 
 * @author emanuelefrisi
 *
 */

@Entity
@Table(name = "meteo_citta")
public class MeteoCitta {
	/**
	 * Data nella quale sono state fatte le misurazioni(Unix Time Stamp)
	 */
	@Id
	private long data;
	/**
	 * Nome della città
	 */
	private String citta;
	/**
	 * Prefisso internazionale
	 */
	private String nazione;
	/**
	 * Ora di riferimento
	 */
	private int ora;
	/**
	 * Pressione atmosferica(misurata in ettopascal)
	 */
	private long pressione;
	/**
	 * Temperatura(misurata in Celsius)
	 */
	private Double temp;
	/**
	 * Temperatura massima(misurata in Celsius)
	 */
	private Double tempMax;
	/**
	 * Temperatura minima(misurata in Celsius)
	 */
	private Double tempMin;
	/**
	 * Temperatura perpepita(misurata in Celsius)
	 */
	private Double tempPercepita;
	/**
	 * Umidità in percentuale
	 */
	private long umidita;
	
	public MeteoCitta() {
		
	}
	
	/**
	 * 
	 * Costruttore che prende in ingresso tutti i parametri di questa classe
	 * 
	 * @param o ora
	 * @param d data
	 * @param c citta
	 * @param n nazione
	 * @param p pressione
	 * @param t temp
	 * @param tM tempMax
	 * @param tm tempMin
	 * @param tP tempPercepita
	 * @param u umidita
	 * 
	 */
	public MeteoCitta(long d, String c, String n, int o, long p, Double t, Double tM, Double tm, Double tP, long u) {
		this.data=d;
		this.citta=c;
		this.nazione=n;
		this.ora=o;
		this.pressione=p;
		this.temp=t;
		this.tempMax=tM;
		this.tempMin=tm;
		this.tempPercepita=tP;
		this.umidita=u;
	}

	/**
	 * Metodo getter dell'attributo citta
	 * 
	 * @return citta
	 */
	public long getData() {
		return data;
	}
	
	/**
	 * Metodo setter dell'attributo data
	 * 
	 * @param data
	 */
	public void setData(long d) {
		this.data = d;
	}
	
	/**
	 * Metodo getter dell'attributo citta
	 * 
	 * @return citta
	 */
	public String getCitta() {
		return citta;
	}

	/**
	 * Metodo setter dell'attributo citta
	 * 
	 * @param citta
	 */
	public void setCitta(String c) {
		this.citta = c;
	}

	/**
	 * Metodo getter dell'attributo nazione
	 * 
	 * @return nazione
	 */
	public String getNazione() {
		return nazione;
	}

	/**
	 * Metodo setter dell'attributo nazione
	 * 
	 * @param nazione
	 */
	public void setNazione(String n) {
		this.nazione = n;
	}

	public int getOra() {
		return ora;
	}

	public void setOra(int o) {
		this.ora=o;
	}
	
	/**
	 * Metodo getter dell'attributo pressione
	 * 
	 * @return pressione
	 */
	public long getPressione() {
		return pressione;
	}

	/**
	 * Metodo setter dell'attributo pressione
	 * 
	 * @param pressione
	 */
	public void setPressione(long p) {
		this.pressione = p;
	}

	/**
	 * Metodo getter dell'attributo temp
	 * 
	 * @return temp
	 */
	public Double getTemp() {
		return temp;
	}

	/**
	 * Metodo setter dell'attributo temp
	 * 
	 * @param temp
	 */
	public void setTemp(Double t) {
		this.temp = t;
	}

	/**
	 * Metodo getter dell'attributo tempMax
	 * 
	 * @return temp
	 */
	public Double getTempMax() {
		return tempMax;
	}

	/**
	 * Metodo setter dell'attributo tempMax
	 * 
	 * @param tempMax
	 */
	public void setTempMax(Double tM) {
		this.tempMax = tM;
	}

	/**
	 * Metodo getter dell'attributo tempMin
	 * 
	 * @return tempMin
	 */
	public Double getTempMin() {
		return tempMin;
	}

	/**
	 * Metodo setter dell'attributo tempMin
	 * 
	 * @param tempMin
	 */
	public void setTempMin(Double tm) {
		this.tempMin = tm;
	}

	/**
	 * Metodo getter dell'attributo tempPercepita
	 * 
	 * @return tempPerpepita
	 */
	public Double getTempPercepita() {
		return tempPercepita;
	}

	/**
	 * Metodo setter dell'attributo tempPercepita
	 * 
	 * @param tempPercepita
	 */
	public void setTempPercepita(Double tP) {
		this.tempPercepita = tP;
	}

	/**
	 * Metodo getter dell'attributo umidita
	 * 
	 * @return umidita
	 */
	public long getUmidita() {
		return umidita;
	}

	/**
	 * Metodo setter dell'attributo umidita
	 * 
	 * @param umidita
	 */
	public void setUmidita(long u) {
		this.umidita = u;
	}
	
}
