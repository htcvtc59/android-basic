package com.os.okhttptest;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class GeturlActivity extends AppCompatActivity {
    EditText edturl;
    Button btnres;
    TextView textViewdata;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geturl);

        edturl = (EditText) findViewById(R.id.edturl);
        btnres = (Button) findViewById(R.id.btnResponse);
        textViewdata = (TextView) findViewById(R.id.textviewresdata);

        btnres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new GetUrl().execute("http://" + edturl.getText().toString());
            }
        });

    }

    public class GetUrl extends AsyncTask<String, String, String> {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(15, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .build();

        @Override
        protected String doInBackground(String... strings) {
            Request.Builder builder = new Request.Builder();
            builder.url(strings[0]);
            Request request = builder.build();
            try {
                Response response = okHttpClient.newCall(request).execute();
                return response.body().string();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            if (!s.equals("")) {
                textViewdata.append(s);
            }
            super.onPostExecute(s);
        }
    }

}
