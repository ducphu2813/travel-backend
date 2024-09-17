package com.travel.Booking.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TourBookingItem extends BookingItem {

    @JsonProperty("tourId")
    private String tourId;
    @JsonProperty("numberOfAdults")
    private Integer numberOfAdults;
    @JsonProperty("numberOfChildren")
    private Integer numberOfChildren;

    //constructor
    public TourBookingItem(@JsonProperty("tourId") String tourId,
                           @JsonProperty("numberOfAdults") Integer numberOfAdults,
                           @JsonProperty("numberOfChildren") Integer numberOfChildren,
                           @JsonProperty("totalPrice") String totalPrice){
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
