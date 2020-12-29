package it.univpm.CovidForecast.parsing;

import java.util.Vector;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.univpm.CovidForecast.model.ForecastCitta;
import it.univpm.CovidForecast.service.ForecastCittaService;

/**
 * 
 * @author emanuelefrisi
 *
 */
@Service
public class ParsingForecastData {

private long data;
	
	private String dataTxt;
	
	private String citta;
	
	private String nazione;
	
	private static int ora = 0;
	
	private long pressione;
	
	private Double temp;
	
	private Double tempMax;
	
	private Double tempMin;
	
	private Double tempPercepita;
	
	private long umidita;
	
	private ForecastCitta fC;
	private Vector<ForecastCitta> fCVector = new Vector<ForecastCitta>();
	@Autowired
	private ForecastCittaService fCS = new ForecastCittaService();
	
	public void parsing(Vector<String> cittaForecastData) {
		
		ora++;
		
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
			
		} catch(InterruptedException ex) {
	        Thread.currentThread().interrupt();
	    }
		
	}
	
}
