package app.miworkapp;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class WordAdapter extends ArrayAdapter<Word> {

    public static final String LOG_TAG = WordAdapter.class.getSimpleName();


    public WordAdapter(Activity context, ArrayList<Word> wordArrayList) {
        super(context, 0, wordArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView  = convertView;
        if(listItemView==null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }

        Word currentWord = getItem(position);
        TextView nameTextView = (TextView)listItemView.findViewById(R.id.version_name);
        nameTextView.setText(currentWord.getmDefaultTranslation());

        TextView numberTextView = (TextView) listItemView.findViewById(R.id.version_number);
        numberTextView.setText(currentWord.getmMiworkTranslation());

//        ImageView iconView = (ImageView) listItemView.findViewById(R.id.list_item_icon);
//        iconView.setImageResource(Integer.parseInt(currentWord.getmMiworkTranslation()));

        return listItemView;
    }
}
