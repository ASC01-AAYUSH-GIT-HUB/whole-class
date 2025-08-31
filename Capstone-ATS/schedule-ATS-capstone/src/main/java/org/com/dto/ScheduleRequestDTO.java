package org.com.dto;

import lombok.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleRequestDTO {
//    private String scheduleId;
    private String planeId;
    private String departureAirportId;
    private String arrivalAirportId;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
}
