package com.team3637.pitscoutingapp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.List;


public class MainActivity extends ActionBarActivity {

    private RobotsDataSource datasource;
    private List<Robot> values = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        datasource = new RobotsDataSource(this);
        datasource.open();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void onClick (View view) {
        switch (view.getId()) {
            case R.id.createButton:
                Intent createButton = new Intent(this, DataEntryActivity.class);
                startActivity(createButton);
                break;
            case R.id.listButton:
                Intent listButton = new Intent(this, RobotListActivity.class);
                startActivity(listButton);
                break;
            case R.id.exportButton:
                values = datasource.getAllComments();
                datasource.writeCSV(datasource.exportSting());
        }
    }
}
