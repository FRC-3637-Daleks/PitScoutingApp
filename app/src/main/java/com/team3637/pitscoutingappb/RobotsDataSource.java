package com.team3637.pitscoutingappb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
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
            MySQLiteHelper.COLUMN_NAME
/*            MySQLiteHelper.COLUMN_AUTOROBOT,
            MySQLiteHelper.COLUMN_AUTOTOTE,
            MySQLiteHelper.COLUMN_AUTOCAN,
            MySQLiteHelper.COLUMN_STARTTL,
            MySQLiteHelper.COLUMN_STARTTM,
            MySQLiteHelper.COLUMN_STARTTR,
            MySQLiteHelper.COLUMN_STARTLL,
            MySQLiteHelper.COLUMN_STARTLM,
            MySQLiteHelper.COLUMN_STARTLR,
            MySQLiteHelper.COLUMN_STYLEHS,
            MySQLiteHelper.COLUMN_STYLETOPPER,
            MySQLiteHelper.COLUMN_STYLELITTERCAN,
            MySQLiteHelper.COLUMN_STYLELANDFILL,
            MySQLiteHelper.COLUMN_STYLETHROW,
            MySQLiteHelper.COLUMN_STYLESINGLESTACK,
            MySQLiteHelper.COLUMN_STYLEMAKEATONCE,
            MySQLiteHelper.COLUMN_STYLECANFROMSTEP*/
    };

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
        if (cursor.moveToFirst()) {
            robot.setId(cursor.getLong(0));
            robot.setNumber(cursor.getString(1));
            robot.setName(cursor.getString(2));
        }
        return robot;
    }

    public List<String[]> exportSting() {
        List<String[]> data = new ArrayList<String[]>();
        Cursor cursor = database.query(MySQLiteHelper.TABLE_ROBOTS,
                allColumns, null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            String[] row = new String[3];
            row[0] = Long.toString(cursor.getLong(0));
            row[1] = cursor.getString(1);
            row[2] = cursor.getString(2);
            data.add(row);
            cursor.moveToNext();
        }
        return data;
    }

    public void writeCSV(List<String[]> data) {
        CSVWriter writer = null;
        try
        {
            writer = new CSVWriter(new FileWriter("/sdcard/myfile.csv"), '\t', CSVWriter.NO_QUOTE_CHARACTER);
            writer.writeAll(data);
            writer.close();
        }
        catch (IOException e)
        {
            System.out.println("Write Failed");
        }
    }
}
