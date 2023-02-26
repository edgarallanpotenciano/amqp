package com.example.accessingdatamysql;

import java.sql.Timestamp;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FlightService {
	
	@Autowired
	private FlightRepository flightRepository;
	
	public Iterable<Flight> findAll(){
		return flightRepository.findAll();
	}
	
	public Iterable<Flight> findByFlightCodes(String airlinecode){
		return flightRepository.findByAirlineCode(airlinecode);
	}
	
	public String saveFlight(String airlinecode, String flightnumber, String departureport, String arrivalport, String departuretime, String arrivaltime) {
		
		System.err.println("airlinecode " + airlinecode);
		System.err.println("flightnumber " + flightnumber);
		System.err.println("departureport " + departureport);
		System.err.println("arrivalport " + arrivalport);
		System.err.println("departuretime " + formateDate(departuretime));
		System.err.println("arrivaltime " + formateDate(arrivaltime));
		Flight newFlight = new Flight();
		
		newFlight.setAirlineCode(airlinecode.trim());
		newFlight.setFlightNumber(flightnumber.trim());
		newFlight.setDeparturePort(departureport.trim());
		newFlight.setArrivalPort(arrivalport.trim());
		newFlight.setDepartureTime(formateDate(departuretime.trim()));
		newFlight.setArrivalTime(formateDate(arrivaltime.trim()));
		
		//flightRepository.save(newFlight);
		flightRepository.saveAndFlush(newFlight);
		
		
		return "OK !!";
	}
	
	public Timestamp formateDate(String rawTime) {
		// rawTime format dateSample = "2023-03-04 10:30:00";
		
		String[] stampPart = rawTime.split(" ");
		// here you'll have 2023-03-04 and 10:30:00
		String[] datePart = stampPart[0].split("-");
		// here you'll have year:2023 month:2 and day:04
		// Format year, month and day
		Integer year = Integer.parseInt(datePart[0]); // year
		Integer month = Integer.parseInt(datePart[1]) - 1; // month
		Integer day = Integer.parseInt(datePart[2]); // day
		
		String[] timePart = stampPart[1].split(":");
		// Here you'll have Hours:10 minutes: 30 seconds:0
		// format hour, minutes, seconds;
		String tempSecs = timePart[2].substring(0, 2);
		
		Integer hour = Integer.parseInt(timePart[0]); 
		Integer minutes = Integer.parseInt(timePart[1]);
		Integer seconds = Integer.parseInt(tempSecs);
		
		
		Calendar cal = Calendar.getInstance();
		cal.set(year, month, day, hour, minutes, seconds);
		
		Timestamp mytS = new Timestamp(cal.getTimeInMillis());
		
		return mytS;
	}

}
