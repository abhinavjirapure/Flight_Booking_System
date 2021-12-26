package com.flightapp.entity;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name = "air_line_booking")
public class AddAirLineEntity {
	@Id
	@Column(name = "airLineNumber")
	private long air_Line_Number;

	@Column(name = "airLineStatus")
	private String air_Line_status;

	@Column(name = "flightNumber")
	private int flight_Number;

	@Column(name = "airLineName")
	private String air_Line_Name;

	@Column(name = "fromPlace")
	private String from_Place;

	@Column(name = "toPlace")
	private String to_Place;
	
	@Column(name = "cost")
	private double cost;

	@Column(name = "startDateTime")
	private LocalDate start_Date_Time;

	@Column(name = "endDateTime")
	private LocalDate end_Date_Time;

	@Column(name = "instrumentUsed")
	private String instrument_Used;

	@Column(name = "mealType")
	private String meal;

	public Long getAir_Line_Number() {
		return air_Line_Number;
	}

	public void setAir_Line_Number(Long air_Line_Number) {
		this.air_Line_Number = air_Line_Number;
	}

	public String getAir_Line_status() {
		return air_Line_status;
	}

	public void setAir_Line_status(String air_Line_status) {
		this.air_Line_status = air_Line_status;
	}

	public int getFlight_Number() {
		return flight_Number;
	}

	public void setFlight_Number(int flight_Number) {
		this.flight_Number = flight_Number;
	}

	public String getAir_Line_Name() {
		return air_Line_Name;
	}

	public void setAir_Line_Name(String air_Line_Name) {
		this.air_Line_Name = air_Line_Name;
	}

	public String getFrom_Place() {
		return from_Place;
	}

	public void setFrom_Place(String from_Place) {
		this.from_Place = from_Place;
	}

	public String getTo_Place() {
		return to_Place;
	}

	public void setTo_Place(String to_Place) {
		this.to_Place = to_Place;
	}
	
	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public LocalDate getStart_Date_Time() {
		return start_Date_Time;
	}

	public void setStart_Date_Time(LocalDate start_Date_Time) {
		this.start_Date_Time = start_Date_Time;
	}

	public LocalDate getEnd_Date_Time() {
		return end_Date_Time;
	}

	public void setEnd_Date_Time(LocalDate end_Date_Time) {
		this.end_Date_Time = end_Date_Time;
	}

	public void setAir_Line_Number(long air_Line_Number) {
		this.air_Line_Number = air_Line_Number;
	}

	public String getInstrument_Used() {
		return instrument_Used;
	}

	public void setInstrument_Used(String instrument_Used) {
		this.instrument_Used = instrument_Used;
	}

	public String getMeal() {
		return meal;
	}

	public void setMeal(String meal) {
		this.meal = meal;
	}

}
