package com.travel.Booking.Service.Interface;

import com.travel.Booking.DTO.AddBookingItemDTO;
import com.travel.Booking.Model.Booking;

import java.util.List;

public interface IBookingService {

    List<Booking> getAllBookings();
    Booking getBookingById(String id);
    Booking createBooking(Booking booking);
    Booking updateBooking(String id, Booking booking);
    void deleteBooking(String id);

    //thêm nhiều booking item cho 1 booking
    Booking addBookingItem(AddBookingItemDTO addBookingItemDTO);
}
