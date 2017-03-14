package in.technolabs.scrapper.validator;

import in.technolabs.scrapper.commons.constants.EdMessageConstants;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

@Component
public class EdValidationUtil {

	public void rejectIfEmptyOrWhitespace(Errors errors,
			MessageSource messageSource, String[] fields) {

		for (int i = 0; i < fields.length; i++) {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, fields[i],
					messageSource.getMessage(
							EdMessageConstants.FIELD_REQUIRED,
							new String[] { fields[i] }, null));
		}

	}

}
