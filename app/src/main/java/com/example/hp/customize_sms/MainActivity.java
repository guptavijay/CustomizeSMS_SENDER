package com.example.hp.customize_sms;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.jar.Manifest;

public class MainActivity extends AppCompatActivity {
    EditText e1, e2;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1 = (EditText) findViewById(R.id.e11);
        e2 = (EditText) findViewById(R.id.e22);
        b1 = (Button) findViewById(R.id.b11);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNo = e2.getText().toString();
                String message = e1.getText().toString();
                if (phoneNo.length() > 0 && message.length() > 0) {
                    Toast.makeText(MainActivity.this, "working", Toast.LENGTH_LONG).show();
                    sendsms(phoneNo, message);
                } else {

                }
                      // give app permission to send SMS in your mobile phone go to settings>> apps>> installed apps>> your app>> enable permission.

            }
        });
    }


    public void sendsms(String phoneNo, String message) {
        try {
            SmsManager sms = SmsManager.getDefault();
            sms.sendTextMessage(phoneNo, null, message, null, null);
            Toast.makeText(getApplicationContext(), "SMS SENT", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "SMS FAILED!", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }
}