package com.flightapp.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.flightapp.entity.AddAirLineEntity;
import com.flightapp.model.AirLineDetails;
import com.flightapp.repository.AddAirLineRepository;

@Service
@Component
public class AddAirLineService {

	private static final Logger logger = LoggerFactory.getLogger(AddAirLineService.class);

	@Autowired
	private AddAirLineRepository airLineRepository;

	@Autowired
	private AddAirLineEntity airLineEntity;

	public String createAirLine(AirLineDetails requestModel) {
		logger.info("Inside createAirLine service method");
		LocalDate startDate = LocalDate.parse(requestModel.getStartDateTime());
		LocalDate endDate = LocalDate.parse(requestModel.getEndDateTime());
		try {
			airLineEntity.setAir_Line_Number(requestModel.getAirLineNumber());
			airLineEntity.setAir_Line_status(requestModel.getAirLinestatus());
			airLineEntity.setFlight_Number(requestModel.getFlightNumber());
			airLineEntity.setAir_Line_Name(requestModel.getAirLineName());
			airLineEntity.setFrom_Place(requestModel.getFromPlace());
			airLineEntity.setTo_Place(requestModel.getToPlace());
			airLineEntity.setCost(requestModel.getPrice());
			airLineEntity.setStart_Date_Time(startDate);
			airLineEntity.setEnd_Date_Time(endDate);
			airLineEntity.setInstrument_Used(requestModel.getInstrumentUsed());
			airLineEntity.setMeal(requestModel.getMeal());
			logger.info("Creating db query");
			airLineRepository.save(airLineEntity);
		} catch (Exception e) {
			logger.info("Exception occur" + e);
		}
		return null;
	}

	public List<AddAirLineEntity> searchFlight(long airLineNumber) {
		logger.info("Inside searchFlight service method");
		logger.info("Creating db query");
		List<AddAirLineEntity> list = airLineRepository.findByAirLineNumber(airLineNumber);
		logger.info("Returning flight search list");
		return list;
	}

	public String updateFlightDetails(AirLineDetails requestModel) {
		logger.info("Inside updateFlightDetails service method");
		LocalDate startDate = LocalDate.parse(requestModel.getStartDateTime());
		LocalDate endDate = LocalDate.parse(requestModel.getEndDateTime());
		try {
			airLineEntity.setAir_Line_Number(requestModel.getAirLineNumber());
			airLineEntity.setAir_Line_status(requestModel.getAirLinestatus());
			airLineEntity.setFlight_Number(requestModel.getFlightNumber());
			airLineEntity.setAir_Line_Name(requestModel.getAirLineName());
			airLineEntity.setFrom_Place(requestModel.getFromPlace());
			airLineEntity.setTo_Place(requestModel.getToPlace());
			airLineEntity.setStart_Date_Time(startDate);
			airLineEntity.setEnd_Date_Time(endDate);
			airLineEntity.setInstrument_Used(requestModel.getInstrumentUsed());
			airLineEntity.setMeal(requestModel.getMeal());
			logger.info("Creating db query");
			airLineRepository.save(airLineEntity);
		} catch (Exception e) {
			logger.info("Exception occur" + e);
		}
		return null;
	}

	public String updateFlightStatus(long airLineNumber, String status) {
		logger.info("Inside updateFlightStatus service method");
		try {
			airLineEntity = searchFlightById(airLineNumber);
			airLineEntity.setAir_Line_status(status);
			logger.info("Creating db query");
			airLineRepository.save(airLineEntity);
		} catch (Exception e) {
			logger.info("Exception occur" + e);
		}
		return null;
	}

	public AddAirLineEntity searchFlightById(long airLineNumber) {
		logger.info("Inside searchFlight service method");
		logger.info("Creating db query");
		Optional<AddAirLineEntity> obj = airLineRepository.findById(airLineNumber);
		logger.info("Returning flight search list");
		return obj.get();
	}

}
