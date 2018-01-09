package app.appreadjson;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class CustomAdapter extends BaseAdapter {
    Context context;
    List<RowItem> rowItems;

    public CustomAdapter() {
    }

    CustomAdapter(Context context, List<RowItem> rowItems) {
        this.context = context;
        this.rowItems = rowItems;
    }

    @Override
    public int getCount() {
        return rowItems.size();
    }

    @Override
    public Object getItem(int i) {
        return rowItems.get(i);
    }

    @Override
    public long getItemId(int i) {
        return rowItems.indexOf(getItem(i));
    }

    private class ViewHolder {
        ImageView imagenew;
        TextView author;
        TextView title;
        TextView desc;
        TextView url;

    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        LayoutInflater layoutInflater = (LayoutInflater) context
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (view == null) {
            view = layoutInflater.inflate(R.layout.list_item, null);
            holder = new ViewHolder();

            holder.imagenew = (ImageView) view.findViewById(R.id.imagenew);
            holder.author = (TextView) view.findViewById(R.id.author);
            holder.title = (TextView) view.findViewById(R.id.title);
            holder.desc = (TextView) view.findViewById(R.id.desc);
            holder.url = (TextView) view.findViewById(R.id.url);

            RowItem rowItem = rowItems.get(i);
            if (rowItem.getUrltoimage().length() != 0)
                holder.imagenew.setImageBitmap(getBitmapFromURL(rowItem.getUrltoimage()));
            holder.author.setText(rowItem.getAuthor());
            holder.title.setText(rowItem.getTitle());
            holder.desc.setText(rowItem.getDesc());
            holder.url.setText(rowItem.getUrl());
        }


        return view;
    }


    public static Bitmap getBitmapFromURL(String imageUrl) {
        InputStream in = null;
        try {
            URL url = new URL(imageUrl);
            HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();

            httpConn.setAllowUserInteraction(false);
            httpConn.setInstanceFollowRedirects(true);
            httpConn.setRequestMethod("GET");
            httpConn.connect();
            int resCode = httpConn.getResponseCode();

            if (resCode == HttpURLConnection.HTTP_OK) {
                in = httpConn.getInputStream();
            } else {
                return null;
            }

            Bitmap bitmap = BitmapFactory.decodeStream(in);
            return bitmap;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;

    }


}