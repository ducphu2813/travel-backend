package com.travel.Booking.Service;

import com.travel.Booking.DTO.AddBookingItemDTO;
import com.travel.Booking.Exception.NotFoundException;
import com.travel.Booking.Model.Booking;
import com.travel.Booking.Repository.BookingRepository;
import com.travel.Booking.Service.Interface.IBookingService;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookingService implements IBookingService {

    private final BookingRepository bookingRepository;
    private final MongoTemplate mongoTemplate;

    public BookingService(BookingRepository bookingRepository,
                          MongoTemplate mongoTemplate) {
        this.bookingRepository = bookingRepository;
        this.mongoTemplate = mongoTemplate;
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

    //thêm nhiều booking item cho 1 booking
    @Override
    @Transactional
    public Booking addBookingItem(AddBookingItemDTO addBookingItemDTO) {
        Booking bookingToUpdate = bookingRepository.findById(addBookingItemDTO.getBookingId())
                .orElseThrow(() -> new NotFoundException("Booking not found"));

        Query query = new Query(Criteria.where("id").is(addBookingItemDTO.getBookingId()));

        Update update = new Update().push("bookingDetails").each(addBookingItemDTO.getItems().toArray());

        return mongoTemplate.findAndModify(query, update, FindAndModifyOptions.options().returnNew(true), Booking.class);

    }


}
