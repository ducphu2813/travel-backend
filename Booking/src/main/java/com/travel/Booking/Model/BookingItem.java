package com.travel.Booking.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "serviceType")
@JsonSubTypes({
        @JsonSubTypes.Type(value = FlightBookingItem.class, name = "flight"),
        @JsonSubTypes.Type(value = TourBookingItem.class, name = "tour"),
        @JsonSubTypes.Type(value = ResortBookingItem.class, name = "resort")
})
public abstract class BookingItem {

    @JsonProperty("serviceType")
    private String serviceType;
    @JsonProperty("totalPrice")
    private String totalPrice;

    // Phương thức abstract mà các class con phải triển khai
    public abstract String getDetails();

    //constructor
    public BookingItem(String serviceType, String totalPrice) {
        this.serviceType = serviceType;
        this.totalPrice = totalPrice;
    }

}
