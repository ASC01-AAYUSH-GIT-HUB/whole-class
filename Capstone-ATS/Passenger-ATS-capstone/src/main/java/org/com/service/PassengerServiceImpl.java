package org.com.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.com.dto.PassengerDTO;
import org.com.entity.PassengerEntity;
import org.com.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class PassengerServiceImpl implements PassengerServiceInterface {

    private final PassengerRepository passengerRepository;
    @Autowired
    public PassengerServiceImpl(PassengerRepository passengerRepository){
        this.passengerRepository=passengerRepository;
    }
    @PersistenceContext
    private EntityManager entityManager;  // simple ID generator for demo

    private String generatePassengerId() {
        Number nextVal = (Number) entityManager
                .createNativeQuery("SELECT NEXT VALUE FOR PassengerSeq")
                .getSingleResult();
        return String.format("P%04d", nextVal);
    }

    @Override
    public PassengerEntity createPassenger(PassengerDTO passengerDTO) {
        if (passengerRepository.existsByEmail(passengerDTO.getEmail())) {
            throw new RuntimeException("Email already exists");
        }
        if (passengerRepository.existsByPhone(passengerDTO.getPhone())) {
            throw new RuntimeException("Phone already exists");
        }

        PassengerEntity passenger = PassengerEntity.builder()
                .passengerId(generatePassengerId())
                .firstName(passengerDTO.getFirstName())
                .lastName(passengerDTO.getLastName())
                .email(passengerDTO.getEmail())
                .phone(passengerDTO.getPhone())
                .build();

        return passengerRepository.save(passenger);
    }

    @Override
    public PassengerEntity getPassengerById(String passengerId) {
        return passengerRepository.findById(passengerId)
                .orElseThrow(() -> new RuntimeException("Passenger not found"));
    }

    @Override
    public List<PassengerEntity> getAllPassengers() {
        return passengerRepository.findAll();
    }

    @Override
    public PassengerEntity updatePassenger(String passengerId, PassengerDTO passengerDTO) {
        PassengerEntity existing = getPassengerById(passengerId);

        existing.setFirstName(passengerDTO.getFirstName());
        existing.setLastName(passengerDTO.getLastName());
        existing.setEmail(passengerDTO.getEmail());
        existing.setPhone(passengerDTO.getPhone());

        return passengerRepository.save(existing);
    }

    @Override
    public void deletePassenger(String passengerId) {
        PassengerEntity existing = getPassengerById(passengerId);
        passengerRepository.delete(existing);
    }
}
