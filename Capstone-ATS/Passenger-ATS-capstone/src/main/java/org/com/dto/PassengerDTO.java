package org.com.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PassengerDTO {

    @NotBlank(message = "First name is required")
    private String firstName;

    @NotBlank(message = "Last name is required")
    private String lastName;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
    private String email;

    @Pattern(regexp = "^[0-9]{10}$", message = "Phone must be 10 digits")
    private String phone;
}