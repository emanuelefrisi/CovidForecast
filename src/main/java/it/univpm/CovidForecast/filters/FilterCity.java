package it.univpm.CovidForecast.filters;

import java.util.List;

import it.univpm.CovidForecast.service.*;
import it.univpm.CovidForecast.model.*;

public class FilterCity {
	private String city;
	private MeteoCittaService mcsC;
	private List<MeteoCitta> listaPerFiltri = mcsC.getMeteoCittaFromDB();
	private List<MeteoCitta> listaFiltrataC;
	public List<MeteoCitta> getFromCityFilter(/*List<MeteoCitta> listaPerFiltri, */String city) {
		this.city=city;
		for(int i=0;i<listaPerFiltri.size();i++) {
			if(this.city.compareTo(listaPerFiltri.get(i).getCitta())==0) {
				listaFiltrataC.add(listaPerFiltri.get(i));
			}	
		}
		return listaFiltrataC;
	}

}
