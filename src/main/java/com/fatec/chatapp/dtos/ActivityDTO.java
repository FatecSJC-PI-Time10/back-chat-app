package com.fatec.chatapp.dtos;

import java.util.UUID;

public class ActivityDTO {
    private UUID userId;
    private String title;
    private String date;
    private String description;
    private Boolean isActive;

    public ActivityDTO() {
    }

    public ActivityDTO(UUID userId, String title, String description, Boolean isActive, String date) {
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.isActive = isActive;
        this.date = date;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean active) {
        isActive = active;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
