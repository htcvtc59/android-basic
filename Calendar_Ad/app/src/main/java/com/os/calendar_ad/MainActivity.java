package com.os.calendar_ad;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    TextView txtTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtTime = (TextView) findViewById(R.id.txtTime);
        Calendar calendar = Calendar.getInstance();

        txtTime.append(calendar.getTime() + "\n");
        txtTime.append(calendar.get(Calendar.DATE) + "\n");
        txtTime.append(calendar.get(Calendar.MONTH) + "\n");
        txtTime.append(calendar.get(Calendar.YEAR) + "\n");

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        txtTime.append(simpleDateFormat.format(calendar.getTime())+"\n");

        txtTime.append(calendar.get(Calendar.HOUR) + "\n");

        txtTime.append(calendar.get(Calendar.HOUR_OF_DAY) + "\n");

        SimpleDateFormat simpleDateFormatG = new SimpleDateFormat("hh:mm:ss a");
        txtTime.append(simpleDateFormatG.format(calendar.getTime())+"\n");

    }


}
