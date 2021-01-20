package it.univpm.CovidForecast.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.univpm.CovidForecast.model.ApiKey;
import it.univpm.CovidForecast.repository.ApiKeyRepository;

/**
 * 
 * Classe service che utilizza i metodi di ApiKeyRepository per salvare gli oggetti
 * dal database o recuperarli
 * 
 * @author emanuelefrisi
 * 
 * @see it.univpm.CovidForecast.repository.ApiKeyRepository
 *
 */
@Service
public class ApiKeyService {

	@Autowired
	private ApiKeyRepository aKR;
	
	/**
	 * Metodo che recupera dal database una specifica apiKey
	 * @param i
	 * @return apiKey
	 */
	public String getApiKeyFromDB(int i) {
		List<ApiKey> aKList = aKR.findAll();
		ApiKey aK = aKList.get(i);
		return aK.getApiKey();
	}

}
