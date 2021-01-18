package it.univpm.CovidForecast.parsing;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ParsingStats {

	private String data, citta, nazione, dati;
	private long pressione, umidita;
	private Double temp, tempMax, tempMin, tempPercepita, valore;
	
	public String parsing(String chiamata) {
		
		this.dati = "";
		
		try {
			JSONParser jP = new JSONParser();
			JSONArray jA = (JSONArray) jP.parse(chiamata);
			for(int i = 0; i<jA.size(); i++) {
				JSONObject jO = (JSONObject) jA.get(i);
				data = (String) jO.get("data");
				citta = (String) jO.get("citta");
				nazione = (String) jO.get("nazione");
				pressione = (long) jO.get("pressione");
				temp = Double.parseDouble(jO.get("temp").toString());
				tempMax = Double.parseDouble(jO.get("tempMax").toString());
				tempMin = Double.parseDouble(jO.get("tempMin").toString());
				tempPercepita = Double.parseDouble(jO.get("tempPercepita").toString());
				umidita = (long) jO.get("umidita");	
				this.toString();
			}
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dati;
		
	}
	
	public String parsingAlternativo(String chiamata, String variabile) {
		
		this.dati = "";
		
		try {
			JSONParser jP = new JSONParser();
			JSONArray jA = (JSONArray) jP.parse(chiamata);
			for(int i = 0; i<jA.size(); i++) {
				JSONObject jO = (JSONObject) jA.get(i);
				data = (String) jO.get("data");
				citta = (String) jO.get("citta");
				nazione = (String) jO.get("nazione");
				valore = Double.parseDouble(jO.get(variabile).toString());
				this.toStringAlternativo(variabile);
			}
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dati;
		
	}
	
	public String toString() {
			
			dati += "Citt�: " + citta + ", " + nazione + "\n\nData: " + data + "\nPressione: " + pressione + " hPa\nTemperatura: " + temp +
					"�C\nTemperatura massima: " + tempMax + "�C\nTemperatura minima: " + tempMin + "�C\nTemperatura percepita: " + tempPercepita +
					"�C\nUmidit�: " + umidita + "%\n\n";
		
		return dati;
		
	}
	
	public String toStringAlternativo(String variabile) {
		
		String unit;
		
		if(variabile.equals("pressione"))
			unit = "hPa";
		else if(variabile.equals("umidita"))
			unit = "%";
		else
			unit = "�C";
			
		dati += "Citt�: " + citta + ", " + nazione + "\n\nData: " + data + "\nValore: " + valore + " " + unit + "\n\n";
		
		return dati;
		
	}
	
}