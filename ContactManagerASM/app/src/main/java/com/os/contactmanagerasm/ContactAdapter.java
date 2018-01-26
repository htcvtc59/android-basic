package com.os.contactmanagerasm;

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
 * Created by MacOS on 25/01/2018.
 */

public class ContactAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Contact> listContact;

    public ContactAdapter(Context context, int layout, List<Contact> listContact) {
        this.context = context;
        this.layout = layout;
        this.listContact = listContact;
    }

    @Override
    public int getCount() {
        return listContact.size();
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
        TextView txtNameC, txtPhoneC;
        ImageView imgContact;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);
            holder.txtNameC = (TextView) view.findViewById(R.id.txtNameContact);
            holder.txtPhoneC = (TextView) view.findViewById(R.id.txtPhoneContact);
            holder.imgContact=(ImageView)view.findViewById(R.id.imageviewContact);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        Contact contact = listContact.get(i);

        holder.txtNameC.setText(contact.getName());
        holder.txtPhoneC.setText(contact.getPhone());

        byte[] imgC = contact.getImgcontact();
        Bitmap bitmap = BitmapFactory.decodeByteArray(imgC,0,imgC.length);
        holder.imgContact.setImageBitmap(bitmap);

        return view;
    }
}
