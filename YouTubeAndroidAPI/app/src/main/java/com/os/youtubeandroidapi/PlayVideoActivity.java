
package com.os.youtubeandroidapi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class PlayVideoActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    YouTubePlayerView youTubePlayerView;
    String idvideo = "";
    int REQUEST_V = 456;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_video);

        Intent intent = getIntent();
        idvideo = intent.getStringExtra("idvideo");

        youTubePlayerView = (YouTubePlayerView) findViewById(R.id.myYouPlay);

        youTubePlayerView.initialize(MainActivity.API_KEY, this);

    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        youTubePlayer.loadVideo(idvideo);
//        youTubePlayer.setFullscreen(true);

    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
      if(youTubeInitializationResult.isUserRecoverableError()){
          youTubeInitializationResult.getErrorDialog(PlayVideoActivity.this,REQUEST_V);
      }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==REQUEST_V){
            youTubePlayerView.initialize(MainActivity.API_KEY,PlayVideoActivity.this);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
