package com.jobportal.jobportal.model;

import jakarta.persistence.*;

@Entity
@Table(name="jobs")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String location;
    private String description;
    private String requiredSkills;

    public Job(){
    }
    public Job(String title , String location , String description , String requiredSkills){
        this.title=title;
        this.location=location;
        this.description=description;
        this.requiredSkills=requiredSkills;
    }
    // getter and setter
    public Long getId(){
        return id;
    }
    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title=title;
    }
    public String getLocation(){
        return location;
    }
    public void setLocation(String location){
        this.location=location;
    }
    public String getDescription(){
        return description;
    }
    public void setDescription( String description){
        this.description=description;
    }
    public String getRequiredSkills(){
        return requiredSkills;
    }
    public void setRequiredSkills(String requiredSkills){
        this.requiredSkills=requiredSkills;
    }

}
