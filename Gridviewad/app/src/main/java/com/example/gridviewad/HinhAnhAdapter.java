package com.example.gridviewad;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.io.PipedReader;
import java.util.List;

/**
 * Created by MacOS on 15/01/2018.
 */

public class HinhAnhAdapter extends BaseAdapter {
    private Context context;
    private int layout ;
    private List<HinhAnh> hinhAnhs;

    public HinhAnhAdapter(Context context, int layout, List<HinhAnh> hinhAnhs) {
        this.context = context;
        this.layout = layout;
        this.hinhAnhs = hinhAnhs;
    }

    @Override
    public int getCount() {
        return hinhAnhs.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    private class ViewHolder{
        ImageView imgHinh;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;

        if(view==null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout,null);

           holder.imgHinh = (ImageView)view.findViewById(R.id.imageHinhAnh);
           view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }

        HinhAnh hinhAnh = hinhAnhs.get(i);

        holder.imgHinh.setImageResource(hinhAnh.getHinh());

        return view;
    }
}
