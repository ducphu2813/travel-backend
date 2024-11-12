package com.travel.Booking.Repository;

import com.travel.Booking.Model.BookingItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingItemRepository extends JpaRepository<BookingItem, Long> {
}
