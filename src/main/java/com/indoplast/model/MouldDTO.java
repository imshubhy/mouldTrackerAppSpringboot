package com.indoplast.model;


import java.time.format.DateTimeFormatter;

public class MouldDTO {

    private Long id;
    private String name;
    private String manufacturer;
    private String location;
    private int totalProductions;
    private String lastMaintenanceDate;

    public MouldDTO(Mould mould) {
        this.id = mould.getId();
        this.name = mould.getName();
        this.manufacturer = mould.getManufacturer();
        this.location = mould.getLocation();
        this.totalProductions = mould.getTotalProductions();
        this.lastMaintenanceDate = mould.getLastMaintenanceDate().format(DateTimeFormatter.ISO_DATE);
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getTotalProductions() {
        return totalProductions;
    }

    public void setTotalProductions(int totalProductions) {
        this.totalProductions = totalProductions;
    }

    public String getLastMaintenanceDate() {
        return lastMaintenanceDate;
    }

    public void setLastMaintenanceDate(String lastMaintenanceDate) {
        this.lastMaintenanceDate = lastMaintenanceDate;
    }
}
