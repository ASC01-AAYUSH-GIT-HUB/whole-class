package org.com.controller;

import lombok.RequiredArgsConstructor;
import org.com.dto.BookingRequestDTO;
import org.com.dto.BookingResponseDTO;
import org.com.service.BookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ats/bookings")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @PostMapping("/initiate")
    public ResponseEntity<BookingResponseDTO> createBooking(@RequestBody BookingRequestDTO dto) {
        return ResponseEntity.ok(bookingService.createBooking(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookingResponseDTO> getBookingById(@PathVariable String id) {
        return ResponseEntity.ok(bookingService.getBookingById(id));
    }

    @GetMapping
    public ResponseEntity<List<BookingResponseDTO>> getAllBookings() {
        return ResponseEntity.ok(bookingService.getAllBookings());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable String id) {
        bookingService.deleteBooking(id);
        return ResponseEntity.noContent().build();
    }
}