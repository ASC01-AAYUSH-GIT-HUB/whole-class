package org.com.service;

import org.com.dto.PassengerDTO;
import org.com.entity.PassengerEntity;

import java.util.List;

public interface PassengerServiceInterface {
    PassengerEntity createPassenger(PassengerDTO passengerDTO);
    PassengerEntity getPassengerById(String passengerId);
    List<PassengerEntity> getAllPassengers();
    PassengerEntity updatePassenger(String passengerId, PassengerDTO passengerDTO);
    void deletePassenger(String passengerId);
}