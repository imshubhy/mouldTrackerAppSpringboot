package com.indoplast.DTO;

import java.time.LocalDate;

public class MouldUsageDTO {
    private Long logId;
    private Long mouldId;
    private int productionsMade;
    private LocalDate issueDate;
    private LocalDate returnDate;
    private String receiverName; // New field

    // Getters and setters
    public Long getLogId() {
        return logId;
    }

    public void setLogId(Long logId) {
        this.logId = logId;
    }

    public Long getMouldId() {
        return mouldId;
    }

    public void setMouldId(Long mouldId) {
        this.mouldId = mouldId;
    }

    public int getProductionsMade() {
        return productionsMade;
    }

    public void setProductionsMade(int productionsMade) {
        this.productionsMade = productionsMade;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }
}
