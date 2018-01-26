package com.os.jsoupandroidtest;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by MacOS on 26/01/2018.
 */

public class CustomAdapterListView extends BaseAdapter {
    ArrayList<TiengAnh> tiengAnhs;
    Context context;

    public CustomAdapterListView(ArrayList<TiengAnh> tiengAnhs, Context context) {
        this.tiengAnhs = tiengAnhs;
        this.context = context;
    }

    @Override
    public int getCount() {
        return tiengAnhs.size();
    }

    @Override
    public Object getItem(int i) {
        return tiengAnhs.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.item_row,null);
        TextView textView = (TextView) view.findViewById(R.id.textView);
        ImageView imageView = (ImageView)view.findViewById(R.id.imageView);
        TiengAnh tiengAnh = tiengAnhs.get(i);

        textView.setText(tiengAnh.getTenkhoahoc());

        Picasso.with(context).load(tiengAnh.getHinhanh()).into(imageView);

        return view;
    }
}
