package in.technolabs.scrapper.generator;

import in.technolabs.scrapper.util.TransactionIdentifierGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SequenceIncrementer {

	@Autowired
	TransactionIdentifierGenerator transactionIdentifierGenerator;

	public Long getValue() {
		return transactionIdentifierGenerator.generate(null, null).longValue();
	}
}