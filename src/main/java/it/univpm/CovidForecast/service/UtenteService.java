package it.univpm.CovidForecast.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.univpm.CovidForecast.model.Utente;
import it.univpm.CovidForecast.repository.UtenteRepository;

/**
 * 
 * Classe service che utilizza i metodi di UtenteRepository per salvare gli oggetti
 * dal database o recuperarli
 * 
 * @author emanuelefrisi
 *
 */
@Service
public class UtenteService {

	@Autowired
	private UtenteRepository uR;
	
	/**
	 * 
	 * Metodo che permette di salvare un utente sul database se esso dovesse superare dei controlli
	 * 
	 * @param username
	 * @param password
	 * @return valore boolean
	 */
	public boolean salva(String username, String password) {
		Utente u = new Utente(username, password);
		List<Utente> utenti = uR.findAll();
		
		for(int i = 0; i<utenti.size(); i++) {
			Utente temp = utenti.get(i);
			if(username.equals(temp.getUsername()))
				return false;
		}
		
		uR.save(u);
		return true;
	}
	
	public String compara(String username, String password) {
		boolean flagUser = false, flagPass = false;
		List<Utente> utenti = uR.findAll();
		for(int i = 0; i<utenti.size(); i++) {
			Utente u = utenti.get(i);
			if(username.equals(u.getUsername()))
				flagUser = true;
				if (password.equals(u.getPassword()))
					flagPass = true;
		}
		return flagUser + " " + flagPass;
	}
	
}