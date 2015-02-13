package com.team3637.pitscoutingapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class RobotsDataSource {

    private SQLiteDatabase database;
    private MySQLiteHelper dbHelper;
    private String[] allColumns = { MySQLiteHelper.COLUMN_ID,
            MySQLiteHelper.COLUMN_NUMBER,
            MySQLiteHelper.COLUMN_NAME,
            MySQLiteHelper.COLUMN_WHEEL_NUM,
            MySQLiteHelper.COLUMN_WHEEL_TYPE,
            MySQLiteHelper.COLUMN_DRIVE_MOTOR,
            MySQLiteHelper.COLUMN_LIFT,
            MySQLiteHelper.COLUMN_MAX_STACK,
            MySQLiteHelper.COLUMN_STACK_CAN,
            MySQLiteHelper.COLUMN_STACK_SPEED,
            MySQLiteHelper.COLUMN_GRABBER,
            MySQLiteHelper.COLUMN_STACK_METHOD,
            MySQLiteHelper.COLUMN_COMMENT};

    public RobotsDataSource(Context context) {
        dbHelper = new MySQLiteHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public Robot createRobot(String number, String name, String wheelNum, String wheelType, String driveMotor, String lift, String maxStack, String stackCan, String stackSpeed, String grabber, String stackMethod, String comment) {
        ContentValues values = new ContentValues();
        values.put(MySQLiteHelper.COLUMN_NUMBER, number);
        values.put(MySQLiteHelper.COLUMN_NAME, name);
        values.put(MySQLiteHelper.COLUMN_WHEEL_NUM, wheelNum);
        values.put(MySQLiteHelper.COLUMN_WHEEL_TYPE, wheelType);
        values.put(MySQLiteHelper.COLUMN_DRIVE_MOTOR, driveMotor);
        values.put(MySQLiteHelper.COLUMN_LIFT, lift);
        values.put(MySQLiteHelper.COLUMN_MAX_STACK, maxStack);
        values.put(MySQLiteHelper.COLUMN_STACK_CAN, stackCan);
        values.put(MySQLiteHelper.COLUMN_STACK_SPEED, stackSpeed);
        values.put(MySQLiteHelper.COLUMN_GRABBER, grabber);
        values.put(MySQLiteHelper.COLUMN_STACK_METHOD, stackMethod);
        values.put(MySQLiteHelper.COLUMN_COMMENT, comment);
        long insertId = database.insert(MySQLiteHelper.TABLE_ROBOTS, null,
                values);
        Cursor cursor = database.query(MySQLiteHelper.TABLE_ROBOTS,
                allColumns, MySQLiteHelper.COLUMN_ID + " = " + insertId, null,
                null, null, null);
        cursor.moveToFirst();
        Robot newRobot = cursorToRobot(cursor);
        cursor.close();
        return newRobot;
    }

    public void deleteRobot(Robot robot) {
        long id = robot.getId();
        System.out.println("Comment deleted with id: " + id);
        database.delete(MySQLiteHelper.TABLE_ROBOTS, MySQLiteHelper.COLUMN_ID
                + " = " + id, null);
    }

    public List<Robot> getAllComments() {
        List<Robot> robots = new ArrayList<Robot>();

        Cursor cursor = database.query(MySQLiteHelper.TABLE_ROBOTS,
                allColumns, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Robot robot = cursorToRobot(cursor);
            robots.add(robot);
            cursor.moveToNext();
        }
        // make sure to close the cursor
        cursor.close();
        return robots;
    }

    private Robot cursorToRobot(Cursor cursor) {
        Robot robot = new Robot();
        if(cursor.moveToFirst()) {
            robot.setId(cursor.getLong(0));
            robot.setNumber(cursor.getString(1));
            robot.setName(cursor.getString(2));
            robot.setWheelNum(cursor.getString(3));
            robot.setWheelType(cursor.getString(4));
            robot.setDriveMotor(cursor.getString(5));
            robot.setLift(cursor.getString(6));
            robot.setMaxStack(cursor.getString(7));
            robot.setStackCan(cursor.getString(8));
            robot.setStackSpeed(cursor.getString(9));
            robot.setGrabber(cursor.getString(10));
            robot.setStackMethod(cursor.getString(11));
            robot.setComment(cursor.getString(12));
        }
        return robot;
    }
}
