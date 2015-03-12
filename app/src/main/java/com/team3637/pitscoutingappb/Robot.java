package com.team3637.pitscoutingappb;

import java.io.Serializable;

/**
 * Created by Ben Goldberg on 2/6/2015.
 */
public class Robot {
    private long id;
    private String number;
    private String name;
    private Boolean autoRobot;
    private Boolean autoTote;
    private Boolean autoCan;
    private Boolean startTL;
    private Boolean startTM;
    private Boolean startTR;
    private Boolean startLL;
    private Boolean startLM;
    private Boolean startLR;
    private Boolean styleHS;
    private Boolean styleTopper;
    private Boolean styleLitterCan;
    private Boolean styleLandfill;
    private Boolean styleThrow;
    private Boolean styleSingleStack;
    private Boolean styleMakeAtOnce;
    private Boolean styleCanFromStep;
    private Boolean coopTote;
    private Integer coopStep;
    private String comment;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getAutoRobot() {
        return autoRobot;
    }

    public void setAutoRobot(Boolean autoRobot) {
        this.autoRobot = autoRobot;
    }

    public Boolean getAutoTote() {
        return autoTote;
    }

    public void setAutoTote(Boolean autoTote) {
        this.autoTote = autoTote;
    }

    public Boolean getAutoCan() {
        return autoCan;
    }

    public void setAutoCan(Boolean autoCan) {
        this.autoCan = autoCan;
    }

    public Boolean getStartTL() {
        return startTL;
    }

    public void setStartTL(Boolean startTL) {
        this.startTL = startTL;
    }

    public Boolean getStartTM() {
        return startTM;
    }

    public void setStartTM(Boolean startTM) {
        this.startTM = startTM;
    }

    public Boolean getStartTR() {
        return startTR;
    }

    public void setStartTR(Boolean startTR) {
        this.startTR = startTR;
    }

    public Boolean getStartLL() {
        return startLL;
    }

    public void setStartLL(Boolean startLL) {
        this.startLL = startLL;
    }

    public Boolean getStartLM() {
        return startLM;
    }

    public void setStartLM(Boolean startLM) {
        this.startLM = startLM;
    }

    public Boolean getStartLR() {
        return startLR;
    }

    public void setStartLR(Boolean startLR) {
        this.startLR = startLR;
    }

    public Boolean getStyleHS() {
        return styleHS;
    }

    public void setStyleHS(Boolean styleHS) {
        this.styleHS = styleHS;
    }

    public Boolean getStyleTopper() {
        return styleTopper;
    }

    public void setStyleTopper(Boolean styleTopper) {
        this.styleTopper = styleTopper;
    }

    public Boolean getStyleLitterCan() {
        return styleLitterCan;
    }

    public void setStyleLitterCan(Boolean styleLitterCan) {
        this.styleLitterCan = styleLitterCan;
    }

    public Boolean getStyleLandfill() {
        return styleLandfill;
    }

    public void setStyleLandfill(Boolean styleLandfill) {
        this.styleLandfill = styleLandfill;
    }

    public Boolean getStyleThrow() {
        return styleThrow;
    }

    public void setStyleThrow(Boolean styleThrow) {
        this.styleThrow = styleThrow;
    }

    public Boolean getStyleSingleStack() {
        return styleSingleStack;
    }

    public void setStyleSingleStack(Boolean styleSingleStack) {
        this.styleSingleStack = styleSingleStack;
    }

    public Boolean getStyleMakeAtOnce() {
        return styleMakeAtOnce;
    }

    public void setStyleMakeAtOnce(Boolean styleMakeAtOnce) {
        this.styleMakeAtOnce = styleMakeAtOnce;
    }

    public Boolean getStyleCanFromStep() {
        return styleCanFromStep;
    }

    public void setStyleCanFromStep(Boolean styleCanFromStep) {
        this.styleCanFromStep = styleCanFromStep;
    }

    public Boolean getCoopTote() {
        return coopTote;
    }

    public void setCoopTote(Boolean coopTote) {
        this.coopTote = coopTote;
    }

    public Integer getCoopStep() {
        return coopStep;
    }

    public void setCoopStep(Integer coopStep) {
        this.coopStep = coopStep;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return number;
    }
}
