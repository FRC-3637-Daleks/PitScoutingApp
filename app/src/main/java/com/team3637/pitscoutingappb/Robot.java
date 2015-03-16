package com.team3637.pitscoutingappb;

import java.io.Serializable;

/**
 * Created by Ben Goldberg on 2/6/2015.
 */
public class Robot {
    private long id;
    private String number;
    private String name;
    private String autoRobot;
    private String autoTote;
    private String autoCan;
    private String startTL;
    private String startTM;
    private String startTR;
    private String startLL;
    private String startLM;
    private String startLR;
    private String styleHS;
    private String styleTopper;
    private String styleLitterCan;
    private String styleLandfill;
    private String styleThrow;
    private String styleSingleStack;
    private String styleMakeAtOnce;
    private String styleCanFromStep;
    private String coopTote;
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

    public String getAutoRobot() {
        return autoRobot;
    }

    public void setAutoRobot(String autoRobot) {
        this.autoRobot = autoRobot;
    }

    public String getAutoTote() {
        return autoTote;
    }

    public void setAutoTote(String autoTote) {
        this.autoTote = autoTote;
    }

    public String getAutoCan() {
        return autoCan;
    }

    public void setAutoCan(String autoCan) {
        this.autoCan = autoCan;
    }

    public String getStartTL() {
        return startTL;
    }

    public void setStartTL(String startTL) {
        this.startTL = startTL;
    }

    public String getStartTM() {
        return startTM;
    }

    public void setStartTM(String startTM) {
        this.startTM = startTM;
    }

    public String getStartTR() {
        return startTR;
    }

    public void setStartTR(String startTR) {
        this.startTR = startTR;
    }

    public String getStartLL() {
        return startLL;
    }

    public void setStartLL(String startLL) {
        this.startLL = startLL;
    }

    public String getStartLM() {
        return startLM;
    }

    public void setStartLM(String startLM) {
        this.startLM = startLM;
    }

    public String getStartLR() {
        return startLR;
    }

    public void setStartLR(String startLR) {
        this.startLR = startLR;
    }

    public String getStyleHS() {
        return styleHS;
    }

    public void setStyleHS(String styleHS) {
        this.styleHS = styleHS;
    }

    public String getStyleTopper() {
        return styleTopper;
    }

    public void setStyleTopper(String styleTopper) {
        this.styleTopper = styleTopper;
    }

    public String getStyleLitterCan() {
        return styleLitterCan;
    }

    public void setStyleLitterCan(String styleLitterCan) {
        this.styleLitterCan = styleLitterCan;
    }

    public String getStyleLandfill() {
        return styleLandfill;
    }

    public void setStyleLandfill(String styleLandfill) {
        this.styleLandfill = styleLandfill;
    }

    public String getStyleThrow() {
        return styleThrow;
    }

    public void setStyleThrow(String styleThrow) {
        this.styleThrow = styleThrow;
    }

    public String getStyleSingleStack() {
        return styleSingleStack;
    }

    public void setStyleSingleStack(String styleSingleStack) {
        this.styleSingleStack = styleSingleStack;
    }

    public String getStyleMakeAtOnce() {
        return styleMakeAtOnce;
    }

    public void setStyleMakeAtOnce(String styleMakeAtOnce) {
        this.styleMakeAtOnce = styleMakeAtOnce;
    }

    public String getStyleCanFromStep() {
        return styleCanFromStep;
    }

    public void setStyleCanFromStep(String styleCanFromStep) {
        this.styleCanFromStep = styleCanFromStep;
    }

    public String getCoopTote() {
        return coopTote;
    }

    public void setCoopTote(String coopTote) {
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
