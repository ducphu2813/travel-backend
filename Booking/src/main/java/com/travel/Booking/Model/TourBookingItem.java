package com.travel.Booking.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TourBookingItem extends BookingItem {

    private String tourId;
    private Integer numberOfAdults;
    private Integer numberOfChildren;

    //constructor
    public TourBookingItem(String tourId, Integer numberOfAdults, Integer numberOfChildren, String totalPrice){
        super("tour", totalPrice);
        this.tourId = tourId;
        this.numberOfAdults = numberOfAdults;
        this.numberOfChildren = numberOfChildren;
    }

    @Override
    public String getDetails() {
        return "Tour ID: " + tourId + ", Number of Adults: " + numberOfAdults + ", Number of Children: " + numberOfChildren;
    }
}
