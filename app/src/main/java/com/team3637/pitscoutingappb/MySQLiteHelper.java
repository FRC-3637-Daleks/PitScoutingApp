package com.team3637.pitscoutingappb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MySQLiteHelper extends SQLiteOpenHelper {
    public static final String TABLE_ROBOTS = "robots";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NUMBER = "number";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_AUTOROBOT = "autoRobot";
    public static final String COLUMN_AUTOTOTE = "autoTote";
    public static final String COLUMN_AUTOCAN = "autoCan";
    public static final String COLUMN_STARTTL = "startTL";
    public static final String COLUMN_STARTTM = "startTM";
    public static final String COLUMN_STARTTR = "startTR";
    public static final String COLUMN_STARTLL = "startLL";
    public static final String COLUMN_STARTLM = "startLM";
    public static final String COLUMN_STARTLR = "startLR";
    public static final String COLUMN_STYLEHS = "styleHS";
    public static final String COLUMN_STYLETOPPER = "styleTopper";
    public static final String COLUMN_STYLELITTERCAN = "styleLitterCan";
    public static final String COLUMN_STYLELANDFILL = "styleLandfill";
    public static final String COLUMN_STYLETHROW = "styleThrow";
    public static final String COLUMN_STYLESINGLESTACK = "styleSingleStack";
    public static final String COLUMN_STYLEMAKEATONCE = "styleMakeAtOnce";
    public static final String COLUMN_STYLECANFROMSTEP = "styleCanFromStep";
    public static final String COLUMN_COOPTOTE = "coopTote";
    public static final String COLUMN_COOPSTEP = "coopStep";
    public static final String COLUMN_COMMENT = "comment";
    //public static final String COLUMN_ = "";

    private static final String DATABASE_NAME = "robots.db";
    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_CREATE = "create table "
            + TABLE_ROBOTS + "(" + COLUMN_ID
            + " integer primary key autoincrement, " + COLUMN_NUMBER
            + " text not null, " + COLUMN_NAME
            + " text not null, " + COLUMN_AUTOROBOT
            + " text not null, " + COLUMN_AUTOTOTE
            + " text not null, " + COLUMN_AUTOCAN
            + " text not null, " + COLUMN_STARTTL
            + " text not null, " + COLUMN_STARTTM
            + " text not null, " + COLUMN_STARTTR
            + " text not null, " + COLUMN_STARTLL
            + " text not null, " + COLUMN_STARTLM
            + " text not null, " + COLUMN_STARTLR
            + " text not null, " + COLUMN_STYLEHS
            + " text not null, " + COLUMN_STYLETOPPER
            + " text not null, " + COLUMN_STYLELITTERCAN
            + " text not null, " + COLUMN_STYLELANDFILL
            + " text not null, " + COLUMN_STYLETHROW
            + " text not null, " + COLUMN_STYLESINGLESTACK
            + " text not null, " + COLUMN_STYLEMAKEATONCE
            + " text not null, " + COLUMN_STYLECANFROMSTEP
            + " text not null, " + COLUMN_COOPTOTE
            + " text not null, " + COLUMN_COOPSTEP
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
