package com.goeurotest.service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.goeurotest.model.GeoTestModel;

@Service
public class GeoTestServiceImpl implements GeoTestService {

	private static final Logger logger = LoggerFactory
			.getLogger(GeoTestServiceImpl.class);

	@Override
	public List<GeoTestModel> getEuroTestdata(String arg)
			throws JsonParseException, JsonMappingException, IOException {

		RestTemplate restTemplate = new RestTemplate();
		String url = "http://api.goeuro.com/api/v2/position/suggest/en/" + arg;

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>("parameters",
				headers);

		ResponseEntity<String> result = restTemplate.exchange(url,
				HttpMethod.GET, entity, String.class);

		HttpStatus statusCode = result.getStatusCode();
		logger.info("Response code is" + statusCode);
		if (statusCode != HttpStatus.OK) {

			throw new RuntimeException("Failed : HTTP error code : "
					+ statusCode);
		}

		logger.info(result.toString());
		logger.info(result.getBody());

		List<GeoTestModel> list = parseJson((String) result.getBody());

		logger.info("JSON list is parsed sucesfully and the no of rows is" + list.size());
		// list.add(new GeoTestModel(arg));

		return list;
	}

	public List<GeoTestModel> parseJson(String str) throws JsonParseException,
			JsonMappingException, IOException {

		ObjectMapper mapper = new ObjectMapper();
		// List<GeoTestModel> list =new ArrayList<GeoTestModel>();

		List<GeoTestModel> geolist = mapper.readValue(
				str,
				mapper.getTypeFactory().constructCollectionType(List.class,
						GeoTestModel.class));

		return geolist;
	}

}
