package it.univpm.CovidForecast.scanner;

import java.util.Vector;

public class VariabileScanner {

	Vector<String> variabili;

	public Vector<String> getVariabili() {

		variabili = new Vector<String>();
		variabili.add("pressione");
		variabili.add("temperatura");
		variabili.add("tempMax");
		variabili.add("tempMin");
		variabili.add("tempPercepita");
		variabili.add("umidita");
		return variabili;
	}

	public boolean controlloVariabile(String variabile) {

		this.getVariabili();
		if (this.variabili.contains(variabile))
			return true;
		else
			return false;

	}

}
