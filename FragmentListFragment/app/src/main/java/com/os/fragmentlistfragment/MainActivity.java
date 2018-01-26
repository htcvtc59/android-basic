package com.os.fragmentlistfragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements IDeleteData{

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentHopThoai fragmentHopThoai = new FragmentHopThoai();
                fragmentHopThoai.show(getFragmentManager(),"hopthoai");
            }
        });

    }

    @Override
    public void GiaTriXoa(boolean delete) {
        if(delete){
            Toast.makeText(this, "Xoa", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Khong", Toast.LENGTH_SHORT).show();
        }
    }


}
