package com.demo.plant.exception;

public class PlantNameInvalidException extends Exception {

    private String message;

    public PlantNameInvalidException(String message) {
        super();
        this.message = message;
    }
}
