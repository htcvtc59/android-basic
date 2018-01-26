package com.os.fragmentxulygiaodien;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SendSinhVien {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void DataStudent(SinhVien sinhVien) {
        FragmentStudentInfo fragmentStudentInfo = (FragmentStudentInfo) getFragmentManager().findFragmentById(R.id.fragmentInfo);

        Configuration configuration = getResources().getConfiguration();
//        fragmentStudentInfo.isInLayout();

        if (fragmentStudentInfo != null && configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            fragmentStudentInfo.setInfo(sinhVien);
        } else {
            Intent intent = new Intent(MainActivity.this, StudentInformationActivity.class);
            intent.putExtra("sinhvien", sinhVien);
            startActivity(intent);
        }

    }
}
