package com.example.prooject;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Call extends AppCompatActivity {
private Button button ;
    Button exit;
   MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);

        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.aaa);

        mediaPlayer.start();
        button = (Button) findViewById(R.id.call);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                String number = "99779192";
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" +number));
                startActivity(intent);
                mediaPlayer.stop();

             }
        });

        exit =(Button) findViewById(R.id.exit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                moveTaskToBack(true);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
                finish();
                moveTaskToBack(true);

            }
        });
    }

}



