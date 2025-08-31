package org.com.dataTransferObject;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class AirportRequestDTO {
    @NotBlank(message = "Airport name is required")
    private String name;

    @NotBlank(message = "City is required")
    private String city;

    @NotBlank(message = "Country is required")
    private String country;

    @NotBlank(message = "Airport code is required")
    @Pattern(regexp = "^[A-Z]{3,5}$", message = "Code must be 3-5 uppercase letters")
    private String code;
}
