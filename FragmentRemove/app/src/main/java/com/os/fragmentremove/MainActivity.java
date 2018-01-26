package com.os.fragmentremove;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    FragmentManager fragmentManager = getFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void AddA(View view) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragContent, new FragmentA(), "fragA");
        fragmentTransaction.addToBackStack("adda");
        fragmentTransaction.commit();

    }

    public void AddB(View view) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragContent, new FragmentB(), "fragB");
        fragmentTransaction.addToBackStack("addb");
        fragmentTransaction.commit();
    }

    public void AddC(View view) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragContent, new FragmentC(), "fragC");
        fragmentTransaction.addToBackStack("addc");
        fragmentTransaction.commit();
    }

    public void RemoveA(View view) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentA fragmentA = (FragmentA) getFragmentManager().findFragmentByTag("fragA");
        if (fragmentA != null) {
            fragmentTransaction.remove(fragmentA);
            fragmentTransaction.commit();
        }
    }

    public void RemoveB(View view) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentB fragmentB = (FragmentB) getFragmentManager().findFragmentByTag("fragB");
        if (fragmentB != null) {
            fragmentTransaction.remove(fragmentB);
            fragmentTransaction.commit();
        }
    }

    public void RemoveC(View view) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentC fragmentC = (FragmentC) getFragmentManager().findFragmentByTag("fragC");
        if (fragmentC != null) {
            fragmentTransaction.remove(fragmentC);
            fragmentTransaction.commit();
        }
    }

    public void Back(View view) {
        getFragmentManager().popBackStack();

    }

    public void Pop(View view) {
        getFragmentManager().popBackStack("adda", 0);
    }

    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() > 0) {
            getFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }
}
