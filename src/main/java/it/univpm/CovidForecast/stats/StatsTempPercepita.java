package it.univpm.CovidForecast.stats;

//import org.springframework.stereotype.Service;

import it.univpm.CovidForecast.model.MeteoCitta;

//@Service
public class StatsTempPercepita extends Stats {

	@Override
	public MeteoCitta getMax() {
		mCMax = listaPerStats.get(0);
		for (int i = 1; i < listaPerStats.size(); i++) {
			MeteoCitta mC = listaPerStats.get(i);
			if (mC.getTempPercepita() > mCMax.getTempPercepita()) {
				mCMax = mC;
			}
		}
		return mCMax;
	}

	@Override
	public MeteoCitta getMin() {
		mCMin = listaPerStats.get(0);
		for (int i = 1; i < listaPerStats.size(); i++) {
			MeteoCitta mC = listaPerStats.get(i);
			if (mC.getTempPercepita() < mCMin.getTempPercepita()) {
				mCMin = mC;
			}
		}
		return mCMin;
	}

}
