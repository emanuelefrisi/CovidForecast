package it.univpm.CovidForecast.parsing;

import java.util.Vector;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ParsingDati {

	private String[] citta = new String[] {"Ancona", "Cagliari", "Firenze", "Foggia", "Milano", "Napoli", "Palermo", "Perugia", "Torino", "Venezia"};
	private Vector<String> dati;
	
	public Vector<String> parsing(String chiamata){
		
		dati = new Vector<String>();
		
		try {
			JSONParser jP = new JSONParser();
			JSONObject jO = (JSONObject) jP.parse(chiamata);
			for(int i = 0; i<citta.length; i++) {
				String covid = (String) jO.get(citta[i]);
				dati.add(citta[i] + ", " + covid);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dati;
		
	}
	
}
