package it.univpm.CovidForecast.Parsing;

import java.util.Vector;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import it.univpm.CovidForecast.api.OpenWeatherCurrentData;
import it.univpm.CovidForecast.model.MeteoCitta;
import it.univpm.CovidForecast.service.MeteoCittaService;

/**
 * 
 * @author emanuelefrisi
 *
 */

public class ParsingCurrentData {

	/**
	 * Id della città
	 */
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
	private long pressione;
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
	private long umidita;
	
	private OpenWeatherCurrentData oW = new OpenWeatherCurrentData();
	Vector<String> chiamate = new Vector<String>();
	MeteoCitta mC;
	MeteoCittaService mCS;
	
	public void parsing() {
		
		chiamate = oW.getCurrentData();
		
		try {		
				for(String s : chiamate) {
				JSONParser jP = new JSONParser();
				JSONObject jO = (JSONObject) jP.parse(s);
				JSONObject jOMain = (JSONObject) jO.get("main");
				temp = (double) jOMain.get("temp");
				tempPercepita = (double) jOMain.get("feels_like");
				tempMin = (double) jOMain.get("temp_min");
				tempMax = (double) jOMain.get("temp_max");
				pressione = (long) jOMain.get("pressure");
				umidita = (long) jOMain.get("umidity");
				data = (long) jO.get("dt");
				JSONObject jOSys = (JSONObject) jO.get("sys");
				nazione = (String) jOSys.get("country");
				id = (long) jO.get("id");
				citta = (String) jO.get("name");
				mC = new MeteoCitta(id, citta, data, nazione, pressione, temp, tempMax, tempMin, tempPercepita, umidita);
				mCS.salvaRecord(mC);
				}
		} catch (ParseException p) {
			// eccezione da scrivere
		}
	}

}
