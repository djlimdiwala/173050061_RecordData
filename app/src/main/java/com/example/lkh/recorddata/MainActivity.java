package com.example.lkh.recorddata;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.hardware.Sensor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        final Spinner mySpinner;
        mySpinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> myAdpater =new
                ArrayAdapter<String>(MainActivity.this ,R.layout.support_simple_spinner_dropdown_item,
                getResources().getStringArray(R.array.Menu));
        myAdpater.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdpater);

        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view,
                                       int position, long l) {
                Intent intent;
                switch (position) {
                    case 1:
                        break;
                    case 2:
                        intent = new Intent(MainActivity.this, sensors.class);
                        startActivity(intent);
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
                Intent intent = new Intent(MainActivity.this, Record.class);
                startActivity(intent);
            }
        });






        Button log_in = (Button) findViewById(R.id.login);
        log_in.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                final EditText first = (EditText) findViewById(R.id.first_name);
                final EditText last = (EditText) findViewById(R.id.last_name);
                final EditText mobile_no = (EditText) findViewById(R.id.mobile);
                final EditText email = (EditText)findViewById(R.id.email);
                final EditText agee = (EditText)findViewById(R.id.age);


                if (first.getText().toString().length() == 0)
                {
                   // Toast.makeText(getApplicationContext(),"Please Enter First Name",Toast.LENGTH_SHORT).show();
                    first.setError("Enter First Name");
                    first.requestFocus();
                }
                else if (last.getText().toString().length() == 0)
                {
                   // Toast.makeText(getApplicationContext(),"Please Enter Last Name",Toast.LENGTH_SHORT).show();
                    last.setError("Enter Last Name");
                    last.requestFocus();
                }
                else if (!mobile_validate(mobile_no.getText().toString()))
                {
                    //Toast.makeText(getApplicationContext(),"Invalid email address",Toast.LENGTH_SHORT).show();
                    mobile_no.setError("Invalid mobile");
                    mobile_no.requestFocus();
                }
                else if (!email_validate(email.getText().toString()))
                {
                    //Toast.ma]]]]keText(getApplicationContext(),"Invalid email address",Toast.LENGTH_SHORT).show();
                    email.setError("Invalid Email");
                    email.requestFocus();
                }

                else if (agee.getText().toString().length() == 0)
                {
                    agee.setError("Enter Age");
                    agee.requestFocus();
                }
                else if (!age_validate(agee.getText().toString()))
                {
                    //Toast.makeText(getApplicationContext(),"Invalid email address",Toast.LENGTH_SHORT).show();
                    agee.setError("Invalid Age");
                    agee.requestFocus();
                }


            }


        });


}

protected boolean email_validate(String mail)
{
    if (TextUtils.isEmpty(mail))
    {
        return false;
    }
    else
    {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(mail).matches();
    }
}
protected boolean mobile_validate(String mobile)
    {
        if (TextUtils.isEmpty(mobile))
        {
            return false;
        }
        else
        {
            return android.util.Patterns.PHONE.matcher(mobile).matches();
        }
    }


    protected boolean age_validate(String age)
    {
        Integer age_int = Integer.parseInt(age);
        if (age_int <= 0 || age_int > 150)
        {
            return false;
        }
        else
        {
            return true;
        }
    }



}