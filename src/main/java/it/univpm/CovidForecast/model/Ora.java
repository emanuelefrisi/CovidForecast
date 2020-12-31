package it.univpm.CovidForecast.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ora")
public class Ora {

	@Id
	private int id;
	
	private int ora;
	
	public Ora() {
		
	}
	
	public Ora(int i, int o) {
		this.id=i;
		this.ora=o;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int i) {
		this.id=i;
	}
	
	public int getOra() {
		return ora;
	}
	
	public void setOra(int o) {
		this.ora=o;
	}
	
}
