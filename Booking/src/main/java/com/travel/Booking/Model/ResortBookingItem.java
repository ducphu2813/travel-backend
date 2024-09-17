package com.travel.Booking.Model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResortBookingItem extends BookingItem {

    private String resortId;
    private String roomNumber;
    private Integer nights;
    private Integer guests;
    private boolean mealPlan;

    //constructor
    public ResortBookingItem(String resortId, String roomNumber, Integer nights, Integer guests, boolean mealPlan, String totalPrice){
        super("resort", totalPrice);
        this.resortId = resortId;
        this.roomNumber = roomNumber;
        this.nights = nights;
        this.guests = guests;
        this.mealPlan = mealPlan;
    }

    @Override
    public String getDetails() {
        return "Resort ID: " + resortId + ", Room Number: " + roomNumber + ", Nights: " + nights + ", Guests: " + guests + ", Meal Plan: " + mealPlan;
    }

}
