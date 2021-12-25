package com.flightapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.flightapp.entity.FlightBookingEntity;

@Repository
public interface FlightBookingRepository extends JpaRepository<FlightBookingEntity, Integer> {

	@Query(value = "Select * from flight_booking f WHERE f.emailId = :emailId", nativeQuery = true)
	List<FlightBookingEntity> findByEmailID(@Param("emailId") String emailId);

	// Optional<FlightBookingEntity> getById(String emailId);

	// Optional<FlightBookingEntity> findById(String emailId);

	// List<TicketBookingDetails> findAllById(int val);

	/*
	 * @Query(value = "SELECT * FROM air_line_booking u WHERE " +
	 * "LOWER(u.from_Place) = :from_Place AND u.to_Place =:to_Place AND u.start_Date_Time <= :startDate "
	 * + "AND u.end_Date_Time >= :startDate AND air_Line_status ='Active'",
	 * nativeQuery = true) List<FlightBookingEntity>
	 * findByCriteria(@Param("from_Place") String from_Place, @Param("to_Place")
	 * String to,
	 * 
	 * @Param("startDate") LocalDate startDate);
	 */

	/*
	 * @Query(value = "SELECT * FROM flights u WHERE " +
	 * "LOWER(u.source) = :source AND u.destination =:destination AND u.start_date <= :startDate "
	 * + "AND u.end_date >= :startDate AND status ='running'", nativeQuery = true)
	 * List<Flight> findByCriteria(@Param("source") String
	 * source, @Param("destination") String destination,
	 * 
	 * @Param("startDate") LocalDate startDate);
	 */
}
