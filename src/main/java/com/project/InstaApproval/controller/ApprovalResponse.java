package com.project.InstaApproval.controller;

public class ApprovalResponse {
    private String message;
    private boolean isApproved;
    private Long customerId;

    public ApprovalResponse(String message, boolean isApproved, Long customerId) {
        this.message = message;
        this.isApproved = isApproved;
        this.customerId = customerId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
}