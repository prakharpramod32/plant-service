package com.demo.plant.controller;

import com.demo.plant.exception.PlantNameInvalidException;
import com.demo.plant.model.Plant;
import com.demo.plant.service.PlantService;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/plant")
@Slf4j
public class PlantController {

    @Autowired
    PlantService plantService;

    @PostMapping("/insertPlant")
    public ResponseEntity insertPlant(@RequestBody Plant plant) {
        log.info("received request to create new Plant: {}", plant);
        try {
            val createdPlant = plantService.insertPlant(plant);
            return new ResponseEntity<>(createdPlant, HttpStatus.CREATED);
        } catch (PlantNameInvalidException exception) {
            log.error("Plant name invalid");
            return new ResponseEntity<>("plant name invalid", HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/getPlant/{name}")
    public Plant getPlant(@PathVariable String name) {
        log.info("Received request to get plant details with name: {}", name);
        return plantService.getPlant(name);
    }


}
