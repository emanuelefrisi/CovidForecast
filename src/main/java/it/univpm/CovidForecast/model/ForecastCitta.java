package it.univpm.CovidForecast.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * Classe che descrive i valori che vengono salvati sul database riguardanti le chiamate previsionali ad OpenWeather
 * 
 * @author emanuelefrisi
 *
 */
@Entity
@Table(name = "forecast_citta")
public class ForecastCitta {

	/**
	 * Data nella quale sono state fatte le misurazioni(Unix Time Stamp)
	 */
	@Id
	private long data;
	
	/**
	 * Data a cui si riferisce la misurazione effettuata da OpenWeather
	 */
	private String dataTxt;
	
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
	
	/**
	 * Costruttore vuoto
	 */
	public ForecastCitta() {
		
	}
	
	/**
	 * 
	 * Costruttore che prende in ingresso tutti i parametri di questa classe
	 * 
	 * @param d data
	 * @param dT datatTxt
	 * @param c citta
	 * @param n nazione
	 * @param o ora
	 * @param p pressione
	 * @param t temp
	 * @param tM tempMax
	 * @param tm tempMin
	 * @param tP tempPercepita
	 * @param u umidita
	 * 
	 */
	public ForecastCitta(long d, String dT, String c, String n, int o, long p, Double t, Double tM, Double tm, Double tP, long u) {
		this.data=d;
		this.dataTxt=dT;
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
	 * Metodo getter dell'attributo dataTxt
	 * 
	 * @return datatTxt
	 */
	public String getDataTxt() {
		return dataTxt;
	}
	
	/**
	 * Metodo setter dell'attributo dataTxt
	 * 
	 * @param dT
	 */
	public void setDataTxt(String dT) {
		this.dataTxt = dT;
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
