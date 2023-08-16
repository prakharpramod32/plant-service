package com.demo.plant.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Plant {

    @Id
    private String id;
    private String name;
}
