package it.univpm.CovidForecast.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.univpm.CovidForecast.model.Ora;
import it.univpm.CovidForecast.repository.OraRepository;

@Service
public class OraService {

	@Autowired
	private OraRepository oR;
	
	public void salvaRecord(Ora o) {
		oR.save(o);
	}
	
	public Ora getOra() {
		Ora o = oR.findAll().get(0);
		return o;
	}
	
}
