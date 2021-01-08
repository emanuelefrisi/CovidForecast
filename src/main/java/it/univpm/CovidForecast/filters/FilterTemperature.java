package it.univpm.CovidForecast.filters;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;

import it.univpm.CovidForecast.model.MeteoCitta;
import it.univpm.CovidForecast.service.MeteoCittaService;

//@Service
public class FilterTemperature {
	
	@Autowired
	private MeteoCittaService mcsT;
	private List<MeteoCitta> listaPerFiltri = mcsT.getMeteoCittaFromDB();
	private List<MeteoCitta> listaFiltrata;
	
	public List<MeteoCitta> getFromTemperatureFilter(Double tempInit, Double tempFin) {
		for(int i=0;i<listaPerFiltri.size();i++) {
			MeteoCitta mC = listaPerFiltri.get(i);
			if(mC.getTemp()>tempInit&&mC.getTemp()<tempFin) {
				listaFiltrata.add(mC);
			}	
		}
		return listaFiltrata;
	}

}
