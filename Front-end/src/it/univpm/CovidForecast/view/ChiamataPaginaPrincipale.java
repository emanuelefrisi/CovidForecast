package it.univpm.CovidForecast.view;

import java.util.Vector;

import it.univpm.CovidForecast.api.ApiKeyData;
import it.univpm.CovidForecast.api.ChiamataMeteo;
import it.univpm.CovidForecast.api.GeoIpifyData;

public class ChiamataPaginaPrincipale {

	private ApiKeyData aKD = new ApiKeyData();
	private GeoIpifyData gID = new GeoIpifyData();
	private ChiamataMeteo cI = new ChiamataMeteo();

	private Vector<String> geo;
	Vector<Vector<String>> weather;

	public ChiamataPaginaPrincipale(String username) {

//		String apiKey = aKD.getApiKeys().elementAt(1);
//		Vector<String> geo = gID.getLocation(apiKey);
		geo = new Vector<String>();
		geo.add("IT");
		geo.add("Lucera");
		weather = new Vector<Vector<String>>();
//		weather = cI.chiamata(geo.elementAt(1));
		weather = cI.chiamata("Lucera");
		System.out.println(geo);
		System.out.println(weather);
		new CFPaginaPrincipale(username, geo, weather);

	}

	public ChiamataPaginaPrincipale(String username, String citta) {

		geo = new Vector<String>();
		geo.add("IT");
		geo.add(citta);
		
		weather = new Vector<Vector<String>>();
		weather = cI.chiamata(geo.elementAt(1));
		System.out.println(geo);
		System.out.println(weather);
		new CFPaginaPrincipale(username, geo, weather);
		
	}

}