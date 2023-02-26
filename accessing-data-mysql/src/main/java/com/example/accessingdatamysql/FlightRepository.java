package com.example.accessingdatamysql;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Integer> {
	Iterable<Flight> findByAirlineCode(String airlineCode);
}
