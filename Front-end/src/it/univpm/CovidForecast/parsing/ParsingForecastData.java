package it.univpm.CovidForecast.parsing;

import java.text.DecimalFormat;
import java.util.Vector;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ParsingForecastData {

	private Vector<Vector<String>> weather2D = new Vector<Vector<String>>();

	public Vector<Vector<String>> parsing(String chiamata) {

		try {
			JSONParser jP = new JSONParser();
			JSONObject jO = (JSONObject) jP.parse(chiamata);
			JSONArray jA = (JSONArray) jO.get("list");
			for (int i = 0; i < jA.size(); i++) {
				if ((i + 1) % 8 == 0) {
					Vector<String> weather1D = new Vector<String>();
					JSONObject jOList = (JSONObject) jA.get(i);
					JSONArray jAWeather = (JSONArray) jOList.get("weather");
					JSONObject jOWeather = (JSONObject) jAWeather.get(0);
					weather1D.add((String) jOWeather.get("description"));
					weather1D.add((String) jOWeather.get("icon"));
					JSONObject jOMain = (JSONObject) jOList.get("main");
					weather1D.add(new DecimalFormat("##.#").format((double) jOMain.get("temp")));
					weather1D.add(new DecimalFormat("##.#").format((double) jOMain.get("feels_like")));
					weather2D.add(weather1D);
				}
			}

		} catch (ParseException p) {
			System.out.println("Eccezione ParseException");
		}

		return weather2D;
		
	}

}