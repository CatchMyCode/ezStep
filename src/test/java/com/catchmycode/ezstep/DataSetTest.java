package com.catchmycode.ezstep;

import com.catchmycode.ezstep.config.ApplicationConfig;
import com.catchmycode.ezstep.data.dao.ProjectRepo;
import com.catchmycode.ezstep.data.dao.StepRepo;
import com.catchmycode.ezstep.data.dao.TesterRepo;
import com.catchmycode.ezstep.data.mapping.StepData;
import com.catchmycode.ezstep.data.model.Project;

import com.catchmycode.ezstep.data.model.Step;
import com.catchmycode.ezstep.data.model.Tester;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

import org.testng.annotations.*;
import org.testng.annotations.Test;

import java.io.File;

import static org.testng.Assert.*;

@SpringBootTest(classes = {ApplicationConfig.class})
@TestPropertySource(locations = {"classpath:config/application.properties","classpath:config/test.properties"})
public class DataSetTest extends AbstractTestNGSpringContextTests {

    Tester tester;
    Project project;
    StepData stepData;

    @Autowired private TesterRepo testerRepo;
    @Autowired private ProjectRepo projectRepo;
    @Autowired private StepRepo stepRepo;

    @BeforeTest
    public void setUp() throws Exception {

        tester = new Tester("Patrick");
        project = new Project("DRMS");
        stepData = new ObjectMapper().readValue(new File("src/test/resources/data/stepdata.json"), StepData.class);
    }

    @Test
    public void testTesterAndProjectPersistence() {

        testerRepo.save(tester);
        projectRepo.save(project);

        assertEquals(tester.getId(), 1);
        assertEquals(project.getId(), 1);
    }

    @Test(dependsOnMethods = {"testTesterAndProjectPersistence"})
    public void testStepPersistenceWithJson() {

        Step step = new Step();
        step.setTesterID(tester.getId());
        step.setProjectID(project.getId());
        step.setTitle(stepData.getTitle());
        step.setDescription(stepData.getDescription());
        step.setJson(stepData.toJson());
        stepRepo.save(step);

        assertEquals(step.getId(), 1);
    }

    @Test(dependsOnMethods = {"testTesterAndProjectPersistence"})
    public void testStepPersistenceWithString() {

        Step step = new Step();
        step.setTesterID(tester.getId());
        step.setProjectID(project.getId());

        stepData.setTitle("New Title for Login");
        step.setTitle(stepData.getTitle());

        stepData.setDescription("New Descriptin for Login");
        step.setDescription(stepData.getDescription());
        step.setStep(stepData.toString());
        stepRepo.save(step);

        assertEquals(step.getId(), 2);
    }
}
