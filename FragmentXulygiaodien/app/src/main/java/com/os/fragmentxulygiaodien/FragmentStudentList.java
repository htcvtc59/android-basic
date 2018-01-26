package com.os.fragmentxulygiaodien;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by MacOS on 24/01/2018.
 */

public class FragmentStudentList extends ListFragment {

    ArrayList<SinhVien> arrSinhVien;
    StudentAdapter studentAdapter;

    SendSinhVien sendSinhVien;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        sendSinhVien = (SendSinhVien) getActivity();

        arrSinhVien = new ArrayList<>();
        AddArraySV();
        studentAdapter = new StudentAdapter(getActivity(), R.layout.row_student, arrSinhVien);
        setListAdapter(studentAdapter);

        return inflater.inflate(R.layout.fragment_student_list, container, false);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        sendSinhVien.DataStudent(arrSinhVien.get(position));

    }

    private void AddArraySV() {
        arrSinhVien.add(new SinhVien("A", 1997, "ha nam", "a@gmail.com"));
        arrSinhVien.add(new SinhVien("B", 1992, "ha noi", "b@gmail.com"));
        arrSinhVien.add(new SinhVien("C", 1990, "hai phong", "c@gmail.com"));
        arrSinhVien.add(new SinhVien("D", 2000, "nam dinh", "d@gmail.com"));
        arrSinhVien.add(new SinhVien("E", 2001, "ha nam", "e@gmail.com"));
        arrSinhVien.add(new SinhVien("F", 1995, "ha nam", "f@gmail.com"));
        arrSinhVien.add(new SinhVien("G", 1994, "ha nam", "g@gmail.com"));
    }


}
