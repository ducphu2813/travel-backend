package com.travel.Payment.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "payment")
public class Payment {

    @Id
    private String id;

    private String userId;
    private String bookingId;
    private Integer totalPrice;
    private String status;
    private String paymentMethod;
    private LocalDateTime paymentDate;
}
