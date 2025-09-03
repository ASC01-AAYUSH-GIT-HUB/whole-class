package org.com.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.com.dto.PlaneDTO;
import org.com.entity.PlaneEntity;
import org.com.repository.PlaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class PlaneServiceImpl implements PlaneServiceInterface{

    private final PlaneRepository planeRepository;
    @Autowired
    public PlaneServiceImpl(PlaneRepository planeRepository){
        this.planeRepository=planeRepository;
    }
    @Override
    public PlaneEntity addPlane(PlaneDTO planeDTO) {
        PlaneEntity plane = PlaneEntity.builder()
                .planeId(generatePlaneId())
                .planeName(planeDTO.getPlaneName())
                .model(planeDTO.getModel())
                .capacity(planeDTO.getCapacity())
                .build();
        return planeRepository.save(plane);
    }
    @PersistenceContext
    private EntityManager entityManager;
    private String generatePlaneId() {
        Number nextVal = (Number) entityManager
                .createNativeQuery("SELECT NEXT VALUE FOR FlightSeq")
                .getSingleResult();
        return String.format("F%04d", nextVal);
    }

    @Override
    public PlaneEntity getPlaneById(String planeId) {
        return planeRepository.findById(planeId)
                .orElseThrow(() -> new RuntimeException("Plane not found with ID: " + planeId));
    }

    @Override
    public List<PlaneEntity> getAllPlanes() {
        return planeRepository.findAll();
    }

    @Override
    public PlaneEntity updatePlane(String planeId, PlaneDTO planeDTO) {
        PlaneEntity existing = getPlaneById(planeId);
        existing.setPlaneName(planeDTO.getPlaneName());
        existing.setModel(planeDTO.getModel());
        existing.setCapacity(planeDTO.getCapacity());
        return planeRepository.save(existing);
    }

    @Override
    public void deletePlane(String planeId) {
        planeRepository.deleteById(planeId);
    }
}
