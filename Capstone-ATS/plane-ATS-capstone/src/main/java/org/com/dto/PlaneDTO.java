package org.com.dto;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlaneDTO {

    private String planeId; // Generated automatically in service

    @NotBlank(message = "Plane name cannot be blank")
    private String planeName;

    @NotBlank(message = "Model cannot be blank")
    private String model;

    @Min(value = 1, message = "Capacity must be greater than 0")
    private int capacity;
}
