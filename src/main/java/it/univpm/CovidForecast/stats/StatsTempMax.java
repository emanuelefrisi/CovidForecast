package it.univpm.CovidForecast.stats;

import java.util.Vector;

import org.springframework.stereotype.Service;

import it.univpm.CovidForecast.model.MeteoCitta;

@Service
public class StatsTempMax extends Stats {

	@Override
	public Vector<MeteoCitta> getStats(String tipoStat, Vector<MeteoCitta> vectPerStats) {

		switch (tipoStat) {

		case "max":
			mCVect = new Vector<MeteoCitta>();

			mCMax = vectPerStats.get(0);
			for (int i = 1; i < vectPerStats.size(); i++) {
				MeteoCitta mC = vectPerStats.get(i);
				if (mC.getTempMax() > mCMax.getTempMax()) {
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
				if (mC.getTempMax() < mCMin.getTempMax()) {
					mCMin = mC;
				}
			}
			mCVect.add(mCMin);
			return mCVect;

		case "varianza":
			Vector<Double> vett = new Vector<Double>();

			Double somma = (double) 0, sommaScartiQuadrati = (double) 0, varianza, media;
			int n;
			for (int i = 0; i < vectPerStats.size(); i++) {
				vett.add(vectPerStats.elementAt(i).getTemp());
			}
			n = vett.size();
			for (int i = 0; i < n; i++) {
				somma += vett.elementAt(i);
			}
			media = somma / n;
			for (int i = 0; i < n; i++) {
				sommaScartiQuadrati += Math.pow(vett.elementAt(i) - media, 2);
			}
			varianza = sommaScartiQuadrati / n;
			Vector<MeteoCitta> VMCVarianza = new Vector<MeteoCitta>();
			MeteoCitta mCVarianza = new MeteoCitta();
			mCVarianza.setTempMax(varianza);
			VMCVarianza.add(mCVarianza);
			return VMCVarianza;

		case "media":
			Vector<Double> vett1 = new Vector<Double>();

			Double somma1 = (double) 0, media1;
			int num;
			for (int i = 0; i < vectPerStats.size(); i++) {
				vett1.add(vectPerStats.elementAt(i).getTempMax());
			}
			num = vett1.size();
			for (int i = 0; i < num; i++) {
				somma1 += vett1.elementAt(i);
			}
			media1 = somma1 / num;
			Vector<MeteoCitta> VMCMedia = new Vector<MeteoCitta>();
			MeteoCitta mCMedia = new MeteoCitta();
			mCMedia.setTempMax(media1);
			VMCMedia.add(mCMedia);
			return VMCMedia;

		default: {
			Vector<MeteoCitta> VMCError = new Vector<MeteoCitta>();
			MeteoCitta mCError = new MeteoCitta(0, "Errore", "Errore", 0, 0, null, null, null, null, 0);
			VMCError.add(mCError);
			return VMCError;
		}
		}

	}
}
