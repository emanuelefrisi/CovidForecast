package it.univpm.CovidForecast.exception;

import java.util.Vector;

import it.univpm.CovidForecast.model.CittaJSON;

public class EccezioniPersonalizzate extends Exception {

	private static final long serialVersionUID = 1L;
	
	private static Vector<CittaJSON> VCJError;

	public EccezioniPersonalizzate() {
		super();
	}

	public EccezioniPersonalizzate(String messaggio) {
		VCJError = new Vector<CittaJSON>();
		CittaJSON cJError = new CittaJSON("01-01-1970 01:00", messaggio, messaggio, 0, null, null, null, null, 0);
		VCJError.add(cJError);
	}
	
	public static Vector<CittaJSON> getVCJError() {
		return VCJError;
	}

}
