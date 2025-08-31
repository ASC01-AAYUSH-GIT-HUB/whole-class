package org.com.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "bookings")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookingEntity {

    @Id
    @Column(name = "booking_id")
    private String bookingId;  // Will be set in service layer

    @ManyToOne
    @JoinColumn(name = "schedule_id", nullable = false)
    private ScheduleEntity schedule;

    @ManyToOne
    @JoinColumn(name = "passenger_id", nullable = false)
    private PassengerEntity passenger;

    @Column(name = "seat_number", nullable = false)
    private String seatNumber;

    @Column(name = "status", nullable = false)
    private String status;  // e.g., "CONFIRMED", "CANCELLED"
}