package com.os.fragmentsendandrecievedata;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by MacOS on 24/01/2018.
 */

public class FragmentA extends Fragment {
    TextView txtNoidung;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a,container,false);
        txtNoidung = (TextView)view.findViewById(R.id.txtNoidung);

        Bundle bundle = getArguments();
        if(bundle!=null){
            txtNoidung.setText(bundle.getString("hello"));
        }
        return view;
    }
}
