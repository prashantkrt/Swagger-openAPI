package com.myLearning.springRest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.myLearning.springRest.model.Passenger;
import com.myLearning.springRest.model.Ticket;
import com.myLearning.springRest.service.ITicketBookingService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
//http://localhost:8085/RailwayTicketBookingApplication/swagger-ui/index.html
//above  is the url
@RestController
@RequestMapping("/ticket/BookingAPI")
@Tag(name="TicketBookingAPI", description = "API to book Tickets")
public class TicketBookingController {

	@Autowired
	private ITicketBookingService service;

	@Operation(summary = "Post Request", description = "")
	@PostMapping("/getTicketNumber")
	public ResponseEntity<Ticket> registerPassenger(@RequestBody Passenger passenger) {
		Passenger p = service.registerPassenger(passenger);
		Ticket ticket = new Ticket();
		ticket.setTicketNumber(p.getPassengerId());
		ticket.setName(p.getPassengerName());
		ticket.setStatus("Confirmed");
		ticket.setDeparture(p.getDeparture());
		ticket.setArrival(p.getArrival());
		ticket.setDateOfJourney(p.getDateOfJourney());
		ticket.setTotalFare(1230.00);
		return new ResponseEntity<Ticket>(ticket, HttpStatus.OK);
	}

	@Operation(summary = "Get Request", description = "API takes values using path varibles")
	@GetMapping("/getPassenger/{id}")
	public Passenger getPassenger(@PathVariable Integer id) {
		return service.getPassengerInfo(id);
	}

	@Operation(summary = "Get Request",description = "")
	@GetMapping("/getTicket/{ticketNumber}")
	public ResponseEntity<Ticket> getTicket(@PathVariable("ticketNumber") Integer ticketNumber) {

		Passenger passenger = service.getPassengerInfo(ticketNumber);
		Ticket ticket = new Ticket();
		ticket.setTicketNumber(passenger.getPassengerId());
		ticket.setName(passenger.getPassengerName());
		ticket.setStatus("Confirmed");
		ticket.setDeparture(passenger.getDeparture());
		ticket.setArrival(passenger.getArrival());
		ticket.setDateOfJourney(passenger.getDateOfJourney());
		ticket.setTotalFare(1230.00);

		return new ResponseEntity<Ticket>(ticket, HttpStatus.OK);
	}

}
