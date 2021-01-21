package it.univpm.CovidForecast.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * Classe usata per gestire gli utenti delle GUI
 * 
 * @author emanuelefrisi
 *
 */
@Entity
@Table(name = "utente")
public class Utente {

	/**
	 * Attributo id
	 */
	@Id
	@GeneratedValue
	private int id;
	/**
	 * Username dell'utente
	 */
	private String username;
	/**
	 * Password dell'utente
	 */
	private String password;
	
	/**
	 * Costruttore vuoto
	 */
	public Utente() {
		
	}
	
	/**
	 * 
	 * Costruttore per creare nuovi utenti
	 * 
	 * @param u username
	 * @param p password
	 * 
	 */
	public Utente(String u, String p) {
		this.username=u;
		this.password=p;
	}

	/**
	 * Metodo getter dell'attributo id
	 * 
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Metodo setter dell'attributo id
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * Metodo getter dell'attributo username
	 * 
	 * @return username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Metodo setter dell'attributo username
	 * 
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Metodo getter dell'attributo password
	 * 
	 * @return password
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * Metodo setter dell'attributo password
	 * 
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
}
