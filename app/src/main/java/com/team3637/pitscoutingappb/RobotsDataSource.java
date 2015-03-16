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
            MySQLiteHelper.COLUMN_STYLECANFROMSTEP,
            MySQLiteHelper.COLUMN_COOPTOTE,
            MySQLiteHelper.COLUMN_COOPSTEP,
            MySQLiteHelper.COLUMN_COMMENT};

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

    public Robot createRobot(String number, String name, String autoRobot, String autoTote,
                             String autoCan,String startTL, String startTM, String startTR,
                             String startLL,String startLM, String startLR, String styleHS,
                             String styleTopper,String styleLitterCan, String styleLandfill,
                             String styleThrow,String styleSingleStack,String styleMakeAtOnce,
                             String styleCanFromStep, String coopTote, String coopStep,
                             String comment) {
        ContentValues values = new ContentValues();
        values.put(MySQLiteHelper.COLUMN_NUMBER, number);
        values.put(MySQLiteHelper.COLUMN_NAME, name);
        values.put(MySQLiteHelper.COLUMN_AUTOROBOT, autoRobot);
        values.put(MySQLiteHelper.COLUMN_AUTOTOTE, autoTote);
        values.put(MySQLiteHelper.COLUMN_AUTOCAN, autoCan);
        values.put(MySQLiteHelper.COLUMN_STARTTL, startTL);
        values.put(MySQLiteHelper.COLUMN_STARTTM, startTM);
        values.put(MySQLiteHelper.COLUMN_STARTTR, startTR);
        values.put(MySQLiteHelper.COLUMN_STARTLL, startLL);
        values.put(MySQLiteHelper.COLUMN_STARTLM, startLM);
        values.put(MySQLiteHelper.COLUMN_STARTLR, startLR);
        values.put(MySQLiteHelper.COLUMN_STYLEHS, styleHS);
        values.put(MySQLiteHelper.COLUMN_STYLETOPPER, styleTopper);
        values.put(MySQLiteHelper.COLUMN_STYLELITTERCAN, styleLitterCan);
        values.put(MySQLiteHelper.COLUMN_STYLELANDFILL, styleLandfill);
        values.put(MySQLiteHelper.COLUMN_STYLETHROW, styleThrow);
        values.put(MySQLiteHelper.COLUMN_STYLESINGLESTACK, styleSingleStack);
        values.put(MySQLiteHelper.COLUMN_STYLEMAKEATONCE, styleMakeAtOnce);
        values.put(MySQLiteHelper.COLUMN_STYLECANFROMSTEP, styleCanFromStep);
        values.put(MySQLiteHelper.COLUMN_COOPTOTE, coopTote);
        values.put(MySQLiteHelper.COLUMN_COOPSTEP, coopStep);
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

    public Robot editRobot(long id, String number, String name, String autoRobot, String autoTote,
                           String autoCan,String startTL, String startTM, String startTR,
                           String startLL,String startLM, String startLR, String styleHS,
                           String styleTopper,String styleLitterCan, String styleLandfill,
                           String styleThrow,String styleSingleStack,String styleMakeAtOnce,
                           String styleCanFromStep, String coopTote, String coopStep,
                           String comment) {
        ContentValues values = new ContentValues();
        values.put(MySQLiteHelper.COLUMN_NUMBER, number);
        values.put(MySQLiteHelper.COLUMN_NAME, name);
        values.put(MySQLiteHelper.COLUMN_AUTOROBOT, autoRobot);
        values.put(MySQLiteHelper.COLUMN_AUTOTOTE, autoTote);
        values.put(MySQLiteHelper.COLUMN_AUTOCAN, autoCan);
        values.put(MySQLiteHelper.COLUMN_STARTTL, startTL);
        values.put(MySQLiteHelper.COLUMN_STARTTM, startTM);
        values.put(MySQLiteHelper.COLUMN_STARTTR, startTR);
        values.put(MySQLiteHelper.COLUMN_STARTLL, startLL);
        values.put(MySQLiteHelper.COLUMN_STARTLM, startLM);
        values.put(MySQLiteHelper.COLUMN_STARTLR, startLR);
        values.put(MySQLiteHelper.COLUMN_STYLEHS, styleHS);
        values.put(MySQLiteHelper.COLUMN_STYLETOPPER, styleTopper);
        values.put(MySQLiteHelper.COLUMN_STYLELITTERCAN, styleLitterCan);
        values.put(MySQLiteHelper.COLUMN_STYLELANDFILL, styleLandfill);
        values.put(MySQLiteHelper.COLUMN_STYLETHROW, styleThrow);
        values.put(MySQLiteHelper.COLUMN_STYLESINGLESTACK, styleSingleStack);
        values.put(MySQLiteHelper.COLUMN_STYLEMAKEATONCE, styleMakeAtOnce);
        values.put(MySQLiteHelper.COLUMN_STYLECANFROMSTEP, styleCanFromStep);
        values.put(MySQLiteHelper.COLUMN_COOPTOTE, coopTote);
        values.put(MySQLiteHelper.COLUMN_COOPSTEP, coopStep);
        values.put(MySQLiteHelper.COLUMN_COMMENT, comment);
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
            robot.setAutoCan(cursor.getString(5));
            robot.setStartTL(cursor.getString(6));
            robot.setStartTM(cursor.getString(7));
            robot.setStartTR(cursor.getString(8));
            robot.setStartLL(cursor.getString(9));
            robot.setStartLM(cursor.getString(10));
            robot.setStartLR(cursor.getString(11));
            robot.setStyleHS(cursor.getString(12));
            robot.setStyleTopper(cursor.getString(13));
            robot.setStyleLitterCan(cursor.getString(14));
            robot.setStyleLandfill(cursor.getString(15));
            robot.setStyleThrow(cursor.getString(16));
            robot.setStyleSingleStack(cursor.getString(17));
            robot.setStyleMakeAtOnce(cursor.getString(18));
            robot.setStyleCanFromStep(cursor.getString(19));
            robot.setCoopTote(cursor.getString(20));
            robot.setCoopStep(cursor.getInt(21));
            robot.setComment(cursor.getString(22));
        }
        return robot;
    }

    public List<String[]> exportSting() {
        List<String[]> data = new ArrayList<String[]>();
        Cursor cursor = database.query(MySQLiteHelper.TABLE_ROBOTS,
                allColumns, null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            String[] row = new String[23];
            row[0] = Long.toString(cursor.getLong(0));
            row[1] = cursor.getString(1);
            row[2] = cursor.getString(2);
            row[3] = cursor.getString(3);
            row[4] = cursor.getString(4);
            row[5] = cursor.getString(5);
            row[6] = cursor.getString(6);
            row[7] = cursor.getString(7);
            row[8] = cursor.getString(8);
            row[9] = cursor.getString(9);
            row[10] = cursor.getString(10);
            row[11] = cursor.getString(11);
            row[12] = cursor.getString(12);
            row[13] = cursor.getString(13);
            row[14] = cursor.getString(14);
            row[15] = cursor.getString(15);
            row[16] = cursor.getString(16);
            row[17] = cursor.getString(17);
            row[18] = cursor.getString(18);
            row[19] = cursor.getString(19);
            row[20] = cursor.getString(20);
            row[22] = Integer.toString(cursor.getInt(21));
            row[22] = cursor.getString(22);
            data.add(row);
            cursor.moveToNext();
        }
        return data;
    }

    public void writeCSV(List<String[]> data) {
        CSVWriter writer = null;
        try
        {
            writer = new CSVWriter(new FileWriter("/sdcard/pitScoutingData.csv"), '\t', CSVWriter.NO_QUOTE_CHARACTER);
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
