package com.team3637.pitscoutingappb;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;


public class DataEntryActivity extends ActionBarActivity {

    public static Robot robot = null;

    private RobotsDataSource datasource;

    private EditText number;
    private EditText name;
    private CheckBox autoRobot;
    private CheckBox autoTote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_entry);

        number = (EditText) findViewById(R.id.robotNumber);
        name = (EditText) findViewById(R.id.robotName);
        autoRobot = (CheckBox) findViewById(R.id.autoRobot);
        autoTote = (CheckBox) findViewById(R.id.autoTote);

        datasource = new RobotsDataSource(this);
        datasource.open();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_data_entry, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private String check(boolean bool) {
        if (bool)
            return "Yes";
        else
            return "No";
    }

    public void submit(View view) {
        robot = datasource.createRobot(number.getText().toString(),
                name.getText().toString(),
                check(autoRobot.isChecked()),
                check(autoTote.isChecked()));
        System.out.println(robot.getAutoRobot());
        finish();
    }
}
