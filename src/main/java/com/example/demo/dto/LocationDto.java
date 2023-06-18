package com.example.demo.dto;

public class LocationDto {
    private String id;
    private String name;
    private String detaleName;

    public String getDetaleName() {
        return detaleName;
    }

    public void setDetaleName(String detaleName) {
        this.detaleName = detaleName;
    }

    public String getId() {
        return id;

    }

    public void setIataCode(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
