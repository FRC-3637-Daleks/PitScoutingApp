package com.team3637.pitscoutingapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


public class MainActivity extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

/*        Spinner wheelNumber = (Spinner) findViewById(R.id.wheelNumber);
        Spinner wheelType = (Spinner) findViewById(R.id.wheelType);

        ArrayAdapter<CharSequence> wheelNumberAdapter = ArrayAdapter.createFromResource(this, R.array.wheelNumbers, R.layout.support_simple_spinner_dropdown_item);
        ArrayAdapter<CharSequence> wheelTypeAdapter = ArrayAdapter.createFromResource(this, R.array.wheelType, R.layout.support_simple_spinner_dropdown_item);

        wheelNumber.setAdapter(wheelNumberAdapter);
        wheelType.setAdapter(wheelTypeAdapter);*/
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

    public void openList() {
        Intent robotList = new Intent(this, RobotList.class);
        startActivity(robotList);
    }

    public void viewList(View view) {
        Intent robotList = new Intent(this, RobotList.class);
        startActivity(robotList);
    }

}
