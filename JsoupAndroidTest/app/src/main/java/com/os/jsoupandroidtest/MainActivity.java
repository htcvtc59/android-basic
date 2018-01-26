package com.os.jsoupandroidtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    CustomAdapterListView customAdapterListView;
    ListView listView;

    String url = "http://600tuvungtoeic.com/";
    ArrayList<TiengAnh> tiengAnhs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listTiengAnh);
        tiengAnhs = new ArrayList<>();

        customAdapterListView = new CustomAdapterListView(tiengAnhs, MainActivity.this);
        listView.setAdapter(customAdapterListView);

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(MainActivity.this, response, Toast.LENGTH_SHORT).show();
                        String name = "";
                        String img = "";
                        Document doc = Jsoup.parse(response);
                        if (doc != null) {
                            Elements elements = doc.select("div.gallery-item");
                            for (Element ele : elements) {
                                Element eTen = ele.getElementsByTag("h3").first();
                                Element eHinh = ele.getElementsByTag("img").first();

                                if (eTen != null) {
                                    name = eTen.text();
                                }
                                if (eHinh != null) {
                                    img = eHinh.attr("src");
                                }
                                tiengAnhs.add(new TiengAnh(name, img));
                            }
                            customAdapterListView.notifyDataSetChanged();
                        }

                    }
                }
                , new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });


        requestQueue.add(stringRequest);


    }
}
