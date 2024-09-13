package com.travel.Flight.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Document(collection = "flights")
public class Flight {

    @Id
    private String id;
    private String airline;
    private String departureAirport;
    private String arrivalAirport;
    private String departureCity;
    private String arrivalCity;
    private LocalDateTime departureDate;
    private LocalDateTime arrivalDate;
    private Integer economyPrice;
    private Integer businessPrice;
    private Integer economySeats;
    private Integer availableEconomySeats;
    private Integer businessSeats;
    private Integer availableBusinessSeats;
    private Integer availableSeats;
    private Integer totalSeats;
    private LocalDateTime createdAt;
    private String status;
}
