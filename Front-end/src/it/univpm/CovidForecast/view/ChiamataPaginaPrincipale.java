package it.univpm.CovidForecast.view;

import java.util.Vector;

import javax.swing.JOptionPane;

import it.univpm.CovidForecast.api.ApiKeyData;
import it.univpm.CovidForecast.api.ChiamataMeteo;
import it.univpm.CovidForecast.api.GeoIpifyData;
import it.univpm.CovidForecast.exceptions.CFException;

public class ChiamataPaginaPrincipale {

	private ApiKeyData aKD = new ApiKeyData();
	private GeoIpifyData gID = new GeoIpifyData();
	private ChiamataMeteo cI = new ChiamataMeteo();

	private Vector<String> geo;
	Vector<Vector<String>> weather;

	public ChiamataPaginaPrincipale(String username) throws CFException {

		String apiKey = aKD.getApiKeys().elementAt(1);
		Vector<String> geo = gID.getLocation(apiKey);
		weather = cI.chiamata(geo.elementAt(1));
//		System.out.println(geo); controlli sui due vettori
//		System.out.println(weather);
		new CFPaginaPrincipale(username, geo, weather);
		
		JOptionPane.showMessageDialog(null, "Colori:\n"
				+ "Bianco: Tempertura\n"
				+ "Ciano: Temperatura minima\n"
				+ "Rosso: Temperatura massima\n"
				+ "Arancione: Temperatura percepita", "Legenda", JOptionPane.INFORMATION_MESSAGE);

	}

	public ChiamataPaginaPrincipale(String username, String citta) throws CFException {

		geo = new Vector<String>();
		weather = new Vector<Vector<String>>();
		weather = cI.chiamata(citta);
		
		geo.add(weather.elementAt(0).elementAt(5));
		geo.add(citta);
		
		
		System.out.println(geo);
		System.out.println(weather);
		new CFPaginaPrincipale(username, geo, weather);
		
	}

}