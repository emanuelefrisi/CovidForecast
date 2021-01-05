package it.univpm.CovidForecast.tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

public class ConvertitoreData {

	private SimpleDateFormat sDF = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
	private Date data;
	private long dataUnix;
	
	public long convertiDaStringa(String dataStr) {
		
		try {
			data = sDF.parse(dataStr);
			dataUnix = data.getTime();
		
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "Attenzione! Il formato della data non è esatto."
					+ "\nFormato accettato: dd-MM-yyyy hh:mm:ss", "CovidForecast", JOptionPane.WARNING_MESSAGE);
		}
		
		return dataUnix;
		
	}
	
	public String covertiDaUnix(long dataUn) {
		
		data = new Date(dataUn);
		return sDF.format(data);
		
	}
	
}
