package com.os.SQLite_luu_hinh_anh;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by MacOS on 22/01/2018.
 */

public class DoVatAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<DoVat> doVatList;

    public DoVatAdapter(Context context, int layout, List<DoVat> doVatList) {
        this.context = context;
        this.layout = layout;
        this.doVatList = doVatList;
    }

    @Override
    public int getCount() {
        return doVatList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    private class ViewHolder {
        ImageView imgHinh;
        TextView txtTen, txtMota;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);
            holder.txtTen = (TextView) view.findViewById(R.id.txtTenDV);
            holder.txtMota = (TextView) view.findViewById(R.id.txtMotaDV);
            holder.imgHinh = (ImageView) view.findViewById(R.id.imgHinhDV);

            view.setTag(holder);

        } else {
            holder = (ViewHolder) view.getTag();
        }
        DoVat doVat = doVatList.get(i);
        holder.txtTen.setText(doVat.getTen());
        holder.txtMota.setText(doVat.getMota());

        byte[] hinhAnh= doVat.getHinh();
        Bitmap bitmap = BitmapFactory.decodeByteArray(hinhAnh,0,hinhAnh.length);
        holder.imgHinh.setImageBitmap(bitmap);

        return view;
    }
}
