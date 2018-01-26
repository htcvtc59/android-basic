package com.os.multi_language;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtThongTin;
    Button btnXacNhan;
    EditText editHoTen, editSDT, editEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtThongTin = (TextView) findViewById(R.id.textViewThongTin);
        btnXacNhan = (Button) findViewById(R.id.buttonXacNhan);
        editHoTen = (EditText) findViewById(R.id.editTextHoTen);
        editSDT = (EditText) findViewById(R.id.editTextSdt);
        editEmail = (EditText) findViewById(R.id.editTextEmail);

        btnXacNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String hoten = editHoTen.getText().toString();
                String email = editEmail.getText().toString();
                String sdt = editSDT.getText().toString();

                String txtChao = getResources().getString(R.string.txtXinChao);

                txtThongTin.setText(txtChao + "|" + hoten + "|" + email + "|" + sdt);
            }
        });

    }
}
