package com.os.fragmentxulygiaodien;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.Serializable;

public class StudentInformationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_information);

        Intent intent = getIntent();
        SinhVien sinhvien = (SinhVien) intent.getSerializableExtra("sinhvien");

        FragmentStudentInfo fragmentStudentInfo = (FragmentStudentInfo) getFragmentManager().findFragmentById(R.id.fragmentChiTiet);
        fragmentStudentInfo.setInfo(sinhvien);
    }
}
