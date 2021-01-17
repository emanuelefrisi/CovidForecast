package it.univpm.CovidForecast.scanner;

import java.util.Vector;

/**
 * Classe utile per ottenere un Vector contenente i tipi di parametri sui quali
 * si possono eseguire stats e filtri e controllare se il parametro dato in
 * input dall'utente sia presente in tale Vector
 * 
 * @author
 *
 */
public class VariabileScanner {

	/**
	 * Vector contenente i tipi di parametri sui quali si possono eseguire stats e
	 * filtri
	 */
	Vector<String> variabili;

	/**
	 * Metodo che ritorna un Vector contenente i tipi di parametri sui quali si
	 * possono eseguire stats e filtri
	 * 
	 * @return Vector<String>
	 */
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

	/**
	 * Metodo che controlla se il tipo di parametro dato in input è presente tra
	 * quelli disponibili nel Vector precedentemente creato
	 * 
	 * @param variabile String
	 * @return boolean
	 */
	public boolean controlloVariabile(String variabile) {

		this.getVariabili();
		if (this.variabili.contains(variabile))
			return true;
		else
			return false;

	}

}
