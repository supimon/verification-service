package com.supimon.verificationservice.models;

public class VerificationModel {

    private boolean verified;
    private String userId;

    public VerificationModel(boolean verified, String userId) {
        this.verified = verified;
        this.userId = userId;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
