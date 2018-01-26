package com.os.context_menu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnCtx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCtx = (Button) findViewById(R.id.btnshowcontext);

        registerForContextMenu(btnCtx);


    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.my_context_menu, menu);
        menu.setHeaderTitle("Color");
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuitemRed:
                btnCtx.setTextColor(getResources().getColor(R.color.clrred));
                break;
            case R.id.menuitemGreen:
                btnCtx.setTextColor(getResources().getColor(R.color.clrgreen));
                break;
            case R.id.menuitemBlue:
                btnCtx.setTextColor(getResources().getColor(R.color.clrblue));
                break;
        }
        return super.onContextItemSelected(item);
    }
}
