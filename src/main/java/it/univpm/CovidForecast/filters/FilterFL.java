package it.univpm.CovidForecast.filters;

import java.util.Vector;

import org.springframework.stereotype.Service;

import it.univpm.CovidForecast.model.MeteoCitta;

@Service
public class FilterFL {

	private Vector<MeteoCitta> vectFiltrato;

	public Vector<MeteoCitta> getFromPTemperatureFilter(Vector<MeteoCitta> vectDaFiltr, Double TPInit, Double TPFin) {

		vectFiltrato = new Vector<MeteoCitta>();

		for (int i = 0; i < vectDaFiltr.size(); i++) {
			MeteoCitta mC = vectDaFiltr.get(i);
			if (mC.getTempPercepita() >= TPInit && mC.getTempPercepita() <= TPFin) {
				vectFiltrato.add(mC);
			}
		}
		return vectFiltrato;
	}

}
