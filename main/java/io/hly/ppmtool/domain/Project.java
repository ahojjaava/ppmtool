package io.hly.ppmtool.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


import java.util.Date;
@Entity
public class Project {
    @Id
    @GeneratedValue
    private long id;
    @NotBlank(message = "Project Name is required.")
    private String projectName;
    @NotBlank(message = "Project Identifier is required.")
    @Size(min = 4, max = 5, message = "Please use 4 to 5 characters.")
    @Column(updatable = false, unique = true)
    private String projectIdentifier;
    @NotBlank(message = "Description is required.")
    private String description;
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date start_date;
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date end_date;

    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date create_date;
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date update_date;

    public Project() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectIdentifier() {
        return projectIdentifier;
    }

    public void setProjectIdentifier(String projectIdentifier) {
        this.projectIdentifier = projectIdentifier;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public Date getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(Date update_date) {
        this.update_date = update_date;
    }

    @PrePersist
    protected void onCreate(){
        this.create_date = new Date();
    }



    @PreUpdate
    protected void onUpdate(){
        this.update_date = new Date();
    }
}
