package com.jobportal.jobportal.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class JobRequestDTO {
    @NotBlank(message = "title is required")
    private String title;
    @NotBlank(message = "location is required")
    private String location;
    @NotBlank(message = "description is required")
    @Size(min = 10 , message = "Description must be at least 10 character")
    private String description;
    @NotBlank(message = "skills are required")
    private String requiredSkills;

    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title=title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRequiredSkills() {
        return requiredSkills;
    }

    public void setRequiredSkills(String requiredSkills) {
        this.requiredSkills = requiredSkills;
    }
}
