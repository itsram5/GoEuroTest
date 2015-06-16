package com.goeurotest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



import com.goeurotest.service.GeoTestJExcelviewer;
import com.goeurotest.service.GeoTestService;
import com.goeurotest.service.GeoTestServiceImpl;

@Configuration
public class GeoTestConfig {
	
	

	@Bean(name="geotestService")
	public GeoTestService geotestService(){
		
		GeoTestServiceImpl obj= new GeoTestServiceImpl();
		return obj;
		
	}
	@Bean(name="geoJExcelviewer")
	public GeoTestJExcelviewer geoJExcelviewer(){
		
		GeoTestJExcelviewer obj1= new GeoTestJExcelviewer();
		return obj1;
		
	}
	
	
}
