package in.technolabs.scrapper.repository;

import in.technolabs.scrapper.entity.EdPointEntity;
import in.technolabs.scrapper.repository.custom.EdPointCustom;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface EdPointRepository extends JpaRepository<EdPointEntity, Long>,
		JpaSpecificationExecutor<EdPointEntity>, EdPointCustom {	
}
