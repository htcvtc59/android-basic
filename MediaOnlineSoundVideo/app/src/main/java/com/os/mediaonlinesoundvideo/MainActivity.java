package com.os.mediaonlinesoundvideo;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    Button btnPlayMp3, btnVideo;
    VideoView videoView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPlayMp3 = (Button) findViewById(R.id.btnPlay);
        btnVideo = (Button) findViewById(R.id.btnVideo);
        videoView = (VideoView) findViewById(R.id.videoView);


        btnPlayMp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "http://khoapham.vn/download/vietnamoi.mp3";
                MediaPlayer mediaPlayer = new MediaPlayer();
                mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                try {
                    mediaPlayer.setDataSource(url);
                    mediaPlayer.prepareAsync();
                    mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mediaPlayer) {
                            mediaPlayer.start();
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        btnVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("http://khoapham.vn/download/vuoncaovietnam.mp4");
                videoView.setVideoURI(uri);
                videoView.setMediaController(new MediaController(MainActivity.this));
                videoView.start();
            }
        });
    }
}
