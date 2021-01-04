package it.univpm.CovidForecast.filters;

import java.util.List;

import it.univpm.CovidForecast.model.MeteoCitta;
import it.univpm.CovidForecast.service.MeteoCittaService;

public class FilterNation {
	private String nation;
	private MeteoCittaService mcsN;
	private List<MeteoCitta> listaPerFiltri = mcsN.getMeteoCittaFromDB();
	private List<MeteoCitta> listaFiltrataN;
	public List<MeteoCitta> getFromNationFilter(/*List<MeteoCitta> listaPerFiltri, */String nation) {
		this.nation=nation;
		for(int i=0;i<listaPerFiltri.size();i++) {
			if(this.nation.compareTo(listaPerFiltri.get(i).getNazione())==0) {
				listaFiltrataN.add(listaPerFiltri.get(i));
			}	
		}
		return listaFiltrataN;
	}

}
