package com.travel.Booking.Repository;

import com.travel.Booking.Model.Booking;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookingRepository extends MongoRepository<Booking, String> {
}
