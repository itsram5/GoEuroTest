package com.goeurotest.service;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.goeurotest.model.GeoTestModel;

import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.Label;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import jxl.write.Number;
import jxl.write.Boolean;

public class GeoTestJExcelviewer {
	private static final Logger logger = LoggerFactory
			.getLogger(GeoTestJExcelviewer.class);

	public void buildExcelDocument(List<GeoTestModel> list)
			throws IOException, RowsExceededException, WriteException {
		logger.info("In GeoTestJExcelviewer is called");
		String filename="GEOEURODATA_"+ new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) +".xls";
		File file=  new File(
				filename);
		WritableWorkbook workbook = Workbook.createWorkbook(file);
		// Creating sheet
		WritableSheet sheet = workbook.createSheet("GEOEURODATA", 0);
		// Addding cells

		sheet.addCell(new Label(0, 0, "ID"));
		sheet.addCell(new Label(1, 0, "KEY"));
		sheet.addCell(new Label(2, 0, "NAME"));
		sheet.addCell(new Label(3, 0, "FULLNAME"));
		sheet.addCell(new Label(4, 0, "IATAAIRPORTCODE"));
		sheet.addCell(new Label(5, 0, "TYPE"));
		sheet.addCell(new Label(6, 0, "COUNTRY"));
		sheet.addCell(new Label(7, 0, "LATITUDE"));
		sheet.addCell(new Label(8, 0, "LONGITUDE"));
		sheet.addCell(new Label(9, 0, "LOCATIONID"));
		sheet.addCell(new Label(10, 0, "INEUROPE"));
		sheet.addCell(new Label(11, 0, "COUNTRYCODE"));
		sheet.addCell(new Label(12, 0, "CORECOUNTRY"));
		sheet.addCell(new Label(13	, 0, "DISTANCE"));

		int rowNum = 1;
		for (GeoTestModel obj : list) {
			// create the row data
			sheet.addCell(new Number(0, rowNum, obj.getId()));
			sheet.addCell(new Label(1, rowNum, obj.getKey()));
			sheet.addCell(new Label(2, rowNum, obj.getName()));
			sheet.addCell(new Label(3, rowNum, obj.getFullName()));
			sheet.addCell(new Label(4, rowNum, obj.getIataAirportCode()));
			sheet.addCell(new Label(5, rowNum, obj.getType()));
			sheet.addCell(new Label(6, rowNum, obj.getCountry()));
			Map<String, Double> map1 = obj.getGeo_position();
			for (Map.Entry<String, Double> entry : map1.entrySet()) {
				if (entry.getKey().equals("latitude"))
					sheet.addCell(new Number(7, rowNum, entry.getValue()));
				if (entry.getKey().equals("longitude"))
					sheet.addCell(new Number(8, rowNum, entry.getValue()));
			}
			sheet.addCell(new Number(9, rowNum, obj.getLocationId()));
			sheet.addCell(new Boolean(10, rowNum, obj.isInEurope()));
			sheet.addCell(new Label(11, rowNum, obj.getCountryCode()));
			sheet.addCell(new Boolean(12, rowNum, obj.isCoreCountry()));
			sheet.addCell(new Label(13, rowNum, obj.getDistance()));

			rowNum++;
		}
		workbook.write();
		workbook.close();
		logger.info(filename+"is created in "+file.getAbsolutePath());
	}
	
}
