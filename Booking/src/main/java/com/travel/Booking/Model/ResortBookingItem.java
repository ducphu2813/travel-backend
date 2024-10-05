package com.travel.Booking.Model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class ResortBookingItem extends BookingItem {

    @JsonProperty("resortId")
    private String resortId;
    @JsonProperty("roomNumber")
    private String roomNumber;
    @JsonProperty("nights")
    private Integer nights;
    @JsonProperty("guests")
    private Integer guests;
    @JsonProperty("mealPlan")
    private boolean mealPlan;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @JsonProperty("startDate")
    private LocalDateTime startDate;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @JsonProperty("endDate")
    private LocalDateTime endDate;

    //constructor
    public ResortBookingItem(@JsonProperty("resortId") String resortId,
                             @JsonProperty("roomNumber") String roomNumber,
                             @JsonProperty("nights") Integer nights,
                             @JsonProperty("guests") Integer guests,
                             @JsonProperty("mealPlan") boolean mealPlan,
                             @JsonProperty("startDate") LocalDateTime startDate,
                             @JsonProperty("endDate") LocalDateTime endDate,
                             @JsonProperty("totalPrice") String totalPrice){
        super("resort", totalPrice);
        this.resortId = resortId;
        this.roomNumber = roomNumber;
        this.nights = nights;
        this.guests = guests;
        this.mealPlan = mealPlan;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public String getDetails() {
        return "Resort ID: " + resortId + ", Room Number: " + roomNumber + ", Nights: " + nights + ", Guests: " + guests + ", Meal Plan: " + mealPlan + ", Start Date: " + startDate + ", End Date: " + endDate;
    }

}
