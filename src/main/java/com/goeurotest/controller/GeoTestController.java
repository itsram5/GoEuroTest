package com.goeurotest.controller;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.goeurotest.model.GeoTestModel;
import com.goeurotest.service.GeoTestService;

@RestController
public class GeoTestController   {
 GeoTestService geotestService;
 private static final Logger logger = LoggerFactory.getLogger(GeoTestController.class);
	
	@Autowired
	public GeoTestController(GeoTestService geotestService) {
		this.geotestService = geotestService;
	}
	@RequestMapping("/{location}")
	public List<GeoTestModel> getGeoTestData(@PathVariable("location") String arg) throws JsonParseException, JsonMappingException, IOException{
		logger.info("Request Parameter is::"+arg);
		if(arg!=null){
			return geotestService.getEuroTestdata(arg);
		}
		
		return null;
	
	}
	 
	
}

