package it.univpm.CovidForecast.tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import javax.swing.JOptionPane;

import it.univpm.CovidForecast.exceptions.CFException;

public class Credenziali {

public boolean compara(String username, String password) {
		
		boolean flagLogin = false;
		
		try {
			
			if(username.equals("") || password.equals(""))
				throw new CFException("Riempire tutti i campi!", "CovidForecast", JOptionPane.WARNING_MESSAGE);
			
			URL url = new URL("http://localhost:8080/compara?username=" + username + "&password=" + password);
			HttpURLConnection c = (HttpURLConnection) url.openConnection();
			Scanner input = new Scanner(new BufferedReader(new InputStreamReader(c.getInputStream())));
			boolean flagUser = input.nextBoolean();
			boolean flagPass = input.nextBoolean();
			input.close();
			
			if(flagUser) {
				if(flagPass) {
					flagLogin = true;
					throw new CFException("Login effettuato con successo!", "CovidForecast", JOptionPane.INFORMATION_MESSAGE);
				}
				else
					throw new CFException("Login negato! Password errata!", "CovidForecast", JOptionPane.ERROR_MESSAGE);
			}
			else
				throw new CFException("Login negato! L'utente non risulta registrato", "CovidForecast", JOptionPane.ERROR_MESSAGE);
			
		} catch (MalformedURLException e) {
			System.out.println("Eccezione MalformedURLException");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Eccezione IOException");
			e.printStackTrace();
		} catch (CFException e) {
			
		}
		return flagLogin;
		
	}
	
	public boolean salva(String username, String password, String password2) {
		boolean flagReg = false;
		
		
		try {
			
			if(username.equals("") || password.equals("") || password2.equals(""))
				throw new CFException("Riempire tutti i campi!", "CovidForecast", JOptionPane.WARNING_MESSAGE);
			
			if(!password.equals(password2))
				throw new CFException("Le password non corrispondono!", "CovidForecast", JOptionPane.WARNING_MESSAGE);
			
			URL url = new URL("http://localhost:8080/salva?username=" + username + "&password=" + password);
			HttpURLConnection c = (HttpURLConnection) url.openConnection();
			Scanner input = new Scanner(new BufferedReader(new InputStreamReader(c.getInputStream())));
			boolean flagUser = input.nextBoolean();
			input.close();
			
			if(flagUser) {
				flagReg = true;
				throw new CFException("Registrazione effettuata con successo!", "CovidForecast", JOptionPane.INFORMATION_MESSAGE);
			}
			else
				throw new CFException("Nome utente già esistente!", "CovidForecast", JOptionPane.WARNING_MESSAGE);
			
		} catch (MalformedURLException e) {
			System.out.println("Eccezione MalformedURLException");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Eccezione IOException");
			e.printStackTrace();
		} catch (CFException e) {
			
		}
		
		return flagReg;
		
	}
	
}
