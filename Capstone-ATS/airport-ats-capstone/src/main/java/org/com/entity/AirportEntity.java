package org.com.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "airports")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AirportEntity {

    @Id
    @Column(name = "airport_id", nullable = false, updatable = false, unique = true)
    private String airportId; // Format A0001

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false, unique = true, length = 5)
    private String code; // IATA/ICAO
}