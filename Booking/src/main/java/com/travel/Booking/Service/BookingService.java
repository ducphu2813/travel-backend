package com.travel.Booking.Service;

import com.travel.Booking.DTO.AddBookingDTO;
import com.travel.Booking.DTO.BookingDTO;
import com.travel.Booking.DTO.BookingItemDTO;
import com.travel.Booking.Feign.FlightServiceInterface;
import com.travel.Booking.Mapper.BookingMapper;
import com.travel.Booking.Model.*;
import com.travel.Booking.Repository.BookingItemRepository;
import com.travel.Booking.Repository.BookingRepository;
import com.travel.Booking.Service.Interface.IBookingService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class BookingService implements IBookingService {

    private final BookingRepository bookingRepository;
    private final BookingItemRepository bookingItemRepository;
    private final FlightServiceInterface flightServiceInterface;

    public BookingService(BookingRepository bookingRepository
                            , BookingItemRepository bookingItemRepository
                            , BookingMapper bookingMapper
                            , FlightServiceInterface flightServiceInterface) {
        this.bookingRepository = bookingRepository;
        this.bookingItemRepository = bookingItemRepository;
        this.flightServiceInterface = flightServiceInterface;
    }

    @Override
    public List<BookingDTO> getAllBookings() {

        List<Booking> bookings = bookingRepository.findAll();

        //chuyển từ Booking sang BookingDTO không dùng mapstruct
//        List<BookingDTO> bookingDTOs = new ArrayList<>();
//        for (Booking booking : bookings) {
//            BookingDTO bookingDTO = new BookingDTO();
//            bookingDTO.setId(booking.getId());
//            bookingDTO.setUserId(booking.getUserId());
//            bookingDTO.setTotalAmount(booking.getTotalAmount());
//            bookingDTO.setCreatedAt(booking.getCreatedAt());
//            bookingDTO.setUpdatedAt(booking.getUpdatedAt());
//            bookingDTO.setStatus(booking.getStatus());
//            bookingDTO.setPaymentStatus(booking.getPaymentStatus());
//
//            //lấy ra danh sách booking item không dùng mapstruct
//            List<BookingItemDTO> bookingItemDTOs = new ArrayList<>();
//            for (int i = 0; i < booking.getBookingItems().size(); i++) {
//                BookingItemDTO bookingItemDTO = getBookingItemDTO(booking, i);
//                bookingItemDTOs.add(bookingItemDTO);
//            }
//
//            bookingDTO.setBookingItems(bookingItemDTOs);
//
//            bookingDTOs.add(bookingDTO);
//        }
//
//        return bookingDTOs;

        //dùng mapstruct
        List<BookingDTO> bookingDTOs = new ArrayList<>();
        for (Booking booking : bookings) {
            BookingDTO bookingDTO = BookingMapper.INSTANCE.bookingToBookingDTO(booking);
            bookingDTOs.add(bookingDTO);
            List<BookingItemDTO> bookingItemDTOs = new ArrayList<>();
            for (BookingItem bookingItem : booking.getBookingItems()) {
                BookingItemDTO bookingItemDTO = BookingMapper.INSTANCE.bookingItemToBookingItemDTO(bookingItem);
                bookingItemDTOs.add(bookingItemDTO);
            }
            bookingDTO.setBookingItems(bookingItemDTOs);
        }
        return bookingDTOs;
    }

    @Override
    public BookingDTO getBookingById(Long id) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        //chuyển từ Booking sang BookingDTO không dùng mapstruct
//        BookingDTO bookingDTO = new BookingDTO();
//        bookingDTO.setId(booking.getId());
//        bookingDTO.setUserId(booking.getUserId());
//        bookingDTO.setTotalAmount(booking.getTotalAmount());
//        bookingDTO.setCreatedAt(booking.getCreatedAt());
//        bookingDTO.setUpdatedAt(booking.getUpdatedAt());
//        bookingDTO.setStatus(booking.getStatus());
//        bookingDTO.setPaymentStatus(booking.getPaymentStatus());
//
//        //lấy ra danh sách booking item không dùng mapstruct
//        List<BookingItemDTO> bookingItemDTOs = new ArrayList<>();
//        for (int i = 0; i < booking.getBookingItems().size(); i++) {
//            BookingItemDTO bookingItemDTO = getBookingItemDTO(booking, i);
//            bookingItemDTOs.add(bookingItemDTO);
//        }
//
//        bookingDTO.setBookingItems(bookingItemDTOs);
//
//        return bookingDTO;

        //thử gọi flight service bằng feign client
        String health = flightServiceInterface.health();
        System.out.println("Call FLIGHT Service: \n" + health);

        //dùng mapstruct
        BookingDTO bookingDTO = BookingMapper.INSTANCE.bookingToBookingDTO(booking);
        List<BookingItemDTO> bookingItemDTOs = new ArrayList<>();

        for (BookingItem bookingItem : booking.getBookingItems()) {
            BookingItemDTO bookingItemDTO = BookingMapper.INSTANCE.bookingItemToBookingItemDTO(bookingItem);
            //kiểm tra
            bookingItemDTOs.add(bookingItemDTO);
        }

        bookingDTO.setBookingItems(bookingItemDTOs);

        return bookingDTO;
    }

    @Override
    @Transactional
    public HashMap<String, Object> createBooking(AddBookingDTO booking) {

        //lấy các thuộc tính của Booking ra tạo 1 entity Booking
        Booking newBooking = new Booking();
        newBooking.setUserId(booking.getUserId());
        newBooking.setTotalAmount(booking.getTotalAmount());
        newBooking.setCreatedAt(booking.getCreatedAt());
        newBooking.setUpdatedAt(booking.getUpdatedAt());
        newBooking.setStatus(booking.getStatus());
        newBooking.setPaymentStatus(booking.getPaymentStatus());

        // save thông tin Booking
        Booking savedBooking = bookingRepository.save(newBooking);

        //lấy ra danh sách booking item không dùng mapstruct
        //lặp qua từng booking item trong danh sách booking item dto
        List<BookingItem> bookingItems = new ArrayList<>();
        
        for (int i = 0; i < booking.getBookingItems().size(); i++) {
            BookingItem bookingItem = getBookingItem(booking, i);
            bookingItems.add(bookingItem);
        }

        //set booking id cho từng booking item
        bookingItems.forEach(bookingItem -> bookingItem.setBooking(savedBooking));

        //lưu thông tin booking item
        bookingItemRepository.saveAll(bookingItems);

        //trả về cả booking và booking item(gộp thành 1 hashmap)
        return new HashMap<String, Object>() {{
            put("booking", savedBooking);
            put("bookingItems", bookingItems);
        }};
    }

    @Override
    @Transactional
    public Booking updateBooking(Long id, Booking booking) {

        Booking bookingToUpdate = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));



        return null;
    }

    @Override
    @Transactional
    public void deleteBooking(String id) {
//        Booking bookingToDelete = bookingRepository.findById(id)
//                .orElseThrow(() -> new NotFoundException("Booking not found"));
//
//        bookingRepository.deleteById(id);


    }

    //thêm nhiều booking item cho 1 booking
