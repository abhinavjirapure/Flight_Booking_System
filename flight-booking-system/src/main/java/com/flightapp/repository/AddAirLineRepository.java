package com.flightapp.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.flightapp.entity.AddAirLineEntity;

@Repository
public interface AddAirLineRepository extends JpaRepository<AddAirLineEntity, Long> {

	@Query(value = "Select * from air_line_booking a where a.air_Line_Number = :air_Line_Number AND a.air_Line_status = 'Active'", nativeQuery = true)
	List<AddAirLineEntity> findByAirLineNumber(@Param("air_Line_Number") long air_Line_Number);

	@Query(value = "SELECT * FROM air_line_booking u WHERE "
			+ "LOWER(u.from_Place) = :from AND u.to_place =:to AND u.start_date_time <= :startDate "
			+ "AND u.end_date_time >= :startDate AND air_Line_status ='Active'", nativeQuery = true)
	List<AddAirLineEntity> findByCriteria(@Param("from") String from, @Param("to") String to,
			@Param("startDate") LocalDate startDate);

}
