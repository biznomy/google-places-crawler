package in.technolabs.scrapper.service;

import in.technolabs.scrapper.model.EdPoint;

import java.util.List;
import java.util.Map;

public interface EdPointService {

	public EdPoint save(EdPoint edPoint);

	public long count(Map<String, String> queryMap);

	public EdPoint get(Long id);

	public void delete(Long id);

	public List<EdPoint> list(Map<String, String> queryMap);
	
	public EdPoint patch(EdPoint edPoint);
}
