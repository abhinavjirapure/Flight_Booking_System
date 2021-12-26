package com.flightapp.model;

import java.io.Serializable;

public class AirLineDetails implements Serializable {

	private static final long serialVersionUID = 1L;
	private long airLineNumber;
	private String airLinestatus;
	private int flightNumber;
	private String airLineName;
	private String fromPlace;
	private String toPlace;
	private double price;
	private String startDateTime;
	private String endDateTime;
	private String instrumentUsed;
	private String meal;

	public long getAirLineNumber() {
		return airLineNumber;
	}

	public String getAirLinestatus() {
		return airLinestatus;
	}

	public void setAirLinestatus(String airLinestatus) {
		this.airLinestatus = airLinestatus;
	}

	public int getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getAirLineName() {
		return airLineName;
	}

	public void setAirLineName(String airLineName) {
		this.airLineName = airLineName;
	}

	public void setAirLineNumber(long airLineNumber) {
		this.airLineNumber = airLineNumber;
	}

	public String getFromPlace() {
		return fromPlace;
	}

	public void setFromPlace(String fromPlace) {
		this.fromPlace = fromPlace;
	}

	public String getToPlace() {
		return toPlace;
	}

	public void setToPlace(String toPlace) {
		this.toPlace = toPlace;
	}

	public String getStartDateTime() {
		return startDateTime;
	}

	public void setStartDateTime(String startDateTime) {
		this.startDateTime = startDateTime;
	}

	public String getEndDateTime() {
		return endDateTime;
	}

	public void setEndDateTime(String endDateTime) {
		this.endDateTime = endDateTime;
	}

	public String getInstrumentUsed() {
		return instrumentUsed;
	}

	public void setInstrumentUsed(String instrumentUsed) {
		this.instrumentUsed = instrumentUsed;
	}

	public String getMeal() {
		return meal;
	}

	public void setMeal(String meal) {
		this.meal = meal;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
