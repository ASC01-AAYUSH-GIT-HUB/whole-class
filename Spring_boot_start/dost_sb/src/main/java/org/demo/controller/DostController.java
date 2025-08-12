package org.demo.controller;

import org.demo.entity.DostEntity;
import org.demo.service.DostService;
import org.demo.service.DostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dost")

public class DostController {
    private final DostService dostService;
    @Autowired
    public DostController(DostService dostService){
        this.dostService=dostService;
    }

    @GetMapping("/goodDost")
    List<DostEntity> getAllDost(){
        return dostService.getAllDost();
    }

    @GetMapping("/{id}")
    DostEntity getDostById(@PathVariable Long id){
        return dostService.getDost(id);
    }
    @PostMapping("/addDost")
    DostEntity addingDost(@RequestBody DostEntity dost){
        return dostService.addDost(dost);
    }
    @DeleteMapping("/delete{id}")
    void deleteDost(@PathVariable Long id){
        dostService.deleteDost(id);
    }

    void deleteAllDost(){
        dostService.deleteAll();
    }
    @PutMapping("/update{id}")
    DostEntity updatingDost(@PathVariable Long id,@RequestBody DostEntity updateDost){
        return dostService.updateDost(id,updateDost);
    }
}
