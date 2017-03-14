package in.technolabs.scrapper.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ApplicationProperties {

	@Value("${location.temp.file}")
	private String tempFile;

	@Value("${location.temp.dir}")
	private String tempDir;

	public String getTempFile() {
		return tempFile;
	}

	public String getTempDir() {
		return tempDir;
	}

}
