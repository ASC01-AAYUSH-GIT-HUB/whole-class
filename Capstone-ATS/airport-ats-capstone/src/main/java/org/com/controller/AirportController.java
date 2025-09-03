package org.com.controller;

import jakarta.validation.Valid;
import org.com.dataTransferObject.AirportRequestDTO;
import org.com.entity.AirportEntity;
import org.com.service.AirportServiceImpl;
import org.com.service.AirportServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ats/airport")

public class AirportController {
    private final AirportServiceInterface airportService;
    @Autowired
    public AirportController(AirportServiceImpl airportService){
        this.airportService=airportService;
    }

    @PostMapping("/create")
    public ResponseEntity<AirportEntity> createAirport(@Valid @RequestBody AirportRequestDTO dto) {
        return ResponseEntity.ok(airportService.createAirport(dto));
    }

    @GetMapping("/all")
    public ResponseEntity<List<AirportEntity>> getAllAirports() {
        return ResponseEntity.ok(airportService.getAllAirports());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AirportEntity> getAirportById(@PathVariable String id) {
        return ResponseEntity.ok(airportService.getAirportById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAirport(@PathVariable String id) {
        airportService.deleteAirport(id);
        return ResponseEntity.noContent().build();
    }
}
