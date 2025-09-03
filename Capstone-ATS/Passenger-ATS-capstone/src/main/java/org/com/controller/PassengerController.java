package org.com.controller;

import jakarta.validation.Valid;
import org.com.dto.PassengerDTO;
import org.com.entity.PassengerEntity;
import org.com.service.PassengerServiceImpl;
import org.com.service.PassengerServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ats/passengers")

public class PassengerController {

    private final PassengerServiceInterface passengerService;
    @Autowired
    public PassengerController(PassengerServiceImpl passengerService){
        this.passengerService=passengerService;
    }

    @PostMapping("/create")
    public ResponseEntity<PassengerEntity> createPassenger(@Valid @RequestBody PassengerDTO passengerDTO) {
        return ResponseEntity.ok(passengerService.createPassenger(passengerDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PassengerEntity> getPassengerById(@PathVariable String id) {
        return ResponseEntity.ok(passengerService.getPassengerById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<PassengerEntity>> getAllPassengers() {

        return ResponseEntity.ok(passengerService.getAllPassengers());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PassengerEntity> updatePassenger(@PathVariable String id,
                                                           @Valid @RequestBody PassengerDTO passengerDTO) {
        return ResponseEntity.ok(passengerService.updatePassenger(id, passengerDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePassenger(@PathVariable String id) {
        passengerService.deletePassenger(id);
        return ResponseEntity.noContent().build();
    }
}
