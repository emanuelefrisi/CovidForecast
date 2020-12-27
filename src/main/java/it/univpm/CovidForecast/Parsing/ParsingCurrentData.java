package it.univpm.CovidForecast.parsing;

import java.util.Vector;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.univpm.CovidForecast.model.MeteoCitta;
import it.univpm.CovidForecast.service.MeteoCittaService;

/**
 * 
 * @author emanuelefrisi
 *
 */
@Service
public class ParsingCurrentData {

	/**
	 * Ora di riferimento
	 */
	private static int ora;
	/**
	 * Data nella quale sono state fatte le misurazioni da OpenWeather(Unix Time Stamp)
	 */
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
	
	private MeteoCitta mC;
	@Autowired
	private MeteoCittaService mCS = new MeteoCittaService();
	
	public void parsing(Vector<String> cittaCurrentData) {
		
		ora++;
		
		try {	
				for(String s : cittaCurrentData) {
				JSONParser jP = new JSONParser();
				JSONObject jO = (JSONObject) jP.parse(s);
				JSONObject jOMain = (JSONObject) jO.get("main");
				temp = Double.parseDouble(jOMain.get("temp").toString());
				tempPercepita = Double.parseDouble(jOMain.get("feels_like").toString());
				tempMin = Double.parseDouble(jOMain.get("temp_min").toString());
				tempMax = Double.parseDouble(jOMain.get("temp_max").toString());
				pressione = (long) jOMain.get("pressure");
				umidita = (long) jOMain.get("humidity");
				JSONObject jOSys = (JSONObject) jO.get("sys");
				nazione = (String) jOSys.get("country");
				citta = (String) jO.get("name");
				data = System.currentTimeMillis()/1000;
				mC = new MeteoCitta(data, ora, citta, nazione, pressione, temp, tempMax, tempMin, tempPercepita, umidita);
				mCS.salvaRecord(mC);
				Thread.sleep(700);
				}
		} catch (ParseException p) {
			// eccezione da scrivere
		} catch(InterruptedException ex) {
	        Thread.currentThread().interrupt();
	    }
	}

}
