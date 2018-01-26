package com.os.medialocalvideo;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        videoView = (VideoView) findViewById(R.id.videoView);

        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.fall_in_down));

        videoView.start();
        MediaController mediaController = new MediaController(this);
        mediaController.setMediaPlayer(videoView);
        videoView.setMediaController(mediaController);

    }
}
