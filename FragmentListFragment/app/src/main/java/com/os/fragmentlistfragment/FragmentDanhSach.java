package com.os.fragmentlistfragment;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by MacOS on 24/01/2018.
 */

public class FragmentDanhSach extends ListFragment {
    String[] arryCity = {"Ha Nam", "Ha Noi", "HCM", "Quang Ngai", "Quang Tri", "Ninh Binh", "Nam Dinh"};
    ArrayAdapter arrayAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        arrayAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, arryCity);
        setListAdapter(arrayAdapter);

        return inflater.inflate(R.layout.fragment_danh_sach, container, false);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Toast.makeText(getActivity(), arryCity[position], Toast.LENGTH_SHORT).show();

        super.onListItemClick(l, v, position, id);
    }
}
