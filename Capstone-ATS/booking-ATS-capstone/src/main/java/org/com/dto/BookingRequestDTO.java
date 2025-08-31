package org.com.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingRequestDTO {
    private String scheduleId;
    private String passengerId;
    private String seatNumber;
    private String status;
}