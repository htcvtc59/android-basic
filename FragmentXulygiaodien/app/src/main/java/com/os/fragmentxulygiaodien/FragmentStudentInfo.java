package com.os.fragmentxulygiaodien;

import android.app.Fragment;
import android.app.ListFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by MacOS on 24/01/2018.
 */

public class FragmentStudentInfo extends Fragment {

    TextView txtTen, txtDiaChi, txtNamSinh, txtEmail;
    View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_student_info, container, false);
        findbyid();



        return view;
    }

    public void setInfo(SinhVien sinhVien){
        txtTen.setText(sinhVien.getHoten());
        txtNamSinh.setText(sinhVien.getNamsinh()+"");
        txtDiaChi.setText(sinhVien.getDiachi());
        txtEmail.setText(sinhVien.getEmail());
    }

    private void findbyid() {
        txtTen = (TextView) view.findViewById(R.id.txtTen);
        txtNamSinh = (TextView) view.findViewById(R.id.txtNamSinh);
        txtDiaChi = (TextView) view.findViewById(R.id.txtDiaChi);
        txtEmail = (TextView) view.findViewById(R.id.txtEmail);
    }
}
