package com.catchmycode.ezstep.data.mapping;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;
import java.util.List;

public class StepData {

    private String title;
    private String description;
    private List<Instruction> instructions;
    private String expectation;

    public StepData() {}

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

    public List<Instruction> getInstructions() {
        return instructions;
    }

    public void setInstructions(List<Instruction> instructions) {
        this.instructions = instructions;
    }

    public String getExpectation() {
        return expectation;
    }

    public void setExpectation(String expectation) {
        this.expectation = expectation;
    }

    public JsonNode toJson() {

        JsonNode json = null;

        try {

            json =  new ObjectMapper().readTree(this.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }

        return json;
    }

    @Override
    public String toString() {

        String json = null;

        try {

            json = new ObjectMapper().writeValueAsString(this);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return json;
    }
}
