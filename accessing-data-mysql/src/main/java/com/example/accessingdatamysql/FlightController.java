package com.example.accessingdatamysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Date;

@Controller
public class FlightController {
	
	
	@Autowired
	private FlightService flightService;
	
	@GetMapping(path="/allflights")
	public @ResponseBody Iterable<Flight> getAllFlights() {	    
		return flightService.findAll();
	}
	
	@GetMapping(path="/flightbycode")
	public @ResponseBody Iterable<Flight> findByFlightCodes(@RequestParam String airlinecode) {	    
		return flightService.findByFlightCodes(airlinecode);
	}
	
	@PostMapping(path="/addflight") 
	public @ResponseBody String addFlight(@RequestParam String airlinecode, @RequestParam String flightnumber, @RequestParam String departureport, @RequestParam String arrivalport, @RequestParam String departuretime, @RequestParam String arrivaltime){
		return flightService.saveFlight(airlinecode, flightnumber, departureport, arrivalport, departuretime, arrivaltime);
	}

}
