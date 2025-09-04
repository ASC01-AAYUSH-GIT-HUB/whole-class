package org.com.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.com.dto.BookingRequestDTO;
import org.com.dto.BookingResponseDTO;
import org.com.entity.BookingEntity;
import org.com.entity.PassengerEntity;
import org.com.entity.ScheduleEntity;
import org.com.repository.BookingRepository;
import org.com.repository.PassengerRepository;
import org.com.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final ScheduleRepository scheduleRepository;
    private final PassengerRepository passengerRepository;

    // Generate Booking ID in format B0001, B0002...
    @PersistenceContext
    private EntityManager entityManager;

    private String generateBookingId() {
        Number nextVal = (Number) entityManager
                .createNativeQuery("SELECT NEXT VALUE FOR BookingSeq")
                .getSingleResult();
        return String.format("B%04d", nextVal);
    }

    @Override
    public BookingResponseDTO createBooking(BookingRequestDTO dto) {
        ScheduleEntity schedule = scheduleRepository.findById(dto.getScheduleId())
                .orElseThrow(() -> new RuntimeException("Schedule not found"));
        PassengerEntity passenger = passengerRepository.findById(dto.getPassengerId())
                .orElseThrow(() -> new RuntimeException("Passenger not found"));

        BookingEntity booking = BookingEntity.builder()
                .bookingId(generateBookingId())
                .schedule(schedule)
                .passenger(passenger)
                .seatNumber(dto.getSeatNumber())
                .status(dto.getStatus())
                .build();

        bookingRepository.save(booking);

        return BookingResponseDTO.builder()
                .bookingId(booking.getBookingId())
                .scheduleId(schedule.getScheduleId())
                .passengerId(passenger.getPassengerId())
                .seatNumber(booking.getSeatNumber())
                .status(booking.getStatus())
                .build();
    }

    @Override
    public BookingResponseDTO getBookingById(String bookingId) {
        BookingEntity booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
        return new BookingResponseDTO(
                booking.getBookingId(),
                booking.getSchedule().getScheduleId(),
                booking.getPassenger().getPassengerId(),
                booking.getSeatNumber(),
                booking.getStatus()
        );
    }

    @Override
    public List<BookingResponseDTO> getAllBookings() {
        return bookingRepository.findAll().stream()
                .map(b -> new BookingResponseDTO(
                        b.getBookingId(),
                        b.getSchedule().getScheduleId(),
                        b.getPassenger().getPassengerId(),
                        b.getSeatNumber(),
                        b.getStatus()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteBooking(String bookingId) {
        bookingRepository.deleteById(bookingId);
    }
}