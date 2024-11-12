package com.travel.Booking.Mapper;

import com.travel.Booking.DTO.*;
import com.travel.Booking.Model.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BookingMapper {

    BookingMapper INSTANCE = Mappers.getMapper(BookingMapper.class);

    // Chuyển từ Booking Entity sang BookingDTO
    @Mapping(target = "bookingItems", ignore = true)
    BookingDTO bookingToBookingDTO(Booking booking);

    // Chuyển từ BookingDTO sang Booking Entity
    Booking bookingDTOToBooking(BookingDTO bookingDTO);

    // Chuyển từ booking item Entity sang booking item DTO
    BookingItemDTO bookingItemToBookingItemDTO(BookingItem bookingItem);

    // Chuyển từ BookingServiceDTO sang BookingService Entity
    BookingItem bookingItemDTOToBookingItem(BookingItemDTO bookingItemDTO);

    //chuyển 1 danh sách Booking sang 1 danh sách BookingDTO
    List<BookingDTO> bookingsToBookingDTOs(List<Booking> bookings);

    //chuyển 1 danh sách BookingItemDTO sang 1 danh sách BookingItem
    List<BookingItem> bookingItemDTOsToBookingItems(List<BookingItemDTO> bookingItemDTOs);

    //chuyển 1 danh sách BookingItem sang 1 danh sách BookingItemDTO
    List<BookingItemDTO> bookingItemsToBookingItemDTOs(List<BookingItem> bookingItems);
}