//    @Override
//    @Transactional
//    public Booking addBookingItem(AddBookingItemDTO addBookingItemDTO) {
//
//
//    }


    //chuyển từ booking item dto sang booking item
    private static BookingItem getBookingItem(AddBookingDTO booking, int i) {
        BookingItem bookingItem = new BookingItem();
        //cần kiểm tra các thuộc tính có null không
        bookingItem.setId(booking.getBookingItems().get(i).getId() == null ? null : booking.getBookingItems().get(i).getId());
        bookingItem.setServiceType(booking.getBookingItems().get(i).getServiceType() == null ? "" : booking.getBookingItems().get(i).getServiceType());
        bookingItem.setFlightID(booking.getBookingItems().get(i).getFlightID() == null ? "" : booking.getBookingItems().get(i).getFlightID());
        bookingItem.setDepartureTime(booking.getBookingItems().get(i).getDepartureTime() == null ? null : booking.getBookingItems().get(i).getDepartureTime());
        bookingItem.setDuration(booking.getBookingItems().get(i).getDuration() == null ? 0 : booking.getBookingItems().get(i).getDuration());
        bookingItem.setSeatNumber(booking.getBookingItems().get(i).getSeatNumber() == null ? "" : booking.getBookingItems().get(i).getSeatNumber());
        bookingItem.setSeatType(booking.getBookingItems().get(i).getSeatType() == null ? "" : booking.getBookingItems().get(i).getSeatType());
        bookingItem.setResortID(booking.getBookingItems().get(i).getResortID() == null ? "" : booking.getBookingItems().get(i).getResortID());
        bookingItem.setRoomID(booking.getBookingItems().get(i).getRoomID() == null ? "" : booking.getBookingItems().get(i).getRoomID());
        bookingItem.setMealCombo(booking.getBookingItems().get(i).getMealCombo() != null && booking.getBookingItems().get(i).getMealCombo());
        bookingItem.setNights(booking.getBookingItems().get(i).getNights() == null ? 0 : booking.getBookingItems().get(i).getNights());
        bookingItem.setGuests(booking.getBookingItems().get(i).getGuests() == null ? 0 : booking.getBookingItems().get(i).getGuests());
        bookingItem.setStartDate(booking.getBookingItems().get(i).getStartDate() == null ? null : booking.getBookingItems().get(i).getStartDate());
        bookingItem.setEndDate(booking.getBookingItems().get(i).getEndDate() == null ? null : booking.getBookingItems().get(i).getEndDate());
        bookingItem.setTourID(booking.getBookingItems().get(i).getTourID() == null ? "" : booking.getBookingItems().get(i).getTourID());
        bookingItem.setNumberOfAdults(booking.getBookingItems().get(i).getNumberOfAdults() == null ? 0 : booking.getBookingItems().get(i).getNumberOfAdults());
        bookingItem.setNumberOfChildren(booking.getBookingItems().get(i).getNumberOfChildren() == null ? 0 : booking.getBookingItems().get(i).getNumberOfChildren());
        return bookingItem;
    }

    //chuyển từ 1 list booking item sang booking item dto
