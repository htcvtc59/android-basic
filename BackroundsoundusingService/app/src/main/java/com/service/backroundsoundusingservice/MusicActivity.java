package com.service.backroundsoundusingservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MusicActivity extends AppCompatActivity {
    Button btnPlay,btnStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        btnPlay = (Button) findViewById(R.id.btnPlay);
        btnStop = (Button) findViewById(R.id.btnStop);

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.getId()==R.id.btnPlay){
                    Intent intent = new Intent(MusicActivity.this, MyService.class);
                    startService(intent);
                }
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.getId()==R.id.btnStop){
                    Intent intent = new Intent(MusicActivity.this, MyService.class);
                    stopService(intent);
                }
            }
        });
    }
}
