package it.univpm.CovidForecast.tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

/**
 * 
 * Classe capace di convertire la data sia da una stringa che da formato unix
 * 
 * @author emanuelefrisi
 *
 */
public class ConvertitoreData {

	/**
	 * Oggetto che permette la formattazione della data
	 */
	private SimpleDateFormat sDF = new SimpleDateFormat("dd-MM-yyyy HH:mm");
	/**
	 * Oggetto per rappresentare uno specifico formato di data
	 */
	private Date data;
	/**
	 * Variabile per l'istanziamento della data in formato unix
	 */
	private long dataUnix;
	
	/**
	 * 
	 * Metodo che consente di trasformare una data da stringa in formato unix
	 * 
	 * @param dataStr
	 * @return data in formato unix
	 */
	public long convertiDaString(String dataStr) {
		
		try {
			data = sDF.parse(dataStr);
			dataUnix = data.getTime();
		
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "Attenzione! Il formato della data non è esatto."
					+ "\nFormato accettato: dd-MM-yyyy HH:mm", "CovidForecast", JOptionPane.WARNING_MESSAGE);
		}
		
		return dataUnix/1000;
		
	}
	
	/**
	 * 
	 * Metodo che consente di trasformare una data dal formato unix ad una stringa
	 * 
	 * @param dataUn
	 * @return data in formato stringa
	 */
	public String convertiDaUnix(long dataUn) {
		
		data = new Date(dataUn*1000);
		return sDF.format(data);
		
	}
	
}
