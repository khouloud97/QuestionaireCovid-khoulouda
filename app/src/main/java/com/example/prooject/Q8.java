package com.example.prooject;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Q8 extends AppCompatActivity implements View.OnClickListener {

    Button btn_s1;
    RadioGroup rg;
    RadioButton non;
    RadioButton oui;
    int score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q8);
        createNotificationChannel();


            btn_s1=(Button)findViewById(R.id.btn_s1);
        rg = (RadioGroup)findViewById(R.id.radio);
        btn_s1.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_s1:
                int id = rg.getCheckedRadioButtonId();
                non=(RadioButton) findViewById(R.id.radioButton2);
                oui=(RadioButton) findViewById(R.id.radioButton);
                if (oui.isChecked())
                {

                    score= getIntent().getExtras().getInt("score");
                    score=score+1;
                }
                else
                {
                    score= getIntent().getExtras().getInt("score");
                }

                Toast.makeText(this,String.valueOf(score),Toast.LENGTH_LONG).show();

                if(score>4)
                {
                    createNotificationChannel();
                    Toast.makeText(Q8.this, "CALL 190 ", Toast.LENGTH_SHORT).show();

                    Intent p1 = new Intent(this, Call.class);
                    PendingIntent pendingIntent =
                            PendingIntent.getBroadcast(Q8.this, 0, p1, 0);


                    AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

                    long currentTime = System.currentTimeMillis();
                    //1000 milli= 1 sec
                    long tenSeconds = 10 * 1000;

                    alarmManager.set(
                            AlarmManager.RTC_WAKEUP,
                            currentTime + tenSeconds,
                            pendingIntent);
                    startActivity(p1);
                    finish();
                }
                else {

                    Intent p1 = new Intent(this, Good.class);
                    startActivity(p1);
                    finish();
                    }
        }





    }
    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Resulta";
            String description = "you have Coronaa ";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("Resulta", name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
}}