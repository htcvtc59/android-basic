package com.os.mediaappmusic;

import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView txtTenBai, txtStartTime, txtEndTime;
    Button btnPre, btnPlay, btnStop, btnNext;
    SeekBar seekBar;

    ArrayList<Song> arraySong;
    int position = 0;
    MediaPlayer mediaPlayer = null;

    ImageView imageView;
    Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtTenBai = (TextView) findViewById(R.id.txtTenbai);
        txtStartTime = (TextView) findViewById(R.id.txtStartTime);
        txtEndTime = (TextView) findViewById(R.id.txtEndTime);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        btnPre = (Button) findViewById(R.id.btnPre);
        btnPlay = (Button) findViewById(R.id.btnPlay);
        btnStop = (Button) findViewById(R.id.btnStop);
        btnNext = (Button) findViewById(R.id.btnNext);
        imageView =(ImageView)findViewById(R.id.imageView);

        arraySong = new ArrayList<>();
        arraySong.add(new Song("all fall down", R.raw.alan_walker_all_falls_down));
        arraySong.add(new Song("anh khong muon bat cong voi em", R.raw.anh_khong_muon_bat_cong_voi_em));

        animation = AnimationUtils.loadAnimation(this,R.anim.disc_music);


        KhoiTaoMedia();

        btnPre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                position--;
                if (position < 0) {
                    position = arraySong.size() - 1;
                }
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                }
                KhoiTaoMedia();
                mediaPlayer.start();
                btnPlay.setText("Pause");
                EndTime();
                UpdateTimeSong();
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                position++;
                if (position > arraySong.size() - 1) {
                    position = 0;
                }
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                }
                KhoiTaoMedia();
                mediaPlayer.start();
                btnPlay.setText("Pause");
                EndTime();
                UpdateTimeSong();
            }
        });

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    btnPlay.setText("Play");
                } else {
                    mediaPlayer.start();
                    btnPlay.setText("Pause");
                }
                EndTime();
                UpdateTimeSong();
                imageView.startAnimation(animation);
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.stop();
                btnPlay.setText("Play");
                mediaPlayer.release();
                KhoiTaoMedia();
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mediaPlayer.seekTo(seekBar.getProgress());
            }
        });


    }

    private void UpdateTimeSong() {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss");
                txtStartTime.setText(simpleDateFormat.format(mediaPlayer.getCurrentPosition()));

                seekBar.setProgress(mediaPlayer.getCurrentPosition());
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        position++;
                        if (position > arraySong.size() - 1) {
                            position = 0;
                        }
                        if (mediaPlayer.isPlaying()) {
                            mediaPlayer.stop();
                        }
                        KhoiTaoMedia();
                        mediaPlayer.start();
                        btnPlay.setText("Pause");
                        EndTime();
                        UpdateTimeSong();

                    }
                });

                handler.postDelayed(this, 500);
            }
        }, 100);

    }

    private void EndTime() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss");
        txtEndTime.setText(simpleDateFormat.format(mediaPlayer.getDuration()));
        seekBar.setMax(mediaPlayer.getDuration());
    }

    private void KhoiTaoMedia() {
        mediaPlayer = MediaPlayer.create(MainActivity.this, arraySong.get(position).getFile());
        txtTenBai.setText(arraySong.get(position).getTitle());
    }
}
