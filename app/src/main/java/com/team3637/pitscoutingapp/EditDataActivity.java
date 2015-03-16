package com.team3637.pitscoutingapp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class EditDataActivity extends ActionBarActivity {

    public static Robot robot = null;

    private RobotsDataSource datasource;
    private List<Robot> values = null;

    private EditText number;
    private EditText name;
    private CheckBox autoRobot;
    private CheckBox autoTote;
    private CheckBox autoCan;
    private CheckBox startTL;
    private CheckBox startTM;
    private CheckBox startTR;
    private CheckBox startLL;
    private CheckBox startLM;
    private CheckBox startLR;
    private CheckBox styleHS;
    private CheckBox styleTopper;
    private CheckBox styleLitterCan;
    private CheckBox styleLandfill;
    private CheckBox styleThrow;
    private CheckBox styleSingleStack;
    private CheckBox styleMakeAtOnce;
    private CheckBox styleCanFromStep;
    private CheckBox coopTote;
    private EditText coopStep;
    private EditText comment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_data);

        Intent intent = getIntent();


        number = (EditText) findViewById(R.id.robotNumber);
        name = (EditText) findViewById(R.id.robotName);
        autoRobot = (CheckBox) findViewById(R.id.autoRobot);
        autoTote = (CheckBox) findViewById(R.id.autoTote);
        autoCan = (CheckBox) findViewById(R.id.autoCan);
        startTL = (CheckBox) findViewById(R.id.startTL);
        startTM = (CheckBox) findViewById(R.id.startTM);
        startTR = (CheckBox) findViewById(R.id.startTR);
        startLL = (CheckBox) findViewById(R.id.startLL);
        startLM = (CheckBox) findViewById(R.id.startLM);
        startLR = (CheckBox) findViewById(R.id.startLR);
        styleHS = (CheckBox) findViewById(R.id.styleHS);
        styleTopper = (CheckBox) findViewById(R.id.styleTopper);
        styleLitterCan = (CheckBox) findViewById(R.id.styleLitterCan);
        styleLandfill = (CheckBox) findViewById(R.id.styleLandfill);
        styleThrow = (CheckBox) findViewById(R.id.styleThrow);
        styleSingleStack = (CheckBox) findViewById(R.id.styleSingleStack);
        styleMakeAtOnce = (CheckBox) findViewById(R.id.styleMakeAtOnce);
        styleCanFromStep = (CheckBox) findViewById(R.id.styleCanFromStep);
        coopTote = (CheckBox) findViewById(R.id.coopTote);
        coopStep = (EditText) findViewById(R.id.coopStep);
        comment = (EditText) findViewById(R.id.comment);

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
        autoCan.setChecked(check(robot.getAutoCan()));
        startTL.setChecked(check(robot.getStartTL()));
        startTM.setChecked(check(robot.getStartTM()));
        startTR.setChecked(check(robot.getStartTR()));
        startLL.setChecked(check(robot.getStartLL()));
        startLM.setChecked(check(robot.getStartLM()));
        startLR.setChecked(check(robot.getStartLR()));
        styleHS.setChecked(check(robot.getStyleHS()));
        styleTopper.setChecked(check(robot.getStyleTopper()));
        styleLitterCan.setChecked(check(robot.getStyleLitterCan()));
        styleLandfill.setChecked(check(robot.getStyleLandfill()));
        styleThrow.setChecked(check(robot.getStyleThrow()));
        styleSingleStack.setChecked(check(robot.getStyleSingleStack()));
        styleMakeAtOnce.setChecked(check(robot.getStyleMakeAtOnce()));
        styleCanFromStep.setChecked(check(robot.getStyleCanFromStep()));
        coopTote.setChecked(check(robot.getCoopTote()));
        coopStep.setText(Integer.toString(robot.getCoopStep()));
        comment.setText(robot.getComment());
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

    private boolean check(String val) {
        if (val != null) {
            if (val.equals("Yes"))
                return true;
        }
        return false;
    }

    public void submit(View view) {
        robot = datasource.editRobot(robot.getId(), number.getText().toString(),
                name.getText().toString(),
                check(autoRobot.isChecked()),
                check(autoTote.isChecked()),
                check(autoCan.isChecked()),
                check(startTL.isChecked()),
                check(startTM.isChecked()),
                check(startTR.isChecked()),
                check(startLL.isChecked()),
                check(startLM.isChecked()),
                check(startLR.isChecked()),
                check(styleHS.isChecked()),
                check(styleTopper.isChecked()),
                check(styleLitterCan.isChecked()),
                check(styleLandfill.isChecked()),
                check(styleThrow.isChecked()),
                check(styleSingleStack.isChecked()),
                check(styleMakeAtOnce.isChecked()),
                check(styleCanFromStep.isChecked()),
                check(coopTote.isChecked()),
                coopStep.getText().toString(),
                comment.getText().toString()
        );
        Toast.makeText(getApplicationContext(), "Robot Edited", Toast.LENGTH_SHORT).show();
        finish();
    }
}
