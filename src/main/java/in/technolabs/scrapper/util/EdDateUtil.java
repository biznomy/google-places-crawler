package in.technolabs.scrapper.util;

import in.technolabs.scrapper.commons.constants.Constants;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class EdDateUtil {

	public Date getDatefromString(String date) {
		DateFormat formatter = new SimpleDateFormat(
				Constants.DB_DATE_FORMAT,
				Constants.LOCALE);
		try {
			return (formatter.parse(date));
		} catch (Exception e) {

		}
		return null;

	}

}
