package com.example.prooject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_s1;
    RadioGroup rg;
    RadioButton non;
    RadioButton oui;
    int score=0;

    // "myvideo.mp4" in directory "raw".
    public static final String RAW_VIDEO_SAMPLE = "myvideo";
    public static final String LOCAL_VIDEO_SAMPLE ="/storage/emulated/0/DCIM/Camera/VID_20180212_195520.mp4";
    public static final String URL_VIDEO_SAMPLE  = "https://raw.githubusercontent.com/o7planning/webexamples/master/_testdatas_/mov_bbb.mp4";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_s1 = (Button) findViewById(R.id.btn_s1);
        rg = (RadioGroup) findViewById(R.id.radio);
        btn_s1.setOnClickListener(this);


    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Life cycle","IN onStop");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_s1:
                int id = rg.getCheckedRadioButtonId();
                non=(RadioButton) findViewById(R.id.radioButton2);
                oui=(RadioButton) findViewById(R.id.radioButton);
                if (oui.isChecked())
                {


                    score=score+1;
                }


                Intent i = new Intent(this ,Q2.class);
                i.putExtra("score",score);
                startActivity(i);                    finish();



        }


    }
}