//    private static BookingItemDTO getBookingItemDTO(Booking booking, int i) {
//        BookingItemDTO bookingItemDTO = new BookingItemDTO();
//        //cần kiểm tra các thuộc tính có null không
//        bookingItemDTO.setId(booking.getBookingItems().get(i).getId() == null ? null : booking.getBookingItems().get(i).getId());
//        bookingItemDTO.setServiceType(booking.getBookingItems().get(i).getServiceType() == null ? "" : booking.getBookingItems().get(i).getServiceType());
//        bookingItemDTO.setFlightID(booking.getBookingItems().get(i).getFlightID() == null ? "" : booking.getBookingItems().get(i).getFlightID());
//        bookingItemDTO.setDepartureTime(booking.getBookingItems().get(i).getDepartureTime() == null ? null : booking.getBookingItems().get(i).getDepartureTime());
//        bookingItemDTO.setDuration(booking.getBookingItems().get(i).getDuration() == null ? 0 : booking.getBookingItems().get(i).getDuration());
//        bookingItemDTO.setSeatNumber(booking.getBookingItems().get(i).getSeatNumber() == null ? "" : booking.getBookingItems().get(i).getSeatNumber());
//        bookingItemDTO.setSeatType(booking.getBookingItems().get(i).getSeatType() == null ? "" : booking.getBookingItems().get(i).getSeatType());
//        bookingItemDTO.setResortID(booking.getBookingItems().get(i).getResortID() == null ? "" : booking.getBookingItems().get(i).getResortID());
//        bookingItemDTO.setRoomID(booking.getBookingItems().get(i).getRoomID() == null ? "" : booking.getBookingItems().get(i).getRoomID());
//        bookingItemDTO.setMealCombo(booking.getBookingItems().get(i).getMealCombo() != null && booking.getBookingItems().get(i).getMealCombo());
//        bookingItemDTO.setNights(booking.getBookingItems().get(i).getNights() == null ? 0 : booking.getBookingItems().get(i).getNights());
//        bookingItemDTO.setGuests(booking.getBookingItems().get(i).getGuests() == null ? 0 : booking.getBookingItems().get(i).getGuests());
//        bookingItemDTO.setStartDate(booking.getBookingItems().get(i).getStartDate() == null ? null : booking.getBookingItems().get(i).getStartDate());
//        bookingItemDTO.setEndDate(booking.getBookingItems().get(i).getEndDate() == null ? null : booking.getBookingItems().get(i).getEndDate());
//        bookingItemDTO.setTourID(booking.getBookingItems().get(i).getTourID() == null ? "" : booking.getBookingItems().get(i).getTourID());
//        bookingItemDTO.setNumberOfAdults(booking.getBookingItems().get(i).getNumberOfAdults() == null ? 0 : booking.getBookingItems().get(i).getNumberOfAdults());
//        bookingItemDTO.setNumberOfChildren(booking.getBookingItems().get(i).getNumberOfChildren() == null ? 0 : booking.getBookingItems().get(i).getNumberOfChildren());
//        return bookingItemDTO;
//    }
}
