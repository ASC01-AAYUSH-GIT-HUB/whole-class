package org.com.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "schedules")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ScheduleEntity {

    @Id
    @Column(name = "schedule_id", nullable = false, unique = true)
    private String scheduleId;   // e.g., S0001

    @ManyToOne
    @JoinColumn(name = "plane_id", referencedColumnName = "plane_id", nullable = false)
    private PlaneEntity plane;   // Foreign key to planes

    @ManyToOne
    @JoinColumn(name = "departure_airport_id", referencedColumnName = "airport_id", nullable = false)
    private AirportEntity departureAirport;   // Foreign key to airports

    @ManyToOne
    @JoinColumn(name = "arrival_airport_id", referencedColumnName = "airport_id", nullable = false)
    private AirportEntity arrivalAirport;   // Foreign key to airports

    @Column(name = "departure_time", nullable = false)
    private LocalDateTime departureTime;

    @Column(name = "arrival_time", nullable = false)
    private LocalDateTime arrivalTime;
}