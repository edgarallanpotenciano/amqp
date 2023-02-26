package com.example.accessingdatamysql;

import java.sql.Timestamp;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="flights")
public class Flight {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "flightid")
	private Integer flightId;
	
	@Column(name = "airlinecode")
	private String airlineCode;
	
	@Column(name = "flightnumber")
	private String flightNumber;
	
	@Column(name = "departureport")
	private String departurePort;
	
	@Column(name = "arrivalport")
	private String arrivalPort;
	
	
	@Column(name = "departuretime")	
	private Timestamp departureTime;
	
	
	@Column(name = "arrivaltime")	
	private Timestamp arrivalTime;

	public Integer getFlightId() {
		return flightId;
	}

	public void setFlightId(Integer flightId) {
		this.flightId = flightId;
	}

	public String getAirlineCode() {
		return airlineCode;
	}

	public void setAirlineCode(String airlineCode) {
		this.airlineCode = airlineCode;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getDeparturePort() {
		return departurePort;
	}

	public void setDeparturePort(String departurePort) {
		this.departurePort = departurePort;
	}

	public String getArrivalPort() {
		return arrivalPort;
	}

	public void setArrivalPort(String arrivalPort) {
		this.arrivalPort = arrivalPort;
	}

	
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-dd-MM'T'HH:mm:ss'Z'")
	public Date getDepartureTime() {
		return departureTime;
	}
	
	public void setDepartureTime(Timestamp departureTime) {
		this.departureTime = departureTime;
	}
	
    /*
	public Timestamp getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Timestamp departureTime) {
		this.departureTime = departureTime;
	}
	*/
	
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-dd-MM'T'HH:mm:ss'Z'")
	public Date getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Timestamp arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	
    /*
	public Timestamp getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Timestamp arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	*/
	

}
