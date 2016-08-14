package com.catchmycode.ezstep.data.model;

import com.catchmycode.ezstep.config.DataConfig;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PROJECT", schema = DataConfig.SCHEMA)
public class Project {

    @Id
    @SequenceGenerator(name = "seq_gen", sequenceName = "seq_gen", allocationSize = 1, schema = DataConfig.SCHEMA)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_gen")
    @Column(name = "ID")
    private long id;

    @Column(name = "PROJECT_NAME")
    private String projectName;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATED_TIME")
    private Date createdTime;

    public Project() {}

    public Project(String projectName) {
        this.projectName = projectName;
    }

    public long getId() {
        return id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
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
