package com.goeurotest.service;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.goeurotest.model.GeoTestModel;

public interface GeoTestService {
	
	public List<GeoTestModel> getEuroTestdata(String arg) throws JsonParseException, JsonMappingException, IOException;

}
