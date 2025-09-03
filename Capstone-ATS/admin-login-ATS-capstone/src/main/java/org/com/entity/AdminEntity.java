package org.com.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "admins")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdminEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;  // loginId

    @Column(nullable = false)
    private String password;

    @Column(nullable = false,unique = true)
    private String phoneNo;

    private int failedAttempts = 0;

    private boolean accountLocked = false;

    private LocalDateTime lockTime;

}
