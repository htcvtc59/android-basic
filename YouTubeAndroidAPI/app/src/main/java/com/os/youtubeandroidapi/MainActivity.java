package com.os.youtubeandroidapi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    public static final String API_KEY = "AIzaSyCOB2SG7eIq443ItNZOAEzLxMgvGci0Rn4";

    public static final String VIDEO_ID = "Zbdyeox01SI";

    public static final String ID_LIST = "RDEMW8CIeoHL0cAS_dRxgVoJfw";
    public static final String URL_GET_LIST = "https://www.googleapis.com/youtube/v3/playlistItems?part=snippet&playlistId=" + ID_LIST + "&key=" + API_KEY+"&maxResults=26";


    ListView listviewYoutube;
    ArrayList<VideoYoutube> videoYoutubes;
    VideoYoutubeAdapter videoYoutubeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        YouTubePlayerView youTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtube_player_view);
        youTubePlayerView.initialize(API_KEY, this);

        listviewYoutube = (ListView) findViewById(R.id.listviewYoutube);
        videoYoutubes = new ArrayList<>();
        videoYoutubeAdapter = new VideoYoutubeAdapter(MainActivity.this, R.layout.row_video_youtube, videoYoutubes);

        listviewYoutube.setAdapter(videoYoutubeAdapter);

        GetJSonYoutube(URL_GET_LIST);

        listviewYoutube.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this,PlayVideoActivity.class);
                intent.putExtra("idvideo",videoYoutubes.get(i).getIdvide());
                startActivity(intent);
            }
        });


    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        if (null == youTubePlayer) return;

        // Start buffering
        if (!b) {
            youTubePlayer.cueVideo(VIDEO_ID);
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        Toast.makeText(this, "Failed to initialize.", Toast.LENGTH_LONG).show();
    }

    private void GetJSonYoutube(String url) {
        final RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,
                url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("items");
                            String title = "";
                            String url = "";
                            String idvideo = "";
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject object = jsonArray.getJSONObject(i);
                                JSONObject jsonObject = object.getJSONObject("snippet");
                                title = jsonObject.getString("title");
                                JSONObject jsonThumbnail = jsonObject.getJSONObject("thumbnails");
                                JSONObject jsonMedium = jsonThumbnail.getJSONObject("medium");
                                url = jsonMedium.getString("url");
                                JSONObject jsonResourceID = jsonObject.getJSONObject("resourceId");
                                idvideo = jsonResourceID.getString("videoId");

                                videoYoutubes.add(new VideoYoutube(title,url,idvideo));

                            }
                            videoYoutubeAdapter.notifyDataSetChanged();

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        requestQueue.add(jsonObjectRequest);

    }

}
