package com.team3637.pitscoutingapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.opencsv.CSVReader;

import java.lang.reflect.Field;

public class MySQLiteHelper extends SQLiteOpenHelper {
    public static final String TABLE_ROBOTS = "robots";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NUMBER = "number";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_WHEEL_NUM = "wheelNum";
    public static final String COLUMN_WHEEL_TYPE = "wheelType";
    public static final String COLUMN_DRIVE_MOTOR = "driveMotor";
    public static final String COLUMN_LIFT = "lift";
    public static final String COLUMN_MAX_STACK = "maxStack";
    public static final String COLUMN_STACK_CAN = "stackCan";
    public static final String COLUMN_STACK_SPEED = "stackSpeed";
    public static final String COLUMN_GRABBER = "grabber";
    public static final String COLUMN_STACK_METHOD = "stackMethod";
    public static final String COLUMN_COMMENT = "comment";

    private static final String DATABASE_NAME = "robots.db";
    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_CREATE = "create table "
            + TABLE_ROBOTS + "(" + COLUMN_ID
            + " integer primary key autoincrement, " + COLUMN_NUMBER
            + " text not null, " + COLUMN_NAME
            + " text not null, " + COLUMN_WHEEL_NUM
            + " text not null, " + COLUMN_WHEEL_TYPE
            + " text not null, " + COLUMN_DRIVE_MOTOR
            + " text not null, " + COLUMN_LIFT
            + " text not null, " + COLUMN_MAX_STACK
            + " text not null, " + COLUMN_STACK_CAN
            + " text not null, " + COLUMN_STACK_SPEED
            + " text not null, " + COLUMN_GRABBER
            + " text not null, " + COLUMN_STACK_METHOD
            + " text not null, " + COLUMN_COMMENT
            + " text not null);";

    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(MySQLiteHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ROBOTS);
        onCreate(db);
    }

}
