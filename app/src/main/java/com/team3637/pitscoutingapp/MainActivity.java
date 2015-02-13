package com.team3637.pitscoutingapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;


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

}
