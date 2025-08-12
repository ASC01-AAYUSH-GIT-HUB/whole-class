package org.demo.service;

import org.demo.entity.DostEntity;

import java.util.List;

public interface DostService {
    DostEntity addDost(DostEntity dostEntity);
    DostEntity getDost(Long id);
    List<DostEntity> getAllDost();
    DostEntity updateDost(Long id,DostEntity nayaDost);
    void deleteDost(Long id);
    void deleteAll();
}
