package org.com.service;

import org.com.dto.ScheduleRequestDTO;
import org.com.dto.ScheduleResponseDTO;

import java.util.List;

public interface ScheduleServiceInterface {
    ScheduleResponseDTO createSchedule(ScheduleRequestDTO dto);
    ScheduleResponseDTO getScheduleById(String id);
    List<ScheduleResponseDTO> getAllSchedules();
    ScheduleResponseDTO updateSchedule(String id, ScheduleRequestDTO dto);
    void deleteSchedule(String id);
}
