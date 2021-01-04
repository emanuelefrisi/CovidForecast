package it.univpm.CovidForecast.filters;

import java.util.List;

import it.univpm.CovidForecast.model.MeteoCitta;
import it.univpm.CovidForecast.service.MeteoCittaService;

public class FilterHour {
	private int oraInit;
	private int oraFinish;
	private MeteoCittaService mcsO;
	private List<MeteoCitta> listaPerFiltri = mcsO.getMeteoCittaFromDB();
	private List<MeteoCitta> listaFiltrataO;
	public List<MeteoCitta> getFromHourFilter(/*List<MeteoCitta> listaPerFiltri , */int oraInit, int oraFinish) {
		this.oraInit=oraInit;
		this.oraFinish=oraFinish;
		for(int i=0;i<listaPerFiltri.size();i++) {
			if(listaPerFiltri.get(i).getOra()>this.oraInit&&listaPerFiltri.get(i).getOra()<this.oraFinish) {
				listaFiltrataO.add(listaPerFiltri.get(i));
			}	
		}
		return listaFiltrataO;
	}

}
