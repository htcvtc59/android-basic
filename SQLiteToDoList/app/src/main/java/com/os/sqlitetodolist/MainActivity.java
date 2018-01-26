package com.os.sqlitetodolist;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.sql.BatchUpdateException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Database database;
    ListView listView;
    ArrayList<CongViec> congViecs;
    CongViecAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listview);
        congViecs = new ArrayList<>();
        arrayAdapter = new CongViecAdapter(this, R.layout.dong_cong_viec, congViecs);
        listView.setAdapter(arrayAdapter);

        database = new Database(MainActivity.this, "ghichu.sqlite", null, 1);

        database.QueryData("create table if not exists CongViec(id integer primary key autoincrement, TenCV varchar(200))");

        GetDataCV();

    }

    public void DialogXoaCV(String tencv, final int id) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Ban muon xoa cong viec " + tencv + "nay khong");

        builder.setPositiveButton("Co", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                database.QueryData("delete from CongViec where id='" + id + "'");
                GetDataCV();
            }
        });

        builder.setNegativeButton("Khong", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        builder.show();
    }

    public void DialogSuaCV(final int idd, final String ten) {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_sua_cong_viec);
        final EditText editText = (EditText) dialog.findViewById(R.id.txtSuaCV);
        Button btnSua = (Button) dialog.findViewById(R.id.btnSuaCV);
        Button btnHuy = (Button) dialog.findViewById(R.id.btnHuySua);

        editText.setText(ten);

        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tenMoi = editText.getText().toString();
                database.QueryData("update CongViec set TenCV = '" + tenMoi + "' where id='" + idd + "'");
                dialog.cancel();
                GetDataCV();
            }
        });

        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
            }
        });

        dialog.show();
    }

    private void GetDataCV() {
        Cursor dataCV = database.GetData("select * from CongViec");
        congViecs.clear();
        while (dataCV.moveToNext()) {
            String ten = dataCV.getString(1);
            int id = dataCV.getInt(0);
            congViecs.add(new CongViec(id, ten));
        }
        arrayAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_cong_viec, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menuThem) {
            DialogThem();
        }

        return super.onOptionsItemSelected(item);
    }

    private void DialogThem() {
        final Dialog dialog = new Dialog(MainActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

        dialog.setContentView(R.layout.dialog_them_cong_viec);

        final EditText editText = (EditText) dialog.findViewById(R.id.txtThemCV);
        Button btnThem = (Button) dialog.findViewById(R.id.btnThem);
        Button btnHuy = (Button) dialog.findViewById(R.id.btnHuy);

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = editText.getText().toString();
                if (s.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Nhap Ten CV", Toast.LENGTH_SHORT).show();
                } else {
                    database.QueryData("insert into CongViec values(null,'" + s + "')");
                }
                dialog.cancel();
                GetDataCV();
            }
        });

        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
            }
        });

        dialog.show();
    }

}
