package com.os.contactmanagerasm;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static Database database;
    public static ListView listview_contact;
    public static ArrayList<Contact> listContacts;
    public static ContactAdapter contactAdapter;

    Button btnadd_activity;

    int positionC = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnadd_activity = (Button) findViewById(R.id.btnadd_activity);
        listview_contact = (ListView) findViewById(R.id.listview_contact);
        listContacts = new ArrayList<>();
        contactAdapter = new ContactAdapter(MainActivity.this, R.layout.row_contact_manager, listContacts);
        listview_contact.setAdapter(contactAdapter);

        database = new Database(MainActivity.this, "contact.sqlite", null, 1);

        database.QueryData("create table if not exists Contact(id integer primary key autoincrement, Name varchar(200), Phone varchar(200) , ImgC blob)");

        GetDataContact();

        btnadd_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddContactActivity.class);
                startActivity(intent);
            }
        });

        listview_contact.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                registerForContextMenu(listview_contact);
                positionC = i;
                return false;
            }
        });

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu_context, menu);
        menu.setHeaderTitle("Contact");
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuEdit:
                Intent intent = new Intent(MainActivity.this, EditContactActivity.class);
                intent.putExtra("contact", listContacts.get(positionC));
                startActivity(intent);
                break;
            case R.id.menuDelete:
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setMessage("Delete Contact : " + listContacts.get(positionC).getName());
                dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        database.QueryData("delete from Contact where id='" + listContacts.get(positionC).getId() + "'");
                        GetDataContact();
                    }
                });
                dialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                dialog.show();

                break;
        }

        return super.onContextItemSelected(item);
    }

    private void GetDataContact() {
        Cursor dataContact = database.GetData("select * from Contact");
        listContacts.clear();
        while (dataContact.moveToNext()) {
            int id = dataContact.getInt(0);
            String name = dataContact.getString(1);
            String phone = dataContact.getString(2);
            listContacts.add(new Contact(id, name, phone, dataContact.getBlob(3)));
        }
        contactAdapter.notifyDataSetChanged();
    }
}
