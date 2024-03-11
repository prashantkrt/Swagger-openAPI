package com.myLearning.springRest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@SpringBootApplication
@OpenAPIDefinition(
		info=@Info(title="Ticket Booking API", version="1.4",
		description = "This api is to book the tickets"),
		servers = @Server(
				url="http://localhost:8085/RailwayTicketBookingApplication",
				description="This api url to book tickets")
		)
public class SpringRestTicketBookingApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringRestTicketBookingApplication.class, args);
	}
}
