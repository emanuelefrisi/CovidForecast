package it.univpm.CovidForecast.exception;

import java.util.Vector;

import it.univpm.CovidForecast.model.CittaJSON;

public class EccezionePersonalizzata extends Exception {

	private static final long serialVersionUID = 1L;
	
	private static Vector<CittaJSON> VCJError;

	public EccezionePersonalizzata() {
		super();
	}

	public EccezionePersonalizzata(String messaggio) {
		VCJError = new Vector<CittaJSON>();
		CittaJSON cJError = new CittaJSON("01-01-1970 01:00", messaggio, messaggio, 0, null, null, null, null, 0);
		VCJError.add(cJError);
	}
	
	public static Vector<CittaJSON> getVCJError() {
		return VCJError;
	}

}
