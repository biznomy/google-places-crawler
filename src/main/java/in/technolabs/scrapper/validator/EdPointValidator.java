package in.technolabs.scrapper.validator;

import in.technolabs.scrapper.model.EdPoint;
import in.technolabs.scrapper.util.ApplicationProperties;
import in.technolabs.scrapper.util.FileUtility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class EdPointValidator implements Validator, MessageSourceAware {

	MessageSource messageSource;
	
	@Autowired
	ApplicationProperties applicationProperties;
	
	@Autowired
	FileUtility fileUtility;
	
	Logger LOGGER = LoggerFactory.getLogger(getClass()); 

	@Override
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return EdPoint.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		
	}
	
}