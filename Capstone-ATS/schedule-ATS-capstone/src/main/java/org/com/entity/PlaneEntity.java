package org.com.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "planes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlaneEntity {

    @Id
    @Column(name = "plane_id", nullable = false, unique = true)
    private String planeId;   // Format P0001

    @Column(name = "plane_name", nullable = false)
    private String planeName;

    @Column(name = "model", nullable = false)
    private String model;

    @Column(name = "capacity", nullable = false)
    private int capacity;
}