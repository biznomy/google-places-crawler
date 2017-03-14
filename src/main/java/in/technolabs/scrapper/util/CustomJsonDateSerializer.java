package in.technolabs.scrapper.util;

import in.technolabs.scrapper.commons.constants.Constants;

import java.io.IOException;
import java.util.Date;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class CustomJsonDateSerializer extends JsonSerializer<Date> {

	@Override
	public void serialize(Date date, JsonGenerator jsonGenerator,
			SerializerProvider arg2) throws IOException,
			JsonProcessingException {
		DateTimeFormatter dateTimeFormat = DateTimeFormat.forPattern(
				Constants.SERVER_DATE_FORMAT); 
		
		String formattedDate = dateTimeFormat.print(date.getTime());
		jsonGenerator.writeString(formattedDate);

	}

}