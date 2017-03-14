package in.technolabs.scrapper;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.support.incrementer.AbstractSequenceMaxValueIncrementer;
import org.springframework.jdbc.support.incrementer.HsqlSequenceMaxValueIncrementer;

@Configuration
@ComponentScan
@EnableJpaRepositories
@EntityScan()
@EnableAutoConfiguration
@ImportResource(value = {"classpath:root-context.xml",
		"classpath:dispatcherServlet/servlet-context.xml" })
public class InfrastructureConfiguration {

	@Autowired
	private DataSource dataSource;

	private static final String ID_SEQUENCE = "hibernate_sequence";

	@Bean(name = "docCodePicklistSequence")
	public AbstractSequenceMaxValueIncrementer picklistSequenceIncrementer() {
		AbstractSequenceMaxValueIncrementer incrementer = new HsqlSequenceMaxValueIncrementer();
		incrementer.setIncrementerName(ID_SEQUENCE);
		incrementer.setDataSource(dataSource);
		return incrementer;
	}

	@Bean(name = "docCodePicklistValueSequence")
	public AbstractSequenceMaxValueIncrementer picklistValueSequenceIncrementer() {
		AbstractSequenceMaxValueIncrementer incrementer = new HsqlSequenceMaxValueIncrementer();
		incrementer.setIncrementerName(ID_SEQUENCE);
		incrementer.setDataSource(dataSource);
		return incrementer;
	}

	@Bean(name = "docContextBusinessParameterSequence")
	public AbstractSequenceMaxValueIncrementer docContextBusinessParameterSequenceIncrementer() {
		AbstractSequenceMaxValueIncrementer incrementer = new HsqlSequenceMaxValueIncrementer();
		incrementer.setIncrementerName(ID_SEQUENCE);
		incrementer.setDataSource(dataSource);
		return incrementer;
	}

	@Bean(name = "docContextRegisterDocumentSequence")
	public AbstractSequenceMaxValueIncrementer docContextRegisterDocumentSequenceIncrementer() {
		AbstractSequenceMaxValueIncrementer incrementer = new HsqlSequenceMaxValueIncrementer();
		incrementer.setIncrementerName(ID_SEQUENCE);
		incrementer.setDataSource(dataSource);
		return incrementer;
	}

	@Bean(name = "docContextRegisterSequence")
	public AbstractSequenceMaxValueIncrementer docContextRegisterSequenceIncrementer() {
		AbstractSequenceMaxValueIncrementer incrementer = new HsqlSequenceMaxValueIncrementer();
		incrementer.setIncrementerName(ID_SEQUENCE);
		incrementer.setDataSource(dataSource);
		return incrementer;
	}

	@Bean(name = "docMetaDataKeySequence")
	public AbstractSequenceMaxValueIncrementer docMetaDataKeySequenceIncrementer() {
		AbstractSequenceMaxValueIncrementer incrementer = new HsqlSequenceMaxValueIncrementer();
		incrementer.setIncrementerName(ID_SEQUENCE);
		incrementer.setDataSource(dataSource);
		return incrementer;
	}

	@Bean(name = "docMetaDataSequence")
	public AbstractSequenceMaxValueIncrementer docMetaDataSequenceIncrementer() {
		AbstractSequenceMaxValueIncrementer incrementer = new HsqlSequenceMaxValueIncrementer();
		incrementer.setIncrementerName(ID_SEQUENCE);
		incrementer.setDataSource(dataSource);
		return incrementer;
	}

	@Bean(name = "docTransactionFileLocationSequence")
	public AbstractSequenceMaxValueIncrementer docTransactionFileLocationSequenceIncrementer() {
		AbstractSequenceMaxValueIncrementer incrementer = new HsqlSequenceMaxValueIncrementer();
		incrementer.setIncrementerName(ID_SEQUENCE);
		incrementer.setDataSource(dataSource);
		return incrementer;
	}

	@Bean(name = "docTransactionFileSequence")
	public AbstractSequenceMaxValueIncrementer docTransactionFileSequenceIncrementer() {
		AbstractSequenceMaxValueIncrementer incrementer = new HsqlSequenceMaxValueIncrementer();
		incrementer.setIncrementerName(ID_SEQUENCE);
		incrementer.setDataSource(dataSource);
		return incrementer;
	}

	@Bean(name = "docTransactionJsonDataSequence")
	public AbstractSequenceMaxValueIncrementer docTransactionJsonDataSequenceIncrementer() {
		AbstractSequenceMaxValueIncrementer incrementer = new HsqlSequenceMaxValueIncrementer();
		incrementer.setIncrementerName(ID_SEQUENCE);
		incrementer.setDataSource(dataSource);
		return incrementer;
	}

	@Bean(name = "docTransactionReferenceSequence")
	public AbstractSequenceMaxValueIncrementer docTransactionReferenceSequenceIncrementer() {
		AbstractSequenceMaxValueIncrementer incrementer = new HsqlSequenceMaxValueIncrementer();
		incrementer.setIncrementerName(ID_SEQUENCE);
		incrementer.setDataSource(dataSource);
		return incrementer;
	}

	@Bean(name = "docTransactionSequence")
	public AbstractSequenceMaxValueIncrementer docTransactionSequenceIncrementer() {
		AbstractSequenceMaxValueIncrementer incrementer = new HsqlSequenceMaxValueIncrementer();
		incrementer.setIncrementerName(ID_SEQUENCE);
		incrementer.setDataSource(dataSource);
		return incrementer;
	}

	@Bean(name = "docTransactionXmlDataSequence")
	public AbstractSequenceMaxValueIncrementer docTransactionXmlDataSequenceIncrementer() {
		AbstractSequenceMaxValueIncrementer incrementer = new HsqlSequenceMaxValueIncrementer();
		incrementer.setIncrementerName(ID_SEQUENCE);
		incrementer.setDataSource(dataSource);
		return incrementer;
	}

	@Bean(name = "paramPicklistSequence")
	public AbstractSequenceMaxValueIncrementer paramPicklistSequenceIncrementer() {
		AbstractSequenceMaxValueIncrementer incrementer = new HsqlSequenceMaxValueIncrementer();
		incrementer.setIncrementerName(ID_SEQUENCE);
		incrementer.setDataSource(dataSource);
		return incrementer;
	}

}
