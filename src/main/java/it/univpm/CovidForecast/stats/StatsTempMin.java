package it.univpm.CovidForecast.stats;

import java.util.Vector;

import org.springframework.stereotype.Service;

import it.univpm.CovidForecast.model.MeteoCitta;

@Service
public class StatsTempMin extends Stats {

	@Override
	public Vector<MeteoCitta> getStats(String tipoStat, Vector<MeteoCitta> vectPerStats) {

		switch (tipoStat) {

		case "max":
			mCVect = new Vector<MeteoCitta>();

			mCMax = vectPerStats.get(0);
			for (int i = 1; i < vectPerStats.size(); i++) {
				MeteoCitta mC = vectPerStats.get(i);
				if (mC.getTempMin() > mCMax.getTempMin()) {
					mCMax = mC;
				}
			}
			mCVect.add(mCMax);
			return mCVect;

		case "min":
			mCVect = new Vector<MeteoCitta>();

			mCMin = vectPerStats.get(0);
			for (int i = 1; i < vectPerStats.size(); i++) {
				MeteoCitta mC = vectPerStats.get(i);
				if (mC.getTempMin() < mCMin.getTempMin()) {
					mCMin = mC;
				}
			}
			mCVect.add(mCMin);
			return mCVect;
		}
		return null;
	}
}
