package com.travel.Booking.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class FlightBookingItem extends BookingItem {
    private String flightId;
    private String seatNumber;
    private String seatType;

    //constructor
    public FlightBookingItem(String flightId, String seatNumber, String seatType, String totalPrice){
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
