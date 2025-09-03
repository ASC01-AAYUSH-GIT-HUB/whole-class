package org.com.dto;

import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
public class RegisterAdminDTO {
    private String name;
    @Email(message = "Invalid email format")
    private String email;
    private String phoneNo;
    private String password;
}
