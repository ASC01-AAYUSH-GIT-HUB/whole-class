package org.com.service;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.com.dto.ScheduleRequestDTO;
import org.com.dto.ScheduleResponseDTO;
import org.com.entity.AirportEntity;
import org.com.entity.PlaneEntity;
import org.com.entity.ScheduleEntity;
import org.com.repository.AirportRepository;
import org.com.repository.PlaneRepository;
import org.com.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleServiceInterface {

    private final ScheduleRepository scheduleRepository;
    private final PlaneRepository planeRepository;
    private final AirportRepository airportRepository;

    private EntityManager entityManager;
    private String generateScheduleId(){
        Integer nextVal = (Integer) entityManager
                .createNativeQuery("SELECT NEXT VALUE FOR ScheduleSeq")
                .getSingleResult();
        return String.format("S%04d", nextVal);
    }

    @Override
    public ScheduleResponseDTO createSchedule(ScheduleRequestDTO dto) {
        PlaneEntity plane = planeRepository.findById(dto.getPlaneId())
                .orElseThrow(() -> new RuntimeException("Plane not found"));

        AirportEntity departure = airportRepository.findById(dto.getDepartureAirportId())
                .orElseThrow(() -> new RuntimeException("Departure Airport not found"));

        AirportEntity arrival = airportRepository.findById(dto.getArrivalAirportId())
                .orElseThrow(() -> new RuntimeException("Arrival Airport not found"));

        ScheduleEntity schedule = ScheduleEntity.builder()
                .scheduleId(generateScheduleId())
                .plane(plane)
                .departureAirport(departure)
                .arrivalAirport(arrival)
                .departureTime(dto.getDepartureTime())
                .arrivalTime(dto.getArrivalTime())
                .build();

        ScheduleEntity saved = scheduleRepository.save(schedule);
        return mapToResponse(saved);
    }

    @Override
    public ScheduleResponseDTO getScheduleById(String id) {
        return scheduleRepository.findById(id)
                .map(this::mapToResponse)
                .orElseThrow(() -> new RuntimeException("Schedule not found"));
    }

    @Override
    public List<ScheduleResponseDTO> getAllSchedules() {
        return scheduleRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ScheduleResponseDTO updateSchedule(String id, ScheduleRequestDTO dto) {
        ScheduleEntity existing = scheduleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Schedule not found"));

        PlaneEntity plane = planeRepository.findById(dto.getPlaneId())
                .orElseThrow(() -> new RuntimeException("Plane not found"));

        AirportEntity departure = airportRepository.findById(dto.getDepartureAirportId())
                .orElseThrow(() -> new RuntimeException("Departure Airport not found"));

        AirportEntity arrival = airportRepository.findById(dto.getArrivalAirportId())
                .orElseThrow(() -> new RuntimeException("Arrival Airport not found"));

        existing.setPlane(plane);
        existing.setDepartureAirport(departure);
        existing.setArrivalAirport(arrival);
        existing.setDepartureTime(dto.getDepartureTime());
        existing.setArrivalTime(dto.getArrivalTime());

        ScheduleEntity updated = scheduleRepository.save(existing);
        return mapToResponse(updated);
    }

    @Override
    public void deleteSchedule(String id) {
        if (!scheduleRepository.existsById(id)) {
            throw new RuntimeException("Schedule not found");
        }
        scheduleRepository.deleteById(id);
    }

    private ScheduleResponseDTO mapToResponse(ScheduleEntity schedule) {
        return ScheduleResponseDTO.builder()
                .scheduleId(schedule.getScheduleId())
                .planeId(schedule.getPlane().getPlaneId())
                .departureAirportId(schedule.getDepartureAirport().getAirportId())
                .arrivalAirportId(schedule.getArrivalAirport().getAirportId())
                .departureTime(schedule.getDepartureTime())
                .arrivalTime(schedule.getArrivalTime())
                .build();
    }
}