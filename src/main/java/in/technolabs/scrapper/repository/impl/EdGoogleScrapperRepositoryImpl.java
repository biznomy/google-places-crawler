package in.technolabs.scrapper.repository.impl;

import in.technolabs.scrapper.entity.EdGoogleScrapperEntity;
import in.technolabs.scrapper.repository.custom.EdGoogleScrapperCustom;
import in.technolabs.scrapper.util.JpaRepositoryUtil;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EdGoogleScrapperRepositoryImpl implements EdGoogleScrapperCustom {

	@PersistenceContext
	EntityManager entityManager;

	@Autowired
	JpaRepositoryUtil jpaRepositoryUtil;

	@Override
	public Set<EdGoogleScrapperEntity> list(Map<String, String> queryMap) {

		List<EdGoogleScrapperEntity> results = jpaRepositoryUtil.listWithoutFetch(
				queryMap, EdGoogleScrapperEntity.class);
		return new HashSet<EdGoogleScrapperEntity>(results);
	}

	@Override
	public long count(Map<String, String> queryMap) {
		return jpaRepositoryUtil.count(queryMap, EdGoogleScrapperEntity.class);
	}

}