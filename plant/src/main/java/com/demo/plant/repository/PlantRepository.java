package com.demo.plant.repository;

import com.demo.plant.model.Plant;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlantRepository extends MongoRepository<Plant, String> {
    public Optional<Plant> findByName(String name);
}
