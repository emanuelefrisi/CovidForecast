package it.univpm.CovidForecast.exceptions;

import javax.swing.JOptionPane;

public class CFException extends Exception{

	private static final long serialVersionUID = 1L;

	public CFException() {
		super();
	}
	
	public CFException(String messaggio, String titolo, int tipo) {
		JOptionPane.showMessageDialog(null, messaggio, titolo, tipo);
	}
	
}