package it.univpm.CovidForecast.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/***
 * 
 * Classe utile per tenere traccia dell'ore passsate nel datatabase
 * 
 * @author emanuelefrisi
 *
 */
@Entity
@Table(name = "ora")
public class Ora {

	/**
	 * Attributo id
	 */
	@Id
	private int id;
	
	/**
	 * Atrributo ora
	 */
	private int ora;
	
	/**
	 * Costruttore vuoto
	 */
	public Ora() {
		
	}
	
	/**
	 * 
	 * Costruttore che prende in ingresso tutti i parametri di questa classe
	 * 
	 * @param i id
	 * @param o ora
	 */
	public Ora(int i, int o) {
		this.id=i;
		this.ora=o;
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
	 * @param i
	 */
	public void setId(int i) {
		this.id=i;
	}
	
	/**
	 * Metodo getter dell'attributo ora
	 * 
	 * @return ora
	 */
	public int getOra() {
		return ora;
	}
	
	/**
	 * Metodo setter dell'attributo ora
	 * 
	 * @param o
	 */
	public void setOra(int o) {
		this.ora=o;
	}
	
}
