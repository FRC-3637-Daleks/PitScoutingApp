package com.team3637.pitscoutingappb;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;


public class MainActivity extends ListActivity {
    private RobotsDataSource datasource;

    private EditText number;
    private EditText name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number = (EditText) findViewById(R.id.robotNumber);
        name = (EditText) findViewById(R.id.robotName);

        datasource = new RobotsDataSource(this);
        datasource.open();

        List<Robot> values = datasource.getAllComments();

        ArrayAdapter<Robot> adapter = new ArrayAdapter<Robot>(this,
                android.R.layout.simple_list_item_1, values);
        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {

    }

    public void onClick(View view) {
        @SuppressWarnings("unchecked")
        ArrayAdapter<Robot> adapter = (ArrayAdapter<Robot>) getListAdapter();
        Robot robot = null;

        switch (view.getId()) {
            case R.id.add:
                robot = datasource.createRobot(number.getText().toString(), name.getText().toString());
                adapter.add(robot);
                break;

            case R.id.delete:
                if (getListAdapter().getCount() > 0) {
                    robot = (Robot) getListAdapter().getItem(0);
                    datasource.deleteRobot(robot);
                    adapter.remove(robot);
                }
                break;
            case R.id.export:

                datasource.writeCSV(datasource.exportSting());
                break;
        }
        adapter.notifyDataSetChanged();
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

}
