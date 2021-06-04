package com.example.prooject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Page1 extends AppCompatActivity {
    ImageButton info;
    ImageButton map;
    ImageButton btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page1);

        btn = (ImageButton) findViewById(R.id.imageButton);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent p1 = new Intent(Page1.this, MainActivity.class);
                startActivity(p1);
            }

        });


        info = (ImageButton) findViewById(R.id.info);
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent p1 = new Intent(Page1.this, Evax.class);
                startActivity(p1);
            }
        });


        map = (ImageButton) findViewById(R.id.map);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent p = new Intent(Page1.this, MainActivity4.class);
                startActivity(p);

            }
        });


    }
}