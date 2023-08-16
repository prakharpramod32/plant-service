package com.demo.plant.service;

import com.demo.plant.exception.PlantNameInvalidException;
import com.demo.plant.model.Plant;
import com.demo.plant.repository.PlantRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PlantService {
    @Autowired
    PlantRepository plantRepository;

    public Plant insertPlant(Plant plant) throws PlantNameInvalidException {
        if (validatePlant(plant))
            return plantRepository.save(plant);
        else {
            log.error("Plant not not valid");
            throw new PlantNameInvalidException("Plant name is invalid");
        }
    }

    private boolean validatePlant(Plant plant) {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return plant.getName().equals("ICF");
    }

    public Plant getPlant(String name) {
        return plantRepository.findByName(name).orElse(null);
    }
}
