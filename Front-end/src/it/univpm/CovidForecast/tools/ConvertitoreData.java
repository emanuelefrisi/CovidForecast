package it.univpm.CovidForecast.tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConvertitoreData {

	private SimpleDateFormat sDF = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
	private Date data;
	private long dataUnix;
	
	public String convertiDaUnix(String formato, long u) {
		
		sDF = new SimpleDateFormat(formato);
		
		String dataString;
		String giorno;
		
		data = new Date(u);
		giorno = this.traduciGiorno(data.toString().substring(0, 3));
		dataString = giorno + sDF.format(data);
		
		return dataString;
	}
	
	public long convertiDaString(String formato, String dataStr) {
		
		sDF = new SimpleDateFormat(formato);
		
		try {
			data = sDF.parse(dataStr);
			dataUnix = data.getTime();
		} catch (ParseException e) {
//			Eccezione
		}
		
		return dataUnix/1000;
		
	}
	
	public String traduciGiorno(String g) {
		
		String giorno = new String();
		
		switch(g) {
		case "Mon":
			giorno = "Lun ";
			break;
		case "Tue":
			giorno = "Mar ";
			break;
		case "Wed":
			giorno = "Mer ";
			break;
		case "Thu":
			giorno = "Gio ";
			break;
		case "Fri":
			giorno = "Ven ";
			break;
		case "Sat":
			giorno = "Sab ";
			break;
		case "Sun":
			giorno = "Dom ";
			break;
		}
		
		return giorno;
		
	}
	
}