package it.univpm.CovidForecast.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "forecast_citta")
public class ForecastCitta {

	@Id
	private long data;
	
	private String dataTxt;
	
	private String citta;
	
	private String nazione;
	
	private int ora;
	
	private long pressione;
	
	private Double temp;
	
	private Double tempMax;
	
	private Double tempMin;
	
	private Double tempPercepita;
	
	private long umidita;
	
	public ForecastCitta() {
		
	}
	
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
	
	public String getDataTxt() {
		return dataTxt;
	}
	
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
