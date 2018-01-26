package game.gameaninterestingrace;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView txtDiem;
    CheckBox cbOne, cbTwo, cbThree;
    SeekBar skOne, skTwo, skThree;
    ImageButton ibtnPlay;
    int soDiem = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById();
        txtDiem.setText(soDiem + "");

        final CountDownTimer countDownTimer = new CountDownTimer(60000, 300) {
            @Override
            public void onTick(long l) {
                int number = 5;
                Random random = new Random();
                int one = random.nextInt(number);
                int two = random.nextInt(number);
                int three = random.nextInt(number);

                if (skOne.getProgress() >= skOne.getMax()) {
                    this.cancel();
                    Toast.makeText(MainActivity.this, "1", Toast.LENGTH_SHORT).show();
                    ibtnPlay.setVisibility(View.VISIBLE);
                    if (cbOne.isChecked()) {
                        soDiem += 10;
                    } else {
                        soDiem -= 5;
                    }
                    txtDiem.setText(soDiem + "");
                    enablecheck();
                }
                if (skTwo.getProgress() >= skTwo.getMax()) {
                    this.cancel();
                    Toast.makeText(MainActivity.this, "2", Toast.LENGTH_SHORT).show();
                    ibtnPlay.setVisibility(View.VISIBLE);
                    if (cbTwo.isChecked()) {
                        soDiem += 10;
                    } else {
                        soDiem -= 5;
                    }
                    txtDiem.setText(soDiem + "");
                    enablecheck();
                }
                if (skThree.getProgress() >= skThree.getMax()) {
                    this.cancel();
                    Toast.makeText(MainActivity.this, "3", Toast.LENGTH_SHORT).show();
                    ibtnPlay.setVisibility(View.VISIBLE);
                    if (cbThree.isChecked()) {
                        soDiem += 10;
                    } else {
                        soDiem -= 5;
                    }
                    txtDiem.setText(soDiem + "");
                    enablecheck();
                }

                skOne.setProgress(skOne.getProgress() + one);
                skTwo.setProgress(skTwo.getProgress() + two);
                skThree.setProgress(skThree.getProgress() + three);

            }

            @Override
            public void onFinish() {

            }
        };

        ibtnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cbOne.isChecked() || cbTwo.isChecked() || cbThree.isChecked()) {
                    skOne.setProgress(0);
                    skTwo.setProgress(0);
                    skThree.setProgress(0);

                    ibtnPlay.setVisibility(View.INVISIBLE);
                    countDownTimer.start();
                    disablecheck();
                } else {
                    Toast.makeText(MainActivity.this, "Checkbox", Toast.LENGTH_SHORT).show();
                }


            }
        });

        cbOne.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                cbTwo.setChecked(false);
                cbThree.setChecked(false);
            }
        });

        cbTwo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                cbOne.setChecked(false);
                cbThree.setChecked(false);
            }
        });
        cbThree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                cbTwo.setChecked(false);
                cbOne.setChecked(false);
            }
        });

    }

    private void enablecheck() {
        cbOne.setEnabled(true);
        cbTwo.setEnabled(true);
        cbThree.setEnabled(true);

        skOne.setEnabled(true);
        skTwo.setEnabled(true);
        skThree.setEnabled(true);
    }

    private void disablecheck() {
        cbOne.setEnabled(false);
        cbTwo.setEnabled(false);
        cbThree.setEnabled(false);

        skOne.setEnabled(false);
        skTwo.setEnabled(false);
        skThree.setEnabled(false);
    }

    private void findViewById() {
        txtDiem = (TextView) findViewById(R.id.textView);
        ibtnPlay = (ImageButton) findViewById(R.id.imageButton);
        cbOne = (CheckBox) findViewById(R.id.checkBox1);
        cbTwo = (CheckBox) findViewById(R.id.checkBox2);
        cbThree = (CheckBox) findViewById(R.id.checkBox3);
        skOne = (SeekBar) findViewById(R.id.seekBar);
        skTwo = (SeekBar) findViewById(R.id.seekBar2);
        skThree = (SeekBar) findViewById(R.id.seekBar3);
    }
}
