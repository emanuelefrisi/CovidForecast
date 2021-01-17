package it.univpm.CovidForecast.parsing;

import java.text.DecimalFormat;
import java.util.Vector;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ParsingCurrentData {

	private Vector<String> weather = new Vector<String>();
	
	public Vector<String> parsing(String chiamata) {

		try {
			JSONParser jP = new JSONParser();
			JSONObject jO = (JSONObject) jP.parse(chiamata);
			JSONArray jA = (JSONArray) jO.get("weather");
			JSONObject jOWeather = (JSONObject) jA.get(0);
			weather.add((String) jOWeather.get("description"));
			weather.add((String) jOWeather.get("icon"));
			JSONObject jOMain = (JSONObject) jO.get("main");
			weather.add(new DecimalFormat("##.#").format((Double.parseDouble(jOMain.get("temp").toString()))));
			weather.add(new DecimalFormat("##.#").format((Double.parseDouble(jOMain.get("temp_min").toString()))));
			weather.add(new DecimalFormat("##.#").format((Double.parseDouble(jOMain.get("temp_max").toString()))));
			JSONObject jOSys = (JSONObject) jO.get("sys");
			weather.add((String) jOSys.get("country"));
			
		} catch (ParseException p) {
			System.out.println("Eccezione ParseException");
		}
		
		return weather;
		
	}

}