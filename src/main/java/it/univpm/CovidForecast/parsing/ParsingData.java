package it.univpm.CovidForecast.parsing;

import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;

import it.univpm.CovidForecast.model.ForecastCitta;
import it.univpm.CovidForecast.model.MeteoCitta;
import it.univpm.CovidForecast.model.Ora;
import it.univpm.CovidForecast.service.ForecastCittaService;
import it.univpm.CovidForecast.service.MeteoCittaService;
import it.univpm.CovidForecast.service.OraService;

/**
 * 
 * @author emanuelefrisi
 *
 */
public class ParsingData {

	/**
	 * Data nella quale sono state fatte le misurazioni da OpenWeather(Unix Time Stamp)
	 */
	protected long data;
	/**
	 * Data alla quale si riferisce l'oggetto JSON di riferimento
	 */
	protected String dataTxt;
	/**
	 * Nome della città
	 */
	protected String citta;
	/**
	 * Prefisso internazionale
	 */
	protected String nazione;
	/**
	 * Ora di riferimento
	 */
	protected int ora;
	/**
	 * Pressione atmosferica(misurata in ettopascal)
	 */
	protected long pressione;
	/**
	 * Temperatura(misurata in Celsius)
	 */
	protected Double temp;
	/**
	 * Temperatura massima(misurata in Celsius)
	 */
	protected Double tempMax;
	/**
	 * Temperatura minima(misurata in Celsius)
	 */
	protected Double tempMin;
	/**
	 * Temperatura perpepita(misurata in Celsius)
	 */
	protected Double tempPercepita;
	/**
	 * Umidità in percentuale
	 */
	protected long umidita;	
	
	protected Ora o;
	protected MeteoCitta mC;
	protected ForecastCitta fC;
	protected Vector<ForecastCitta> fCVector = new Vector<ForecastCitta>();
	@Autowired
	protected MeteoCittaService mCS = new MeteoCittaService();
	@Autowired
	protected ForecastCittaService fCS = new ForecastCittaService();
	@Autowired
	protected OraService oS = new OraService();
	
	public void parsing(Vector<String> cittaData) {
		
	}
	
}
