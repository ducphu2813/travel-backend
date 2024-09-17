package com.travel.Booking.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor @AllArgsConstructor
public abstract class BookingItem {

    private String serviceType;
    private String totalPrice;

    // Phương thức abstract mà các class con phải triển khai
    public abstract String getDetails();

}
