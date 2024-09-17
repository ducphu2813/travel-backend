package com.travel.Booking.Service;

import com.travel.Booking.Exception.NotFoundException;
import com.travel.Booking.Model.Booking;
import com.travel.Booking.Repository.BookingRepository;
import com.travel.Booking.Service.Interface.IBookingService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookingService implements IBookingService {

    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public Booking getBookingById(String id) {
        return bookingRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Booking not found"));
    }

    @Override
    @Transactional
    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    @Transactional
    public Booking updateBooking(String id, Booking booking) {
        Booking bookingToUpdate = bookingRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Booking not found"));

        booking.setId(id);

        return bookingRepository.save(booking);
    }

    @Override
    @Transactional
    public void deleteBooking(String id) {
        Booking bookingToDelete = bookingRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Booking not found"));

        bookingRepository.deleteById(id);
    }


}
