package app.appreadjson;

import android.os.AsyncTask;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView list;
    List<RowItem> rowItems = new ArrayList<>();

    private String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        list = (ListView) findViewById(R.id.list);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                String url = "https://newsapi.org/v1/articles?source=bloomberg&sortBy=top&apiKey=ca0822c41db543bf86fcf0146e896fe7";

                new GetNews().execute(url);
            }
        });


    }

    private class GetNews extends AsyncTask<String, Integer, String> {


        @Override
        protected String doInBackground(String... strings) {
            HttpHandler sh = new HttpHandler();

            String jsonStr = sh.makeServiceCall(strings[0]);

            return jsonStr;
        }

        @Override
        protected void onPostExecute(String s) {

            try {
                JSONObject news = new JSONObject(s);
                JSONArray articles = news.getJSONArray("articles");
                for (int i = 0; i < articles.length(); i++) {
                    JSONObject c = articles.getJSONObject(i);
                    RowItem rowItem = new RowItem();
                    rowItem.setAuthor(c.getString("author"));
                    rowItem.setDesc(c.getString("description"));
                    rowItem.setPublishedat(c.getString("publishedAt"));
                    rowItem.setTitle(c.getString("title"));
                    rowItem.setUrl(c.getString("url"));
                    rowItem.setUrltoimage(c.getString("urlToImage"));

                    rowItems.add(rowItem);
                }

            } catch (JSONException e) {
                Log.e(TAG, "Json parsing error: " + e.getMessage());
            }

            CustomAdapter cus = new CustomAdapter(MainActivity.this, rowItems);
            list.setAdapter(cus);
        }

    }


}
