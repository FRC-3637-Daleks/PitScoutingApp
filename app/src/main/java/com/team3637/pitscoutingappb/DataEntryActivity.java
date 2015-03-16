package com.team3637.pitscoutingappb;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;


public class DataEntryActivity extends ActionBarActivity {
    public static Robot robot = null;

    private RobotsDataSource datasource;

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
        setContentView(R.layout.activity_data_entry);

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
        Toast.makeText(getApplicationContext(), "Robot Created", Toast.LENGTH_SHORT).show();
        finish();
    }
}
