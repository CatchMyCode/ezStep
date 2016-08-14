package com.catchmycode.ezstep.data.model;


import com.catchmycode.ezstep.config.DataConfig;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TESTER", schema = DataConfig.SCHEMA)
public class Tester {

    @Id
    @SequenceGenerator(name = "seq_gen", sequenceName = "seq_gen", allocationSize = 1, schema = DataConfig.SCHEMA)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_gen")
    @Column(name = "ID")
    private long id;

    @Column(name = "NAME")
    private String name;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATED_TIME")
    private Date createdTime;

    public Tester() {}

    public Tester(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
