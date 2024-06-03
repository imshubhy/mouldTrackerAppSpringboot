package com.indoplast.model;

import java.time.LocalDateTime;


public class MouldUsageDTO {

    private Long id;
    private MouldDTO mould;
    private LocalDateTime takenAt;
    private LocalDateTime returnedAt;
    private int productions;

    public MouldUsageDTO(MouldUsage mouldUsage) {
        this.id = mouldUsage.getId();
        this.mould = new MouldDTO(mouldUsage.getMould());
        this.takenAt = mouldUsage.getTakenAt();
        this.returnedAt = mouldUsage.getReturnedAt();
        this.productions = mouldUsage.getProductions();
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MouldDTO getMould() {
        return mould;
    }

    public void setMould(MouldDTO mould) {
        this.mould = mould;
    }

    public LocalDateTime getTakenAt() {
        return takenAt;
    }

    public void setTakenAt(LocalDateTime takenAt) {
        this.takenAt = takenAt;
    }

    public LocalDateTime getReturnedAt() {
        return returnedAt;
    }

    public void setReturnedAt(LocalDateTime returnedAt) {
        this.returnedAt = returnedAt;
    }

    public int getProductions() {
        return productions;
    }

    public void setProductions(int productions) {
        this.productions = productions;
    }
}

