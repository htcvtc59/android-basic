package app.miworkapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);

        ArrayList<String> words = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            words.add("words" + i);
        }

        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, words);

        GridView gridView = (GridView) findViewById(R.id.list);

        gridView.setAdapter(itemsAdapter);
    }
}
