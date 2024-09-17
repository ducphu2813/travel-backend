package com.travel.Booking.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "booking")
public class Booking {

    @Id
    private String id;
    private String userId;
    private List<BookingItem> bookingDetails;
    private Integer totalPrice;
    private LocalDateTime createdAt;
    private String status;
}
