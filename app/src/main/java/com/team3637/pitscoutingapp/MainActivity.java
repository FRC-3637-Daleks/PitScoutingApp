package com.team3637.pitscoutingapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;

import java.lang.reflect.Field;
import java.util.List;


public class MainActivity extends ActionBarActivity {
    private RobotsDataSource datasource;

    private EditText number;
    private EditText name;
    private Spinner wheelNum;
    private Spinner wheelType;
    private Spinner driveMotor;
    private Spinner lift;
    private Spinner maxStack;
    private CheckBox stackCan;
    private Spinner stackSpeed;
    private Spinner grabber;
    private Spinner stackMethod;
    private EditText comment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number = (EditText) findViewById(R.id.robotNumber);
        name = (EditText) findViewById(R.id.robotName);
        wheelNum = (Spinner) findViewById(R.id.wheelNumber);
        wheelType = (Spinner) findViewById(R.id.wheelType);
        driveMotor = (Spinner) findViewById(R.id.motorNumber);
        lift = (Spinner) findViewById(R.id.liftAbility);
        maxStack = (Spinner) findViewById(R.id.maxStack);
        stackCan = (CheckBox) findViewById(R.id.maxStackCan);
        stackSpeed = (Spinner) findViewById(R.id.stackSpeed);
        grabber = (Spinner) findViewById(R.id.grabType);
        stackMethod = (Spinner) findViewById(R.id.stackMethod);
        comment = (EditText) findViewById(R.id.comment);

        datasource = new RobotsDataSource(this);
        datasource.open();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id) {
            case R.id.action_settings:
                return true;
            case R.id.action_list:
                openList();
                return true;
            case R.id.action_export:
                exportDB();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void submit(View view) {
        Robot robot = null;
        String can;
        if (stackCan.isChecked())
            can = "Yes";
        else
            can = "No";
        robot = datasource.createRobot(number.getText().toString(), name.getText().toString(), wheelNum.getSelectedItem().toString(), wheelType.getSelectedItem().toString(), driveMotor.getSelectedItem().toString(), lift.getSelectedItem().toString(), maxStack.getSelectedItem().toString(), can, stackSpeed.getSelectedItem().toString(), grabber.getSelectedItem().toString(), stackMethod.getSelectedItem().toString(), comment.getText().toString());
    }

    public void openList() {
        Intent robotList = new Intent(this, RobotList.class);
        startActivity(robotList);
    }

    public void viewList(View view) {
        Intent robotList = new Intent(this, RobotList.class);
        startActivity(robotList);
    }

    public void exportDB() {
        List<Robot> robotsList = datasource.getAllComments();
        String[][] data = new String[robotsList.size()][11];
        for(int i = 0; i < robotsList.size(); i++) {
            data[i][0] = robotsList.get(i).getNumber();
            data[i][1] = robotsList.get(i).getName();
            data[i][2] = robotsList.get(i).getWheelNum();
            data[i][3] = robotsList.get(i).getWheelType();
            data[i][4] = robotsList.get(i).getDriveMotor();
            data[i][5] = robotsList.get(i).getMaxStack();
            data[i][6] = robotsList.get(i).getStackCan();
            data[i][7] = robotsList.get(i).getStackSpeed();
            data[i][8] = robotsList.get(i).getGrabber();
            data[i][9] = robotsList.get(i).getStackMethod();
            data[i][10] = robotsList.get(i).getComment();
        }
        CSVWriter writer = null;
        try {
            writer = new CSVWriter(new FileWriter(Environment.getDataDirectory()));
            for(int i = 0; i < robotsList.size(); i++) {
                writer.writeNext(data[i]);
            }
            writer.close();
        } catch (IOException e) {
        }
    }

}
