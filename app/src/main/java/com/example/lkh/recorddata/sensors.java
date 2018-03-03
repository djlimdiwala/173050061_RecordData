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
import android.widget.Spinner;

public class sensors extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensors);
//        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        final Spinner mySpinner;
        mySpinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> myAdpater =new
                ArrayAdapter<String>(sensors.this ,R.layout.support_simple_spinner_dropdown_item,
                getResources().getStringArray(R.array.Menu));
        myAdpater.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdpater);

        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                                @Override
                                                public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                                                    Intent intent;
                                                    switch (position) {
                                                        case 1:
                                                            intent = new Intent(sensors.this, MainActivity.class);
                                                            startActivity(intent);
                                                            break;
                                                        case 2:
                                                            break;
                                                    }
                                                }

                                                @Override
                                                public void onNothingSelected(AdapterView<?> adapterView) {

                                                }

                                            }
        );
        ImageButton record = (ImageButton) findViewById(R.id.record);
        record.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(sensors.this, Record.class);
                    startActivity(intent);
                }
            });
    }
    @Override
    public void onBackPressed() { }

}
