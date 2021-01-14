package it.univpm.CovidForecast.filters;

import java.util.Vector;

import org.springframework.stereotype.Service;

import it.univpm.CovidForecast.model.MeteoCitta;

@Service
public class FilterTemperature {

	private Vector<MeteoCitta> vectFiltrato;

	public Vector<MeteoCitta> getFromTemperatureFilter(Vector<MeteoCitta> vectDaFiltr, Double tempInit, Double tempFin) {

		vectFiltrato = new Vector<MeteoCitta>();

		for (int i = 0; i < vectDaFiltr.size(); i++) {
			MeteoCitta mC = vectDaFiltr.get(i);
			if (mC.getTemp() >= tempInit && mC.getTemp() <= tempFin) {
				vectFiltrato.add(mC);
			}
		}
		return vectFiltrato;
	}

}
