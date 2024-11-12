package com.travel.Booking.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "total_amount")
    private Double totalAmount;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "status")
    private String status;

    @Column(name = "payment_status")
    private String paymentStatus;

    @OneToMany(
            mappedBy = "booking"
            , cascade = CascadeType.ALL
            , orphanRemoval = true)
    private List<BookingItem> bookingItems;

//    //No argument constructor
//    public Booking() {
//    }
//
//    //////////////////////////////////////////
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
//    //SETTER
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
    public List<BookingItem> getBookingItems() {
        return bookingItems;
    }

    //setter bookingItems
    public void setBookingItems(List<BookingItem> bookingItems) {
        this.bookingItems = bookingItems;
    }

}
