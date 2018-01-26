package com.os.recyclerviewtest;

import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    public void initView(){
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);

//        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this,layoutManager.getOrientation());
//        recyclerView.addItemDecoration(dividerItemDecoration);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),DividerItemDecoration.VERTICAL);
        Drawable drawable = ContextCompat.getDrawable(getApplicationContext(),R.drawable.custom_divider);
        dividerItemDecoration.setDrawable(drawable);
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        ArrayList<DataShop> dataShops = new ArrayList<>();
        dataShops.add(new DataShop(R.drawable.ic_launcher_background,"HTC"));
        dataShops.add(new DataShop(R.drawable.ic_launcher_background,"SAMSUNG"));
        dataShops.add(new DataShop(R.drawable.ic_launcher_background,"SONY"));
        dataShops.add(new DataShop(R.drawable.ic_launcher_background,"OPPO"));
        dataShops.add(new DataShop(R.drawable.ic_launcher_background,"SAMSUNG"));
        dataShops.add(new DataShop(R.drawable.ic_launcher_background,"IPHONE"));

        ShopAdapter shopAdapter = new ShopAdapter(dataShops,MainActivity.this);
        recyclerView.setAdapter(shopAdapter);

    }
}
