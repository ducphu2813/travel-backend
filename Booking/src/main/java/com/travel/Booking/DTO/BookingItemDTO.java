package com.travel.Booking.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookingItemDTO {

    private Long id;

    private String serviceType;

    /////////////////////////////
    /////////////////////////////
    // Những thuộc tính của flight
    private String flightID;

    private LocalDateTime departureTime;

    private Integer duration;

    private String seatNumber;

    private String seatType;

    /////////////////////////////
    /////////////////////////////
    // Những thuộc tính của resort
    private String resortID;

    private String roomID;

    private Boolean mealCombo;

    private Integer nights;

    private Integer guests;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime startDate;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime endDate;

    /////////////////////////////
    /////////////////////////////
    // Những thuộc tính của tour
    private String tourID;

    private Integer numberOfAdults;

    private Integer numberOfChildren;

    //No argument constructor
    public BookingItemDTO() {
    }

    //////////////////////////
    //GETTER
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

    /////////////////////////////
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

}
