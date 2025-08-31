package org.com.dto;

import lombok.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ScheduleResponseDTO {
    private String scheduleId;
    private String planeId;
    private String departureAirportId;
    private String arrivalAirportId;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
}