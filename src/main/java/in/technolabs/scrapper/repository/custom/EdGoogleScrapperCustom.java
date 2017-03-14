package in.technolabs.scrapper.repository.custom;

import in.technolabs.scrapper.entity.EdGoogleScrapperEntity;

import java.util.Map;
import java.util.Set;


public interface EdGoogleScrapperCustom {

	public Set<EdGoogleScrapperEntity> list(Map<String, String> queryMap);

	public long count(Map<String, String> queryMap);

}
