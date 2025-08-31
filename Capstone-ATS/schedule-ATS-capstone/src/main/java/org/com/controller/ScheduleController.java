package org.com.controller;

import lombok.RequiredArgsConstructor;
import org.com.dto.ScheduleRequestDTO;
import org.com.dto.ScheduleResponseDTO;
import org.com.service.ScheduleServiceInterface;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ats/schedules")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleServiceInterface scheduleService;

    @PostMapping("/create")
    public ResponseEntity<ScheduleResponseDTO> create(@RequestBody ScheduleRequestDTO dto) {
        return ResponseEntity.ok(scheduleService.createSchedule(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScheduleResponseDTO> getById(@PathVariable String id) {
        return ResponseEntity.ok(scheduleService.getScheduleById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ScheduleResponseDTO>> getAll() {
        return ResponseEntity.ok(scheduleService.getAllSchedules());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ScheduleResponseDTO> update(
            @PathVariable String id,
            @RequestBody ScheduleRequestDTO dto) {
        return ResponseEntity.ok(scheduleService.updateSchedule(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        scheduleService.deleteSchedule(id);
        return ResponseEntity.ok("Schedule deleted successfully");
    }
}
