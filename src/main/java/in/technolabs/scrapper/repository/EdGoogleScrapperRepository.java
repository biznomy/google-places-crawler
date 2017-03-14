package in.technolabs.scrapper.repository;

import in.technolabs.scrapper.entity.EdGoogleScrapperEntity;
import in.technolabs.scrapper.repository.custom.EdGoogleScrapperCustom;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface EdGoogleScrapperRepository extends JpaRepository<EdGoogleScrapperEntity, String>,
		JpaSpecificationExecutor<EdGoogleScrapperEntity>, EdGoogleScrapperCustom {	
}
