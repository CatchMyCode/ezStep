package com.catchmycode.ezstep.data.model;

import com.catchmycode.ezstep.config.DataConfig;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.*;
import java.io.IOException;
import java.util.Date;

@Entity
@Table(name = "TEST_STEP", schema = DataConfig.SCHEMA)
public class Step {

    @Id
    @SequenceGenerator(name = "seq_gen", sequenceName = "seq_gen", allocationSize = 1, schema = DataConfig.SCHEMA)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_gen")
    @Column(name = "ID")
    private long id;

    @Column(name = "AUTHOR")
    private long testerID;

    @Column(name = "PROJECT")
    private long projectID;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "DESCRIPTION")
    private String description;

    @Lob
    @Column(name = "STEP")
    private String step;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATED_TIME")
    private Date createdTime;

    public Step() {}

    public long getId() {
        return id;
    }

    public long getTesterID() {
        return testerID;
    }

    public void setTesterID(long testerID) {
        this.testerID = testerID;
    }

    public long getProjectID() {
        return projectID;
    }

    public void setProjectID(long projectID) {
        this.projectID = projectID;
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

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;
    }

    public JsonNode getJson() {

        JsonNode json = null;

        try {

            json = new ObjectMapper().readTree(step);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }

    public void setJson(JsonNode step) {

        try {

            this.step = new ObjectMapper().writeValueAsString(step);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    @PrePersist
    private void preSave() {
        this.createdTime = new Date();
    }
}
