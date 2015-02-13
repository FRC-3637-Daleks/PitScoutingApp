package com.team3637.pitscoutingapp;

public class Robot {
    private long id;
    private String number;
    private String name;
    private String wheelNum;
    private String wheelType;
    private String driveMotor;
    private String lift;
    private String maxStack;
    private String stackCan;
    private String stackSpeed;
    private String grabber;
    private String stackMethod;
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

    public String getWheelNum() {
        return wheelNum;
    }

    public void setWheelNum(String wheelNum) {
        this.wheelNum = wheelNum;
    }

    public String getWheelType() {
        return wheelType;
    }

    public void setWheelType(String wheelType) {
        this.wheelType = wheelType;
    }

    public String getDriveMotor() {
        return driveMotor;
    }

    public void setDriveMotor(String driveMotor) {
        this.driveMotor = driveMotor;
    }

    public String getLift() {
        return lift;
    }

    public void setLift(String lift) {
        this.lift = lift;
    }

    public String getMaxStack() {
        return maxStack;
    }

    public void setMaxStack(String maxStack) {
        this.maxStack = maxStack;
    }

    public String getStackCan() {
        return stackCan;
    }

    public void setStackCan(String stackCan) {
        this.stackCan = stackCan;
    }

    public String getStackSpeed() {
        return stackSpeed;
    }

    public void setStackSpeed(String stackSpeed) {
        this.stackSpeed = stackSpeed;
    }

    public String getGrabber() {
        return grabber;
    }

    public void setGrabber(String grabber) {
        this.grabber = grabber;
    }

    public String getStackMethod() {
        return stackMethod;
    }

    public void setStackMethod(String stackMethod) {
        this.stackMethod = stackMethod;
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
