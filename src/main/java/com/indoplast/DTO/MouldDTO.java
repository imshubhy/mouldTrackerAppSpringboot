package com.indoplast.DTO;

import java.time.LocalDate;

public class MouldDTO {
    private Long id;
    private String name;
    private String manufacturer;
    private String location;
    private LocalDate lastMaintenanceDate;
    private int totalProductionsMade; // Field to store total productions made

    // Getters and setters

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

    public LocalDate getLastMaintenanceDate() {
        return lastMaintenanceDate;
    }

    public void setLastMaintenanceDate(LocalDate lastMaintenanceDate) {
        this.lastMaintenanceDate = lastMaintenanceDate;
    }

    public int getTotalProductionsMade() {
        return totalProductionsMade;
    }

    public void setTotalProductionsMade(int totalProductionsMade) {
        this.totalProductionsMade = totalProductionsMade;
    }
}
