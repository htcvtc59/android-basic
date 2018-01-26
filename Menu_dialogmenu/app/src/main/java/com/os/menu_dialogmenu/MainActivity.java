package com.os.menu_dialogmenu;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btnPop, btnContext;
    ConstraintLayout manHinh;

    ListView listView;
    ArrayList<String> arrayList;
    ArrayAdapter arrayAdapter;

    TextView txtDangNhap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPop = (Button) findViewById(R.id.buttonMenuPopup);
        btnContext = (Button) findViewById(R.id.buttonContextMenu);
        manHinh = (ConstraintLayout) findViewById(R.id.manHinh);


        btnPop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShowMenu();
            }
        });

        registerForContextMenu(btnContext);


        listView = (ListView) findViewById(R.id.listView);
        arrayList = new ArrayList<>();
        arrayList.add("Android");
        arrayList.add("Ios");
        arrayList.add("Php");
        arrayList.add("NodeJs");
        arrayList.add("Unity");
        arrayList.add("UnReal");

        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                XacNhanXoa(i);
                return false;
            }
        });


//        Dialog Custom
        txtDangNhap = (TextView) findViewById(R.id.txtDangNhap);
        txtDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogLogin();
            }
        });


    }


    private void DialogLogin() {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_custom);
        dialog.setCanceledOnTouchOutside(false);

        final EditText edtusername = (EditText) dialog.findViewById(R.id.editUsername);
        final EditText edtpassword = (EditText) dialog.findViewById(R.id.editPassword);
        Button btnDongY = (Button) dialog.findViewById(R.id.btnDongY);
        Button btnHuy = (Button) dialog.findViewById(R.id.btnHuy);

        btnDongY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edtusername.getText().toString();
                String password = edtpassword.getText().toString();
                if (username.equals("admin") && password.equals("admin")) {
                    Toast.makeText(MainActivity.this, "dang nhap thanh cong", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "dang nhap that bai", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                dialog.cancel();
                dialog.dismiss();
            }
        });


        dialog.show();
    }

    private void XacNhanXoa(final int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Thong Bao!");
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setMessage("Ban co muon xoa khong?");
        builder.setPositiveButton("Co", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                arrayList.remove(position);
                arrayAdapter.notifyDataSetChanged();
            }
        });

        builder.setNegativeButton("Khong", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {


            }
        });

        builder.show();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu_context, menu);
        menu.setHeaderTitle("Chon Mau");
        menu.setHeaderIcon(R.mipmap.ic_launcher);
        super.onCreateContextMenu(menu, v, menuInfo);

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuVang:
                manHinh.setBackgroundColor(Color.YELLOW);
                break;
            case R.id.menuDo:
                manHinh.setBackgroundColor(Color.RED);
                break;
            case R.id.menuXanh:
                manHinh.setBackgroundColor(Color.GREEN);
                break;
        }
        return super.onContextItemSelected(item);
    }

    private void ShowMenu() {
        PopupMenu popupMenu = new PopupMenu(this, btnPop);
        popupMenu.getMenuInflater().inflate(R.menu.menu_popup, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.menuAdd:
                        btnPop.setText("Menu Add");
                        break;
                    case R.id.menuEdit:
                        btnPop.setText("Menu Edit");
                        break;
                    case R.id.menuDelete:
                        btnPop.setText("Menu Delete");
                        break;
                }

                return false;
            }
        });
        popupMenu.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_custom, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuSettings:
                Toast.makeText(this, "setting", Toast.LENGTH_SHORT).show();

                break;
            case R.id.menuEmail:
                Toast.makeText(this, "email", Toast.LENGTH_SHORT).show();

                break;
            case R.id.menuPhone:
                Toast.makeText(this, "phone", Toast.LENGTH_SHORT).show();

                break;
            case R.id.menuSearch:
                Toast.makeText(this, "search", Toast.LENGTH_SHORT).show();

                break;
            case R.id.menuShares:
                Toast.makeText(this, "share", Toast.LENGTH_SHORT).show();

                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
