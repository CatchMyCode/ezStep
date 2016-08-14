package com.catchmycode.ezstep.data.mapping;

public class Instruction {

    private short sequence;
    private String action;
    private String detail;

    public Instruction() {}

    public short getSequence() {
        return sequence;
    }

    public void setSequence(short sequence) {
        this.sequence = sequence;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
