package com.travel.Booking.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class FlightBookingItem extends BookingItem {

    @JsonProperty("flightId")
    private String flightId;
    @JsonProperty("seatNumber")
    private String seatNumber;
    @JsonProperty("seatType")
    private String seatType;

    //constructor
    public FlightBookingItem(@JsonProperty("flightId") String flightId,
                             @JsonProperty("seatNumber") String seatNumber,
                             @JsonProperty("seatType") String seatType,
                             @JsonProperty("totalPrice") String totalPrice){
        super("flight", totalPrice);
        this.flightId = flightId;
        this.seatNumber = seatNumber;
        this.seatType = seatType;
    }

    @Override
    public String getDetails() {
        return "Flight ID: " + flightId + ", Seat Number: " + seatNumber + ", Seat Type: " + seatType;
    }
}
