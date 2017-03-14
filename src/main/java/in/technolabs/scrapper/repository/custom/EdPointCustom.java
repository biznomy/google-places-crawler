package in.technolabs.scrapper.repository.custom;

import in.technolabs.scrapper.entity.EdPointEntity;

import java.util.List;
import java.util.Map;


public interface EdPointCustom {

	public List<EdPointEntity> list(Map<String, String> queryMap);

	public long count(Map<String, String> queryMap);

}
