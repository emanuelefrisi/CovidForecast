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
@Table(name = "MeteoCitta")
public class MeteoCitta {
	/**
	 * Id della città
	 */
	@Id
	private long id;
	/**
	 * Nome della città
	 */
	private String citta;
	/**
	 * Data nella quale sono state fatte le misurazioni da OpenWeather(Unix Time Stamp)
	 */
	private long data;
	/**
	 * Prefisso internazionale
	 */
	private String nazione;
	/**
	 * Pressione atmosferica(misurata in ettopascal)
	 */
	private int pressione;
	/**
	 * Temperatura(misurata in Celsius)
	 */
	private double temp;
	/**
	 * Temperatura massima(misurata in Celsius)
	 */
	private double tempMax;
	/**
	 * Temperatura minima(misurata in Celsius)
	 */
	private double tempMin;
	/**
	 * Temperatura perpepita(misurata in Celsius)
	 */
	private double tempPercepita;
	/**
	 * Umidità in percentuale
	 */
	private int umidita;
	
	/**
	 * 
	 * Costruttore che prende in ingresso tutti i parametri di questa classe
	 * 
	 * @param i id
	 * @param c citta
	 * @param d data
	 * @param n nazione
	 * @param p pressione
	 * @param t temp
	 * @param tM tempMax
	 * @param tm tempMin
	 * @param tP tempPercepita
	 * @param u umidita
	 * 
	 */
	public MeteoCitta(int i, String c, long d, String n, int p, double t, double tM, double tm, double tP, int u) {
		this.id=i;
		this.citta=c;
		this.data=d;
		this.nazione=n;
		this.pressione=p;
		this.temp=t;
		this.tempMax=tM;
		this.tempMin=tm;
		this.tempPercepita=tP;
		this.umidita=u;
	}

	/**
	 * Metodo getter dell'attributo id
	 * 
	 * @return id
	 */
	public long getId() {
		return id;
	}

	/**
	 * Metodo setter dell'attributo id
	 * 
	 * @param id
	 */
	public void setId(long id) {
		this.id = id;
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
	public void setCitta(String citta) {
		this.citta = citta;
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
	public void setData(long data) {
		this.data = data;
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
	public void setNazione(String nazione) {
		this.nazione = nazione;
	}

	/**
	 * Metodo getter dell'attributo pressione
	 * 
	 * @return pressione
	 */
	public int getPressione() {
		return pressione;
	}

	/**
	 * Metodo setter dell'attributo pressione
	 * 
	 * @param pressione
	 */
	public void setPressione(int pressione) {
		this.pressione = pressione;
	}

	/**
	 * Metodo getter dell'attributo temp
	 * 
	 * @return temp
	 */
	public double getTemp() {
		return temp;
	}

	/**
	 * Metodo setter dell'attributo temp
	 * 
	 * @param temp
	 */
	public void setTemp(double temp) {
		this.temp = temp;
	}

	/**
	 * Metodo getter dell'attributo tempMax
	 * 
	 * @return temp
	 */
	public double getTempMax() {
		return tempMax;
	}

	/**
	 * Metodo setter dell'attributo tempMax
	 * 
	 * @param tempMax
	 */
	public void setTempMax(double tempMax) {
		this.tempMax = tempMax;
	}

	/**
	 * Metodo getter dell'attributo tempMin
	 * 
	 * @return tempMin
	 */
	public double getTempMin() {
		return tempMin;
	}

	/**
	 * Metodo setter dell'attributo tempMin
	 * 
	 * @param tempMin
	 */
	public void setTempMin(double tempMin) {
		this.tempMin = tempMin;
	}

	/**
	 * Metodo getter dell'attributo tempPercepita
	 * 
	 * @return tempPerpepita
	 */
	public double getTempPercepita() {
		return tempPercepita;
	}

	/**
	 * Metodo setter dell'attributo tempPercepita
	 * 
	 * @param tempPercepita
	 */
	public void setTempPercepita(double tempPercepita) {
		this.tempPercepita = tempPercepita;
	}

	/**
	 * Metodo getter dell'attributo umidita
	 * 
	 * @return umidita
	 */
	public int getUmidita() {
		return umidita;
	}

	/**
	 * Metodo setter dell'attributo umidita
	 * 
	 * @param umidita
	 */
	public void setUmidita(int umidita) {
		this.umidita = umidita;
	}
	
}
