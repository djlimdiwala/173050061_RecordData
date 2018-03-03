package com.example.lkh.recorddata;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.ToggleButton;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Record extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);





        getSupportActionBar().setDisplayShowTitleEnabled(false);

        final Spinner mySpinner;
        mySpinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> myAdpater =new
                ArrayAdapter<String>(Record.this ,R.layout.support_simple_spinner_dropdown_item,
                getResources().getStringArray(R.array.Menu));
        myAdpater.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdpater);

        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {Intent intent;switch (position) {
                case 1:
                    intent = new Intent(Record.this, MainActivity.class);
                    startActivity(intent);
                    break;
                case 2:
                    intent = new Intent(Record.this, sensors.class);
                    startActivity(intent);
                    break;
            }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }

                                            }
        );












        ListView records_view = (ListView) findViewById(R.id.records_view);

        String[] recordings = new String[] {};

        // Create a List from String Array elements
        final List<String> recordings_list = new ArrayList<String>(Arrays.asList(recordings));

        // Create an ArrayAdapter from List
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, recordings_list);

        // DataBind ListView with items from ArrayAdapter
        records_view.setAdapter(arrayAdapter);

        final ToggleButton tB = (ToggleButton) findViewById(R.id.record_button);
        tB.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                if(tB.isChecked()){
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
                    String format = simpleDateFormat.format(new Date());
                    if (recordings_list.size() >= 5)
                    {
                        recordings_list.add(0,format);
                        recordings_list.remove(recordings_list.size()-1);
                    }
                    else
                    {
                        recordings_list.add(0,format);
                    }

                }
                else
                {}
                //Button is OFF
                // Do Something
                arrayAdapter.notifyDataSetChanged();
            }
        });


    }
    @Override
    public void onBackPressed() { }
}
