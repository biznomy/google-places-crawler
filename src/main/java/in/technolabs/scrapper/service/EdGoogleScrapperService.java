package in.technolabs.scrapper.service;

import in.technolabs.scrapper.model.EdGoogleScrapper;

import java.util.Map;
import java.util.Set;

public interface EdGoogleScrapperService {

	public long count(Map<String, String> queryMap);

	public EdGoogleScrapper get(String id);

	public void delete(String id);

	public Set<EdGoogleScrapper> list(Map<String, String> queryMap);

	public EdGoogleScrapper save(EdGoogleScrapper edGoogleScrapper);

	public EdGoogleScrapper patch(EdGoogleScrapper edGoogleScrapper);

	
}
