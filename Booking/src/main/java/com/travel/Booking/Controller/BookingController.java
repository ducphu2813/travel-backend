package com.travel.Booking.Controller;

import com.travel.Booking.DTO.AddBookingDTO;
import com.travel.Booking.DTO.BookingDTO;
import com.travel.Booking.Model.Booking;
import com.travel.Booking.Service.Interface.IBookingService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/booking")
public class BookingController {

    private final IBookingService bookingService;

    public BookingController(IBookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping
    public List<BookingDTO> getAll() {
        return bookingService.getAllBookings();
    }

    @GetMapping("/{id}")
    public BookingDTO getById(@PathVariable Long id) {
        return bookingService.getBookingById(id);
    }

    //tạo booking
    @PostMapping
    public HashMap<String, Object> create(@RequestBody AddBookingDTO booking) {
        return bookingService.createBooking(booking);
    }

    @PutMapping("/{id}")
    public Booking update(@PathVariable Long id, @RequestBody Booking booking) {
        return bookingService.updateBooking(id, booking);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        bookingService.deleteBooking(id);
    }

    //hàm thêm 1 or nhiều booking item cho 1 booking
//    @PostMapping("/add-booking-item")
//    public Booking addBookingItem(@RequestBody AddBookingItemDTO addBookingItemDTO) {
//        return bookingService.addBookingItem(addBookingItemDTO);
//    }
}
