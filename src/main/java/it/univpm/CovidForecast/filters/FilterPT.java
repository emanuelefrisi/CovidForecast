package it.univpm.CovidForecast.filters;

import java.util.List;

import it.univpm.CovidForecast.model.*;
import it.univpm.CovidForecast.service.MeteoCittaService;

public class FilterPT {
	private Double TPInit;
	private Double TPFinish;
	private MeteoCittaService mcsTP;
	private List<MeteoCitta> listaPerFiltri = mcsTP.getMeteoCittaFromDB();
	private List<MeteoCitta> listaFiltrataTP;
	public List<MeteoCitta> getFromPTemperatureFilter(/*List <MeteoCitta> listaPerFiltri, */Double TPInit, Double TPFinish) {
		this.TPInit=TPInit;
		this.TPFinish=TPFinish;
		for(int i=0;i<listaPerFiltri.size();i++) {
			if(listaPerFiltri.get(i).getTempPercepita()>this.TPInit&&listaPerFiltri.get(i).getTempPercepita()<this.TPFinish) {
				listaFiltrataTP.add(listaPerFiltri.get(i));
			}	
		}
		return listaFiltrataTP;
	}

}
