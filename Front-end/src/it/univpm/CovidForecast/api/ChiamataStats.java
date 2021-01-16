package it.univpm.CovidForecast.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JOptionPane;

import it.univpm.CovidForecast.exceptions.CFException;
import it.univpm.CovidForecast.parsing.ParsingStats;
import it.univpm.CovidForecast.tools.ConvertitoreData;

public class ChiamataStats {

	private ConvertitoreData cD = new ConvertitoreData();
	private ParsingStats pS;
	private String dati;
	
	public String getStats(String citta1, String citta2, String dI, String dF, String variabile, String tipoStat) {
		
		pS = new ParsingStats();
		
		String formato = "dd-MM-yyyy HH:mm";

		try {

			if(dI.length()<formato.length() || dI.length()>formato.length() || dF.length()<formato.length() || dF.length()>formato.length())
				throw new CFException("Formato della data errato\ndd-MM-yyyy HH:mm", "CovidForecast", JOptionPane.ERROR_MESSAGE);
			
			long dataInit = cD.convertiDaString(formato, dI);
			long dataFin = cD.convertiDaString(formato, dF);
			URL url = new URL("http://localhost:8080/stats?citta1=" + citta1 + "&citta2=" + citta2 + "&dataInit=" + dataInit + "&dataFin=" +
					 dataFin + "&variabile=" + variabile + "&tipoStat=" + tipoStat);
			HttpURLConnection c = (HttpURLConnection) url.openConnection();
			BufferedReader input = new BufferedReader(new InputStreamReader(c.getInputStream()));
			dati = pS.parsing(input.readLine());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CFException g) {
			
		}
		
		return dati;
		
	}
	
}