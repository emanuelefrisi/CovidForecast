package it.univpm.CovidForecast.parsing;

import java.util.Vector;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import it.univpm.CovidForecast.model.MeteoCitta;
import it.univpm.CovidForecast.model.Ora;

/**
 * 
 * Classe figlia che effettua il parsing della chiamata ad OpenWeather riguardante i dati attuali
 * 
 * @see it.univpm.CovidForecast.service.OraService
 * @see it.univpm.CovidForecast.service.MeteoCittaService
 * 
 * @author emanuelefrisi
 *
 */
@Service
public class ParsingCurrentData extends ParsingData{
	
	/**
	 * Metodo override dove si effettua il parsing dei dati e poi vengono salvati tramite MeteoCittaService
	 */
	@Override
	public void parsing(Vector<String> cittaCurrentData) {
		
		ora = oS.getOra().getOra()+1;
		o = new Ora(oS.getOra().getId(), ora);
		oS.salvaRecord(o);
		
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
					mC = new MeteoCitta(data, citta, nazione, ora, pressione, temp, tempMax, tempMin, tempPercepita, umidita);
					mCS.salvaRecord(mC);
					Thread.sleep(1000);
				}
		} catch (ParseException p) {
			System.out.println("Eccezione ParseException");
		} catch(InterruptedException ex) {
	        Thread.currentThread().interrupt();
	    }
	}

}