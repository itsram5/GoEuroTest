package com.goeurotest.model;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GeoTestModel {
	 long id;
	 String key;
	    String name;
	    String fullName;
	    String iataAirportCode;
	  String type ;
	    String country;
	   long  locationId;
	   boolean inEurope ;
	    String countryCode;
	    boolean coreCountry;
	    String distance;
	    private Map<String, Double> geo_position;
	 public long getLocationId() {
		return locationId;
	}
	public void setLocationId(long locationId) {
		this.locationId = locationId;
	}

	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	 public String getIataAirportCode() {
			return iataAirportCode;
		}
		public void setIataAirportCode(String iataAirportCode) {
			this.iataAirportCode = iataAirportCode;
		}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	public boolean isInEurope() {
		return inEurope;
	}
	public void setInEurope(boolean inEurope) {
		this.inEurope = inEurope;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public boolean isCoreCountry() {
		return coreCountry;
	}
	public void setCoreCountry(boolean coreCountry) {
		this.coreCountry = coreCountry;
	}
	public String getDistance() {
		return distance;
	}
	public void setDistance(String distance) {
		this.distance = distance;
	}
	public Map<String, Double> getGeo_position() {
		return geo_position;
	}
	public void setGeo_position(Map<String, Double> geo_position) {
		this.geo_position = geo_position;
	}
	
    public GeoTestModel(@JsonProperty("_id")long id, @JsonProperty("key")String  key, 
    		@JsonProperty("name")String name, @JsonProperty("fullName") String fullName,
    		@JsonProperty("iata_airport_code") String iataAirportCode,  @JsonProperty("type") String type,
    		@JsonProperty("country") String country, 
    		@JsonProperty("location_id")long locationId, @JsonProperty("inEurope") boolean inEurope, @JsonProperty("countryCode") String countryCode,
		@JsonProperty("coreCountry") boolean coreCountry, @JsonProperty("distance") String distance, @JsonProperty("geo_position")Map<String, Double> geo_position) {
	super();
	this.id = id;
	this.key = key;
	this.name = name;
	this.fullName = fullName;
	this.iataAirportCode = iataAirportCode;
	this.type = type;
	this.country = country;
	this.locationId = locationId;
	this.inEurope = inEurope;
	this.countryCode = countryCode;
	this.coreCountry = coreCountry;
	this.distance = distance;
	this.geo_position = geo_position;
}
	
    
	
}
