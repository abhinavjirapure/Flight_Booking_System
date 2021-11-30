package com.flightapp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightapp.entity.AddAirLineEntity;
import com.flightapp.model.AirLineDetails;
import com.flightapp.service.AddAirLineService;

@RestController
@RequestMapping(value="/api/v1.0")
public class AddAirLineController {

	private static final Logger logger = LoggerFactory.getLogger(AddAirLineController.class);

	@Autowired
	AddAirLineService airLineService; 

	@PostMapping(value = "/create/airlines")
	public  ResponseEntity<String> createAirLine(@RequestBody AirLineDetails requestModel) throws Exception
	{
		logger.info("Inside createAirLine method");
		airLineService.createAirLine(requestModel);
		logger.info("Returning create new AirLine response");
		return new ResponseEntity<>("New Air Line Created Successfully...",HttpStatus.OK);
	}

	@GetMapping(value ="/flight/search/{airLineNumber}")
	public ResponseEntity<List<AddAirLineEntity>> searchFlight(@PathVariable long airLineNumber)
	{
		logger.info("Inside searchFlight method");
		logger.info("Returning search flight response");
		return new ResponseEntity<>(airLineService.searchFlight(airLineNumber),HttpStatus.OK);
	}

	@PutMapping(value ="/flight/update")
	public ResponseEntity<String> updateFlightDetails(@RequestBody AirLineDetails requestModel) throws Exception
	{
		logger.info("Inside updateFlightDetails method");
		airLineService.updateFlightDetails(requestModel);
		logger.info("Returning update flight details response");
		return new ResponseEntity<>("Air Line Details Updated Successfully...",HttpStatus.OK);
	}

}
