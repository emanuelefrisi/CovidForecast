package it.univpm.CovidForecast.filters;

import java.util.List;

import it.univpm.CovidForecast.model.MeteoCitta;
import it.univpm.CovidForecast.service.MeteoCittaService;

public class FilterHumidity {
	private long umiditaInit;
	private long umiditaFinish;
	private MeteoCittaService mcsU;
	private List<MeteoCitta> listaPerFiltri = mcsU.getMeteoCittaFromDB();
	private List<MeteoCitta> ListaFiltrataU;
	public List<MeteoCitta> getFromHumidityFilter(/*List<MeteoCitta> listaPerFiltri, */long umiditaInit, long umiditaFinish) {
		this.umiditaInit=umiditaInit;
		this.umiditaFinish=umiditaFinish;
		for(int i=0;i<listaPerFiltri.size();i++) {
			if(listaPerFiltri.get(i).getUmidita()>this.umiditaInit&&listaPerFiltri.get(i).getUmidita()<this.umiditaFinish) {
				ListaFiltrataU.add(listaPerFiltri.get(i));
			}	
		}
		return ListaFiltrataU;
	}

}
