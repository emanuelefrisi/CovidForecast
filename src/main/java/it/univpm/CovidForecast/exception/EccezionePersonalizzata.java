package it.univpm.CovidForecast.exception;

import java.util.Vector;

import it.univpm.CovidForecast.model.CittaJSON;

/**
 * 
 * Classe che fa da eccezione personalizzata
 * 
 * @author domenicolaporta00
 *
 */
public class EccezionePersonalizzata extends Exception {

	private static final long serialVersionUID = 1L;
	
	private static Vector<CittaJSON> VCJError;

	public EccezionePersonalizzata() {
		super();
	}

	/**
	 *
	 * Costruttore che crea un oggetto CittaJSON e lo aggiunge ad un vettore. Prende in ingresso un messaggio 
	 * 
	 * @param messaggio
	 * 
	 */
	public EccezionePersonalizzata(String messaggio) {
		VCJError = new Vector<CittaJSON>();
		CittaJSON cJError = new CittaJSON("01-01-1970 01:00", messaggio, messaggio, 0, null, null, null, null, 0);
		VCJError.add(cJError);
	}
	
	/**
	 * 
	 * Metodo che ritorna un vettore di CittaJSON con elementi aggiunti dal costruttore
	 * 
	 * @return VCJError
	 * 
	 */
	public static Vector<CittaJSON> getVCJError() {
		return VCJError;
	}

}
