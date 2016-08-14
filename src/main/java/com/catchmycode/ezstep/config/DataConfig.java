package com.catchmycode.ezstep.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = "com.catchmycode.ezstep.data.model")
@EnableJpaRepositories(basePackages = "com.catchmycode.ezstep.data.dao")
public class DataConfig {

    public static final String SCHEMA = "ezstep";
}
