package it.univpm.CovidForecast.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.univpm.CovidForecast.model.MeteoCitta;
import it.univpm.CovidForecast.repository.MeteoCittaRepository;

/**
 * 
 * @author emanuelefrisi
 *
 */
@Service
public class MeteoCittaService {

	@Autowired
	private MeteoCittaRepository mCR;
	
	public void salvaRecord(MeteoCitta mC) {
		mCR.save(mC);
	}
	
}
