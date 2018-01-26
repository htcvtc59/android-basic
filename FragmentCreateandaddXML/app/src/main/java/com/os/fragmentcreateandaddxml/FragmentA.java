package com.os.fragmentcreateandaddxml;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by MacOS on 24/01/2018.
 */

public class FragmentA extends Fragment {

    TextView txtA;
    EditText edtA;
    Button btnA;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a, container, false);
        txtA = (TextView) view.findViewById(R.id.txtfragA);
        edtA = (EditText) view.findViewById(R.id.edtfragA);
        btnA = (Button) view.findViewById(R.id.btnfragA);

        btnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 TextView txtmain = (TextView)getActivity().findViewById(R.id.textView);
                 txtmain.setText(edtA.getText().toString());
            }
        });

        return view;
    }


    public void GanNoiDung(String a) {
        txtA.setText(a);
    }

}
