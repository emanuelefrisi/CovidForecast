package it.univpm.CovidForecast.filters;

import java.util.List;

import it.univpm.CovidForecast.service.*;
import it.univpm.CovidForecast.model.*;

public class FilterData {
	private long dataInit;
	private long dataFinish;
	private MeteoCittaService mcsD;
	private List<MeteoCitta> listaPerFiltri = mcsD.getMeteoCittaFromDB();
	private List<MeteoCitta> listaFiltrataD;
	public List<MeteoCitta> getFromDataFilter(/*List<MeteoCitta> listaPerFiltri , */long dataInit, long dataFinish) {
		this.dataInit=dataInit;
		this.dataFinish=dataFinish;
		for(int i=0;i<listaPerFiltri.size();i++) {
			if(listaPerFiltri.get(i).getData()>this.dataInit&&listaPerFiltri.get(i).getData()<this.dataFinish) {
				listaFiltrataD.add(listaPerFiltri.get(i));
			}	
		}
		return listaFiltrataD;
	}
	

}
