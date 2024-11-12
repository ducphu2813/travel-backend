package com.travel.Booking.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "booking_item")
public class BookingItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "service_type")
    private String serviceType;

    /////////////////////////////
    /////////////////////////////
    // Những thuộc tính của flight
    @Column(name = "flight_id")
    private String flightID;

    @Column(name = "departure_time")
    private LocalDateTime departureTime;

    @Column(name = "duration")
    private Integer duration;

    @Column(name = "seat_number")
    private String seatNumber;

    @Column(name = "seat_type")
    private String seatType;

    /////////////////////////////
    /////////////////////////////
    // Những thuộc tính của resort
    @Column(name = "resort_id")
    private String resortID;

    @Column(name = "room_id")
    private String roomID;

    @Column(name = "meal_combo")
    private Boolean mealCombo;

    @Column(name = "nights")
    private Integer nights;

    @Column(name = "guests")
    private Integer guests;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @Column(name = "start_date")
    private LocalDateTime startDate;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @Column(name = "end_date")
    private LocalDateTime endDate;

    /////////////////////////////
    /////////////////////////////
    // Những thuộc tính của tour
    @Column(name = "tour_id")
    private String tourID;

    @Column(name = "number_of_adults")
    private Integer numberOfAdults;

    @Column(name = "number_of_children")
    private Integer numberOfChildren;

    /////////////////////////////
    // Mapping
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "booking_id")
    private Booking booking;

    //No argument constructor
    public BookingItem() {
    }

    /////////////////////////////
    // GETTER
    public Long getId() {
        return id;
    }

    public String getServiceType() {
        return serviceType;
    }

    public String getFlightID() {
        return flightID;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public Integer getDuration() {
        return duration;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public String getSeatType() {
        return seatType;
    }

    public String getResortID() {
        return resortID;
    }

    public String getRoomID() {
        return roomID;
    }

    public Boolean getMealCombo() {
        return mealCombo;
    }

    public Integer getNights() {
        return nights;
    }

    public Integer getGuests() {
        return guests;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public String getTourID() {
        return tourID;
    }

    public Integer getNumberOfAdults() {
        return numberOfAdults;
    }

    public Integer getNumberOfChildren() {
        return numberOfChildren;
    }

    // SETTER
    public void setId(Long id) {
        this.id = id;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public void setFlightID(String flightID) {
        this.flightID = flightID;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }

    public void setResortID(String resortID) {
        this.resortID = resortID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    public void setMealCombo(Boolean mealCombo) {
        this.mealCombo = mealCombo;
    }

    public void setNights(Integer nights) {
        this.nights = nights;
    }

    public void setGuests(Integer guests) {
        this.guests = guests;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public void setTourID(String tourID) {
        this.tourID = tourID;
    }

    public void setNumberOfAdults(Integer numberOfAdults) {
        this.numberOfAdults = numberOfAdults;
    }

    public void setNumberOfChildren(Integer numberOfChildren) {
        this.numberOfChildren = numberOfChildren;
    }

    //getter booking
    public Booking getBooking() {
        return booking;
    }

    //setter booking
    public void setBooking(Booking booking) {
        this.booking = booking;
    }
}
