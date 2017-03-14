/**
 *
 */
package in.technolabs.scrapper.controller;

import in.technolabs.scrapper.model.EdPoint;
import in.technolabs.scrapper.service.EdPointService;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping(value = "/v1/api")
public class HomeController {
	
	@Autowired
	private EdPointService edPointService;
	
	/**
	 * Having coordinate points from .json file from request /edpoints and 
	 * parse file and read content and separate distance, country and location, 
	 * their after insert coordinate information to database
	 * @param multipartFile
	 * @param request
	 * @return home page
	 * @throws JsonProcessingException
	 * @throws IOException
	 */
	@RequestMapping(value = "/points", method = RequestMethod.POST)
	public String uploadPoints(@RequestParam("file") CommonsMultipartFile multipartFile, HttpServletRequest request) throws JsonProcessingException, IOException {
		
		byte[] bytes = multipartFile.getBytes();
		ObjectMapper mapper = new ObjectMapper();
		JsonNode jsonNode = mapper.readTree(bytes);
		JsonNode coordinates = jsonNode.get("co-ordinates");
		
		double distance = jsonNode.get("distance").asDouble();
		String country = jsonNode.get("country").asText();
		String location = jsonNode.get("location").asText();
		
		Iterator<String> iterator = coordinates.fieldNames();
		while (iterator.hasNext()) {
			
			String string = (String) iterator.next();
			
			EdPoint edPoint = new EdPoint();
			
			String[] latlng = coordinates.get(string).asText().split(",");
			
			edPoint.setLatitude(Double.parseDouble(latlng[0].trim()));
			edPoint.setLongitude(Double.parseDouble(latlng[1].trim()));
			edPoint.setLatlng(coordinates.get(string).asText());
			edPoint.setCode1(country);
			edPoint.setCode2(location);
			edPoint.setDistance(distance);
			edPointService.save(edPoint);
			
		}
			
		return "redirect:/";
	}
	
	
	
}