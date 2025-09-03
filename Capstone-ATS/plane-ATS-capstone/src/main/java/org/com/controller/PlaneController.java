package org.com.controller;

import jakarta.validation.Valid;
import org.com.dto.PlaneDTO;
import org.com.entity.PlaneEntity;
import org.com.service.PlaneServiceImpl;
import org.com.service.PlaneServiceInterface;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/ats/plane")

public class PlaneController {
    private final PlaneServiceInterface planeService;
    public PlaneController(PlaneServiceImpl planeService){
        this.planeService=planeService;
    }

    @PostMapping("/add")
    public ResponseEntity<PlaneEntity> addPlane(@Valid @RequestBody PlaneDTO planeDTO) {
        return ResponseEntity.ok(planeService.addPlane(planeDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlaneEntity> getPlaneById(@PathVariable String id) {
        return ResponseEntity.ok(planeService.getPlaneById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<PlaneEntity>> getAllPlanes() {
        return ResponseEntity.ok(planeService.getAllPlanes());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlaneEntity> updatePlane(
            @PathVariable String id,
            @Valid @RequestBody PlaneDTO planeDTO) {
        return ResponseEntity.ok(planeService.updatePlane(id, planeDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePlane(@PathVariable String id) {
        planeService.deletePlane(id);
        return ResponseEntity.ok("Plane deleted with ID: " + id);
    }
}
