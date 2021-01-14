package it.univpm.CovidForecast.filters;

import java.util.Vector;

import org.springframework.stereotype.Service;

import it.univpm.CovidForecast.model.MeteoCitta;

@Service
public class FilterHumidity {

	private Vector<MeteoCitta> vectFiltrato;

	public Vector<MeteoCitta> getFromHumidityFilter(Vector<MeteoCitta> vectDaFiltr, long umiditaInit, long umiditaFin) {

		vectFiltrato = new Vector<MeteoCitta>();

		for (int i = 0; i < vectDaFiltr.size(); i++) {
			MeteoCitta mC = vectDaFiltr.get(i);
			if (mC.getUmidita() >= umiditaInit && mC.getUmidita() <= umiditaFin) {
				vectFiltrato.add(mC);
			}
		}
		return vectFiltrato;
	}

}
