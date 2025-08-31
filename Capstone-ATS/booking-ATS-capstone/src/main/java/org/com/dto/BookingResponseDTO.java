package org.com.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookingResponseDTO {
    private String bookingId;
    private String scheduleId;
    private String passengerId;
    private String seatNumber;
    private String status;
}
