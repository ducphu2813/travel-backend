package com.travel.Booking.Service.Interface;

import com.travel.Booking.DTO.AddBookingDTO;
import com.travel.Booking.DTO.AddBookingItemDTO;
import com.travel.Booking.DTO.BookingDTO;
import com.travel.Booking.Model.Booking;

import java.util.HashMap;
import java.util.List;

public interface IBookingService {

    List<BookingDTO> getAllBookings();
    BookingDTO getBookingById(Long id);
    HashMap<String, Object> createBooking(AddBookingDTO booking);
    Booking updateBooking(Long id, Booking booking);
    void deleteBooking(String id);

    //thêm nhiều booking item cho 1 booking
//    Booking addBookingItem(AddBookingItemDTO addBookingItemDTO);
}
