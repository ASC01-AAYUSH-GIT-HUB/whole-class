package org.com.service;

import org.com.dto.PlaneDTO;
import org.com.entity.PlaneEntity;

import java.util.List;

public interface PlaneServiceInterface {

    PlaneEntity addPlane(PlaneDTO planeDTO);

    PlaneEntity getPlaneById(String planeId);

    List<PlaneEntity> getAllPlanes();

    PlaneEntity updatePlane(String planeId, PlaneDTO planeDTO);

    void deletePlane(String planeId);
}
