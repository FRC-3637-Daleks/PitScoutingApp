package com.team3637.pitscoutingappb;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import com.team3637.pitscoutingappb.R;

import java.util.List;

public class EditDataActivity extends ActionBarActivity {

    public static Robot robot = null;

    private RobotsDataSource datasource;
    private List<Robot> values = null;

    private EditText number;
    private EditText name;
    private CheckBox autoRobot;
    private CheckBox autoTote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_data);

        Intent intent = getIntent();


        number = (EditText) findViewById(R.id.robotNumber);
        name = (EditText) findViewById(R.id.robotName);
        autoRobot = (CheckBox) findViewById(R.id.autoRobot);
        autoTote = (CheckBox) findViewById(R.id.autoTote);

        datasource = new RobotsDataSource(this);
        datasource.open();

        values = datasource.getAllComments();

        System.out.println(intent.getExtras().getBoolean("autoTote"));

        if (intent.hasExtra("pos")) {
            robot = values.get(intent.getExtras().getInt("pos"));
        }

        number.setText(robot.getNumber());
        name.setText(robot.getName());
        autoRobot.setChecked(check(robot.getAutoRobot()));
        autoTote.setChecked(check(robot.getAutoTote()));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_edit_data, menu);
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
        robot = datasource.editRobot(robot.getId(), number.getText().toString(),
                name.getText().toString(),
                check(autoRobot.isChecked()),
                check(autoTote.isChecked()));
        finish();
    }

    private boolean check(String val) {
        if (val != null) {
            if (val.equals("Yes"))
                return true;
        }
        return false;
    }
}
