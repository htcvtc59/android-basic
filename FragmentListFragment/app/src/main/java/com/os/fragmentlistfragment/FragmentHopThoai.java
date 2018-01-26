package com.os.fragmentlistfragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

/**
 * Created by MacOS on 24/01/2018.
 */

public class FragmentHopThoai extends DialogFragment {

    IDeleteData iDeleteData;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        iDeleteData = (IDeleteData) getActivity();

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Xac Nhan");
        builder.setMessage("Ban co muon xoa san pham nay khong");
        builder.setPositiveButton("Co", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                 iDeleteData.GiaTriXoa(true);
            }
        });
        builder.setNegativeButton("Khong", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                iDeleteData.GiaTriXoa(false);
            }
        });

        Dialog hopthoai = builder.create();

        return hopthoai;
    }
}
