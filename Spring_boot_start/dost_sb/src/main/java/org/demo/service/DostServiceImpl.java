package org.demo.service;

import org.demo.entity.DostEntity;
import org.demo.repo.DostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
@Service
public class DostServiceImpl implements DostService{
    private final DostRepo dostRepo;

    @Autowired
    public DostServiceImpl(DostRepo dostRepo){
        this.dostRepo=dostRepo;
    }
    @Override
    public DostEntity addDost(DostEntity dostEntity) {

        System.err.println("starting");
        System.out.println(dostEntity.getFirstName()+dostEntity.getLastName()+dostEntity.getEmail()+dostEntity.getAge());
        return dostRepo.save(dostEntity);
    }

    @Override
    public DostEntity getDost(Long id) {
        return dostRepo.findById(id).get();
    }

    @Override
    public List<DostEntity> getAllDost() {
        return dostRepo.findAll();
    }

    @Override
    public DostEntity updateDost(Long id,DostEntity nayaDost) {
        DostEntity dostEntity=dostRepo.getById(id);
        dostEntity.setFirstName(nayaDost.getFirstName());
        dostEntity.setLastName(nayaDost.getLastName());
        dostEntity.setAge(nayaDost.getAge());
        dostEntity.setEmail(nayaDost.getEmail());
        return dostRepo.save(dostEntity);
    }

    @Override
    public void deleteDost(Long id) {
        dostRepo.deleteById(id);
    }

    @Override
    public void deleteAll() {
        dostRepo.deleteAll();
    }
}
