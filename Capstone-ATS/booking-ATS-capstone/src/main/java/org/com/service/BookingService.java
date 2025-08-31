package org.com.service;

import org.com.dto.BookingRequestDTO;
import org.com.dto.BookingResponseDTO;

import java.util.List;

public interface BookingService {
    BookingResponseDTO createBooking(BookingRequestDTO dto);
    BookingResponseDTO getBookingById(String bookingId);
    List<BookingResponseDTO> getAllBookings();
    void deleteBooking(String bookingId);
}
//BookingServiceInterface
