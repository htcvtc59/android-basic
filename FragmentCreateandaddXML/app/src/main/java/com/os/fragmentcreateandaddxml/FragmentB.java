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

public class FragmentB extends Fragment {

    TextView txtB;
    EditText edtB;
    Button btnB;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_b, container, false);
        txtB = (TextView) view.findViewById(R.id.txtfragB);
        edtB = (EditText) view.findViewById(R.id.edtfragB);
        btnB = (Button) view.findViewById(R.id.btnfragB);
        btnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView txtA = (TextView)getActivity().findViewById(R.id.txtfragA);
                txtA.setText(edtB.getText().toString());
            }
        });

        return view;
    }
}
