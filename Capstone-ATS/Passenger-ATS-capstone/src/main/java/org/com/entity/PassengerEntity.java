package org.com.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "passengers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PassengerEntity {

    @Id
    @Column(name = "passenger_id", nullable = false, unique = true)
    private String passengerId;   // e.g. P0001

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "phone", nullable = false, unique = true)
    private String phone;
}