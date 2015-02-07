package com.team3637.pitscoutingapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zethra on 2/6/2015.
 */
public class RobotsDataSource {

    private SQLiteDatabase database;
    private MySQLiteHelper dbHelper;
    private String[] allColumns = { MySQLiteHelper.COLUMN_ID,
            MySQLiteHelper.COLUMN_NUMBER,
            MySQLiteHelper.COLUMN_NAME};

    public RobotsDataSource(Context context) {
        dbHelper = new MySQLiteHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public Robot createRobot(String number, String name) {
        ContentValues values = new ContentValues();
        values.put(MySQLiteHelper.COLUMN_NUMBER, number);
        values.put(MySQLiteHelper.COLUMN_NAME, name);
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
        robot.setId(cursor.getLong(0));
        robot.setNumber(cursor.getString(1));
        robot.setName(cursor.getString(2));
        return robot;
    }
}
