package it.univpm.CovidForecast.parsing;

import java.util.Vector;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import it.univpm.CovidForecast.model.ForecastCitta;

/**
 * 
 * Classe figlia che effettua il parsing della chiamata ad OpenWeather riguardante i dati previsionali
 * 
 * @see it.univpm.CovidForecast.service.OraService
 * @see it.univpm.CovidForecast.service.ForecastCittaService
 * 
 * @author emanuelefrisi
 *
 */
@Service
public class ParsingForecastData extends ParsingData{
	
	/**
	 * Metodo override dove si effettua il parsing dei dati e poi vengono salvati tramite ForecastCittaService
	 */
	@Override
	public void parsing(Vector<String> cittaForecastData) {
		
		ora = oS.getOra().getOra();
		
		try {
			
			for(String s : cittaForecastData) {
				JSONParser jP = new JSONParser();
				JSONObject jO = (JSONObject) jP.parse(s);
				JSONArray jA = (JSONArray) jO.get("list");
				for(int i = 0; i<jA.size(); i++) {
					JSONObject jOList = (JSONObject) jA.get(i);
					JSONObject jOMain = (JSONObject) jOList.get("main");
					temp = Double.parseDouble(jOMain.get("temp").toString());
					tempPercepita = Double.parseDouble(jOMain.get("feels_like").toString());
					tempMin = Double.parseDouble(jOMain.get("temp_min").toString());
					tempMax = Double.parseDouble(jOMain.get("temp_max").toString());
					pressione = (long) jOMain.get("pressure");
					umidita = (long) jOMain.get("humidity");
					dataTxt = (String) jOList.get("dt_txt");
					JSONObject jOCitta = (JSONObject) jO.get("city");
					citta = (String) jOCitta.get("name");
					nazione = (String) jOCitta.get("country");
					data = System.currentTimeMillis()/1000;
					fC = new ForecastCitta(data, dataTxt, citta, nazione, ora, pressione, temp, tempMax, tempMin, tempPercepita, umidita);
					fCVector.add(fC);
					System.out.println("Secondo: " + fCVector.size());
					Thread.sleep(1000);
				}
			}
			
			fCS.salvaRecord(fCVector);
			
		} catch(ParseException p) {
			System.out.println("Eccezione ParseException");
		} catch(InterruptedException ex) {
	        Thread.currentThread().interrupt();
	    }
		
	}
	
}
