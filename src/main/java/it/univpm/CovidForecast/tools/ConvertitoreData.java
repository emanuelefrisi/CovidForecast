package it.univpm.CovidForecast.tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

public class ConvertitoreData {

	private SimpleDateFormat sDF = new SimpleDateFormat("dd-MM-yyyy hh:mm");
	private Date data;
	private long dataUnix;
	
	public long convertiDaString(String dataStr) {
		
		try {
			data = sDF.parse(dataStr);
			dataUnix = data.getTime();
		
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "Attenzione! Il formato della data non è esatto."
					+ "\nFormato accettato: dd-MM-yyyy hh:mm", "CovidForecast", JOptionPane.WARNING_MESSAGE);
		}
		
		return dataUnix/1000;
		
	}
	
	public String covertiDaUnix(long dataUn) {
		
		data = new Date(dataUn*1000);
		return sDF.format(data);
		
	}
	
}
