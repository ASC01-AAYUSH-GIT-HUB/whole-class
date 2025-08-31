package org.com.service;

import jakarta.persistence.EntityManager;
import org.com.dataTransferObject.AirportRequestDTO;
import org.com.entity.AirportEntity;
import org.com.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class AirportServiceImpl implements AirportServiceInterface{

    private final AirportRepository airportRepository;
    @Autowired
    public AirportServiceImpl(AirportRepository airportRepository){
        this.airportRepository=airportRepository;
    }

    private EntityManager entityManager;

    private String generateId() {
        Integer nextVal = (Integer) entityManager
                .createNativeQuery("SELECT NEXT VALUE FOR AirportSeq")
                .getSingleResult();

        return String.format("A%04d", nextVal);
    }

    @Override
    public AirportEntity createAirport(AirportRequestDTO dto) {
        if (airportRepository.existsByCode(dto.getCode())) {
            throw new IllegalArgumentException("Airport code already exists");
        }

        AirportEntity entity = AirportEntity.builder()
                .airportId(generateId())
                .name(dto.getName())
                .city(dto.getCity())
                .country(dto.getCountry())
                .code(dto.getCode())
                .build();

        return airportRepository.save(entity);
    }

    @Override
    public List<AirportEntity> getAllAirports() {
        return airportRepository.findAll();
    }

    @Override
    public AirportEntity getAirportById(String id) {
        return airportRepository.findById(id).orElseThrow(()->new RuntimeException("Airport not found with id: " + id));
    }

    @Override
    public void deleteAirport(String id) {
        if(!airportRepository.existsById(id)){
            throw new RuntimeException("Airport not found with id: " + id);
        }
        airportRepository.deleteById(id);
    }
}
