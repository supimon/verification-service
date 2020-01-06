package com.supimon.verificationservice.models;

public class VerificationModel {

    private Boolean verified;
    private String userId;

    public VerificationModel() {
    }

    public VerificationModel(Boolean verified, String userId) {
        this.verified = verified;
        this.userId = userId;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
