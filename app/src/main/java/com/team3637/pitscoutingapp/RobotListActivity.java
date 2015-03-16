package com.team3637.pitscoutingapp;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;


public class RobotListActivity extends ListActivity {
    private RobotsDataSource datasource;

    private ArrayAdapter<Robot> adapter = (ArrayAdapter<Robot>) getListAdapter();
    private List<Robot> values = null;

    private EditText number;
    private EditText name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_robot_list);

        number = (EditText) findViewById(R.id.robotNumber);
        name = (EditText) findViewById(R.id.robotName);

        datasource = new RobotsDataSource(this);
        datasource.open();

        values = datasource.getAllComments();

        ArrayAdapter<Robot> adapter = new ArrayAdapter<Robot>(this,
                android.R.layout.simple_list_item_1, values);
        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Robot robot = values.get(position);
        Intent edit = new Intent(this, EditDataActivity.class);
        edit.putExtra("pos", position);
        startActivity(edit);
        finish();
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.backButton:
                finish();
                break;
        }
    }

    @Override
    protected void onResume() {
        datasource.open();
        super.onResume();
    }

    @Override
    protected void onPause() {
        datasource.close();
        super.onPause();
    }

    private boolean toBool(String val) {
        if (val != null) {
            boolean cheched = (val.equals("Yes"));
            return cheched;
        }
        return false;
    }
}
