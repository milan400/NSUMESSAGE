

package com.example.milan.nsumessage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button button_vote,button_vote50,button_vote0;
    private TextView voteno,sendinfo;
    SmsManager smsManager;
    int number = 1;

    private String destinationaddress,message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_vote = findViewById(R.id.button_vote);
        button_vote50 = findViewById(R.id.button_vote50);
        button_vote0 = findViewById(R.id.button_vote0);
        voteno = findViewById(R.id.voteno);
        sendinfo = findViewById(R.id.sendinfo);

        destinationaddress = "31003";
        message = "NSU 01";

        sendinfo.setText("To: "+destinationaddress+" Message: "+message);

        button_vote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                votefun(50);
                }

            });

        button_vote0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                votefun(1);
            }
        });

        button_vote50.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                votefun(5);
            }
        });

        }

    private void votefun(int count) {

        for (int a = 1; a <= count; a++) {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(destinationaddress, null, message, null, null);
            //Toast.makeText(MainActivity.this,"Success no: "+number, Toast.LENGTH_SHORT).show();
            voteno.setText("count: "+number);
            number++;
        }
        Toast.makeText(this, "Successful", Toast.LENGTH_SHORT).show();


    }
}


