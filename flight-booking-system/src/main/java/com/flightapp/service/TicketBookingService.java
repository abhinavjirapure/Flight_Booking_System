package com.flightapp.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.flightapp.entity.AddAirLineEntity;
import com.flightapp.entity.FlightBookingEntity;
import com.flightapp.model.TicketBookingDetails;
import com.flightapp.repository.AddAirLineRepository;
import com.flightapp.repository.FlightBookingRepository;

@Service
@Component
public class TicketBookingService {

	private static final Logger logger = LoggerFactory.getLogger(TicketBookingService.class);

	@Autowired
	private FlightBookingRepository repo;

	@Autowired
	private AddAirLineRepository addRepo;

	@Autowired
	private FlightBookingEntity entity;

	public String bookFlightTicket(TicketBookingDetails requestModel) {
		logger.info("Inside bookFlightTicket service method");
		try {
			entity.setFlight_Number(requestModel.getFlightNumber());
			entity.setDate(requestModel.getDate());
			entity.setFrom_Place(requestModel.getFromPlace());
			entity.setTo_Place(requestModel.getToPlace());
			entity.setName(requestModel.getName());
			entity.setCost(requestModel.getPrice());
			entity.setEmailID(requestModel.getEmailID());
			entity.setNo_Of_Seats_To_Book(requestModel.getNoOfSeatsToBook());
			entity.setGender(requestModel.getGender());
			entity.setAge(requestModel.getAge());
			entity.setMealType(requestModel.getMealType());
			logger.info("Creating db query");
			repo.save(entity);
		} catch (Exception e) {
			logger.info("Exception occur" + e);
		}
		return null;
	}

	public List<AddAirLineEntity> searchFlights(String from, String to, String departureDate, String seatType) {
		logger.info("Inside searchFlights service method");
		LocalDate startDate = LocalDate.parse(departureDate);
		logger.info("Creating db query");
		List<AddAirLineEntity> res = addRepo.findByCriteria(from, to, startDate);
		return res;
	}

	public Optional<FlightBookingEntity> getTicketDetails(int pnr) {
		logger.info("Inside getTicketDetails service method");
		Optional<FlightBookingEntity> ticketBookingDetails;
		logger.info("Creating db query");
		ticketBookingDetails = repo.findById(pnr);
		logger.info("Returning db object");
		return ticketBookingDetails;
	}

	public List<FlightBookingEntity> getTicketHistory(@PathVariable String emailId) {
		logger.info("Inside getTicketHistory service method");
		List<FlightBookingEntity> ticketHistoryDetails;
		logger.info("Creating db query");
		ticketHistoryDetails = repo.findByEmailID(emailId);
		logger.info("Returning db object");
		return ticketHistoryDetails;
	}

	public String cancelTicket(int pnr) {
		logger.info("Inside cancelTicket service method");
		try {
			logger.info("Creating db query");
			repo.deleteById(pnr);
		} catch (Exception e) {
			logger.info("Exception occur" + e);
		}
		return null;
	}

}
