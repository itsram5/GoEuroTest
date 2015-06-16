package com.goeurotest;


import java.io.IOException;
import java.util.List;

import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.goeurotest.model.GeoTestModel;
import com.goeurotest.service.GeoTestJExcelviewer;
import com.goeurotest.service.GeoTestService;


@SpringBootApplication
public class GoEuroTestApplication {
	private static final Logger logger = LoggerFactory.getLogger(GoEuroTestApplication.class);
   public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException, RowsExceededException, WriteException {
	   logger.info("Arguments passed to GoEuroTestApplication is ::"+args);
    	ApplicationContext ctx = SpringApplication.run(GoEuroTestApplication.class, args);
        System.out.println("Let's inspect the beans provided by Spring Boot:");
         
        GeoTestService geotestService= (GeoTestService) ctx.getBean("geotestService");
        if(args.length==0){
        	
        	 logger.info("Execute GeoEuroTest.Jar at least with one argument of country name");
        	 System.exit(-1);
        
         }
        logger.info("Location name is "+args[0]);
        List<GeoTestModel> list=geotestService.getEuroTestdata(args[0]);
        
        if(list.size()==0){
        	throw new RuntimeException("No JSON list returned for the search string"+args[0]);
        }
        
        GeoTestJExcelviewer geoJExcelviewer= (GeoTestJExcelviewer) ctx.getBean("geoJExcelviewer");
        geoJExcelviewer.buildExcelDocument(list);
       logger.info("Completed the requested query.Run the GeoEuroTest.jar with atleast one argument of type country");
       System.exit(0);
    }
}
