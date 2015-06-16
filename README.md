# GoEuroTest
Implement an API query and transform this data into a csv file

Implemented with Springboot strap framework
used sofwares :
jackson-databind- JSON -java object mapping
jxl to import the data in excel

Package structure
1. com.goeurotest/EuroTestApplication.java- Main method to initiliaze the spring application context beans . 
Service method is called to get the JSON data
and import to excel
2. com.goeurotest.config/GeoTestConfig -Intialized the GeoTestService and GeoTestJExcelviewer.
3. com.goeurotest.service /GeoTestService-
3.a)Call the JSON api -"http://api.goeuro.com/api/v2/position/suggest/en/" 
with user passed argument at commeand line.
3.b)Converts the JSON data to java model object-GeoTestModel(json data) using the jackson mapper and jackson databind methods.
3.c)Return the java GeoTestModel list,
4.com.goeurotest.service/GeoTestJExcelviewer- jxl api is used to write to excel.
5.com.goeurotest.controller/GeoTestController is used as place holder to extend the application to browser excel download further.






