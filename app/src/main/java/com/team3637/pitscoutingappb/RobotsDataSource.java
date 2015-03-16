package com.team3637.pitscoutingappb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RobotsDataSource {
    private Context context;

    private SQLiteDatabase database;
    private MySQLiteHelper dbHelper;
    private String[] allColumns = { MySQLiteHelper.COLUMN_ID,
            MySQLiteHelper.COLUMN_NUMBER,
            MySQLiteHelper.COLUMN_NAME,
            MySQLiteHelper.COLUMN_AUTOROBOT,
            MySQLiteHelper.COLUMN_AUTOTOTE
    };

    public RobotsDataSource(Context context) {
        this.context = context;
        dbHelper = new MySQLiteHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public Robot createRobot(String number, String name, String autoRobot, String autoTote) {
        ContentValues values = new ContentValues();
        values.put(MySQLiteHelper.COLUMN_NUMBER, number);
        values.put(MySQLiteHelper.COLUMN_NAME, name);
        values.put(MySQLiteHelper.COLUMN_AUTOROBOT, autoRobot);
        values.put(MySQLiteHelper.COLUMN_AUTOTOTE, autoTote);
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

    public Robot editRobot(long id, String number, String name, String autoRobot, String autoTote) {
        ContentValues values = new ContentValues();
        values.put(MySQLiteHelper.COLUMN_NUMBER, number);
        values.put(MySQLiteHelper.COLUMN_NAME, name);
        values.put(MySQLiteHelper.COLUMN_AUTOROBOT, autoRobot);
        values.put(MySQLiteHelper.COLUMN_AUTOTOTE, autoTote);
        long insertId = database.update(MySQLiteHelper.TABLE_ROBOTS, values, MySQLiteHelper.COLUMN_ID + " = " + id, null);
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
        if (cursor.getCount() > 0) {
            robot.setId(cursor.getLong(0));
            robot.setNumber(cursor.getString(1));
            robot.setName(cursor.getString(2));
            robot.setAutoRobot(cursor.getString(3));
            robot.setAutoTote(cursor.getString(4));
        }
        return robot;
    }

    public List<String[]> exportSting() {
        List<String[]> data = new ArrayList<String[]>();
        Cursor cursor = database.query(MySQLiteHelper.TABLE_ROBOTS,
                allColumns, null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            String[] row = new String[5];
            row[0] = Long.toString(cursor.getLong(0));
            row[1] = cursor.getString(1);
            row[2] = cursor.getString(2);
            row[3] = cursor.getString(3);
            row[4] = cursor.getString(4);
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
            Toast.makeText(context, "Write Successful", Toast.LENGTH_SHORT).show();
        }
        catch (IOException e)
        {
            System.out.println("Write Failed");
        }
    }
}
