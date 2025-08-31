package org.com.service;

import org.com.dataTransferObject.AirportRequestDTO;
import org.com.entity.AirportEntity;

import java.util.List;

public interface AirportServiceInterface {
    AirportEntity createAirport(AirportRequestDTO dto);
    List<AirportEntity> getAllAirports();
    AirportEntity getAirportById(String id);
    void deleteAirport(String id);
}
