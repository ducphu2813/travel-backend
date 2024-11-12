package com.travel.Booking.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookingDTO {

    private Long id;

    private String userId;

    private Double totalAmount;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime createdAt = LocalDateTime.now();

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime updatedAt;

    private String status;

    private String paymentStatus;

    private List<BookingItemDTO> bookingItems;

//    //No argument constructor
//    public BookingDTO() {
//    }
//
//    //////////////////////////
//    //GETTER
//    public Long getId() {
//        return id;
//    }
//
//    public String getUserId() {
//        return userId;
//    }
//
//    public Double getTotalAmount() {
//        return totalAmount;
//    }
//
//    public LocalDateTime getCreatedAt() {
//        return createdAt;
//    }
//
//    public LocalDateTime getUpdatedAt() {
//        return updatedAt;
//    }
//
//    public String getStatus() {
//        return status;
//    }
//
//    public String getPaymentStatus() {
//        return paymentStatus;
//    }
//
//    /////////////////////////////
//    // SETTER
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public void setUserId(String userId) {
//        this.userId = userId;
//    }
//
//    public void setTotalAmount(Double totalAmount) {
//        this.totalAmount = totalAmount;
//    }
//
//    public void setCreatedAt(LocalDateTime createdAt) {
//        this.createdAt = createdAt;
//    }
//
//    public void setUpdatedAt(LocalDateTime updatedAt) {
//        this.updatedAt = updatedAt;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//
//    public void setPaymentStatus(String paymentStatus) {
//        this.paymentStatus = paymentStatus;
//    }

    //getter bookingItems
    public List<BookingItemDTO> getBookingItems() {
        return bookingItems;
    }

    //setter bookingItems
    public void setBookingItems(List<BookingItemDTO> bookingItems) {
        this.bookingItems = bookingItems;
    }
}
