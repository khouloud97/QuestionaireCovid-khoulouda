package com.example.prooject;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Evax extends AppCompatActivity {
Button evax;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evax);
evax = (Button)findViewById(R.id.evax);
evax.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
         Intent intent =new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.evax.tn/home.xhtml"));
        startActivity(intent);

    }
});
    }



}