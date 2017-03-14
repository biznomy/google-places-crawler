/**
 *
 */
package in.technolabs.scrapper.controller;

import in.technolabs.scrapper.commons.constants.EdErrorCode;
import in.technolabs.scrapper.commons.location.LatLongCalculator;
import in.technolabs.scrapper.exception.EdnomyException;
import in.technolabs.scrapper.service.EdGoogleScrapperService;
import in.technolabs.scrapper.util.EdResponse;
import in.technolabs.scrapper.util.FileUtility;
import in.technolabs.scrapper.util.GoogleScrapperUtil;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class RandomController {
	
	@Autowired
	LatLongCalculator latLongCalculator;

	@Autowired
	FileUtility fileUtility;
	
	@Autowired
	private GoogleScrapperUtil googleScrapperUtil;
	
	 
	
	@Autowired
	private EdGoogleScrapperService edGoogleScrapperService;
	
	Logger LOGGER = LoggerFactory.getLogger(getClass());
	
	//devs.bzn account
	private String apiKey = "AIzaSyA0tFWxANSZcRUWjbgao2K-4Oyu0KSz_yU";
	
	@RequestMapping(value = "/google", method = RequestMethod.GET)
	public String google() {
		return "google";
	}
	
	@RequestMapping(value = "/9958478764", method = RequestMethod.GET)
	public String crmUpdate() {
		return "9958478764";
	}
	
	@RequestMapping(value = "/edpoints", method = RequestMethod.GET)
	public String uploadPoints() {
		return "edpoints";
	}
	
	
	
	
	@RequestMapping(value = "/places", method = RequestMethod.POST)
	@ResponseBody
	public EdResponse<Integer> addPlaces(@RequestParam("file") CommonsMultipartFile multipartFile, @RequestParam("keywords") String keywords) throws JsonProcessingException, IOException {
		final EdResponse<Integer> response = new EdResponse<Integer>();
		
		keywords = URLDecoder.decode(keywords, "UTF-8");
		
		String [] searches = org.springframework.util.StringUtils.commaDelimitedListToStringArray(keywords);
		
		byte[] bytes = multipartFile.getBytes();
		ObjectMapper mapper = new ObjectMapper();
		JsonNode jsonNode = mapper.readTree(bytes);
		JsonNode coordinates = jsonNode.get("co-ordinates");
		double distance = jsonNode.get("distance").asDouble();
		
		Iterator<String> iterator = coordinates.fieldNames();
		while (iterator.hasNext()) {
			String key = (String) iterator.next();
			String latlng = coordinates.get(key).asText();
			for (String keyword : searches) {
				keyword = keyword.replaceAll("\\s", "+");
				String urlEncode = ("location="+latlng+"&radius="+(distance * 1000)+"&keyword="+keyword+"&key="+this.apiKey).replaceAll("\\s", "");
				String url = "https://maps.googleapis.com/maps/api/place/radarsearch/json?"+urlEncode;
				JsonNode jsonResult = googleScrapperUtil.getRequest(url);
				if (jsonResult != null && jsonResult.has("results")) {
					long count=0;
					JsonNode resultNode = jsonResult.get("results");
					googleScrapperUtil.iterateJsonNode(resultNode, count);			
				}
			}
		}
		return response;
	}	
	
	
	
	
	
	
	@RequestMapping(value = "/crm", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = "application/json")
	@ResponseBody
	public EdResponse<String> updateStatus(@RequestParam Map<String, String> data) {
		final EdResponse<String> response = new EdResponse<String>();
		
		List<Long> companies = new ArrayList<Long>();  
		String comapnyArray = data.get("companies");
		String[] company = org.springframework.util.StringUtils.commaDelimitedListToStringArray(comapnyArray);
		Long endUser = null;
		try{
			for (String comp : company) {
				companies.add(Long.parseLong(comp));
			}
			endUser = Long.parseLong(data.get("endUser"));
		}catch(NumberFormatException numberFormatException){
			throw new EdnomyException("data format is incorrect");
		} 
		
		String sendMessage = data.get("message");
		String mediaLink = data.get("media");
		String updatedBy = data.get("updatedBy");
		String type = data.get("type");
		
		if (sendMessage == null || sendMessage.trim().isEmpty()) {
			throw new EdnomyException("message missing");
		}
		if (mediaLink == null || mediaLink.trim().isEmpty()) {
			throw new EdnomyException("media missing");
		}
		if (updatedBy == null || updatedBy.trim().isEmpty()) {
			throw new EdnomyException("updatedBy missing");
		}
		if (type == null || type.trim().isEmpty()) {
			throw new EdnomyException("type missing");
		}
		if (endUser == null) {
			throw new EdnomyException("endUser missing");
		}
		if (companies.isEmpty()) {
			throw new EdnomyException("companies missing");
		}
				
		response.setCode(EdErrorCode.SUCCESS_CODE);
		response.setMessage(EdErrorCode.SUCCESS_MSG);
		return response;
	}

	
}