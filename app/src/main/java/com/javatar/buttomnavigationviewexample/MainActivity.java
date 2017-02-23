package com.javatar.buttomnavigationviewexample;

import android.support.annotation.ColorRes;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private static final String SELECTED_ITEM = "MainActivity.SELECTED_ITEM";

    private BottomNavigationView mButtomNavigationView;
    private int mSelectedItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButtomNavigationView = (BottomNavigationView) findViewById(R.id.buttomnavigationview);
        mButtomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                selectFragment(item);
                return true;
            }
        });

        MenuItem selectedItem = mButtomNavigationView.getMenu().getItem(0);
        selectFragment(selectedItem);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(SELECTED_ITEM, mSelectedItem);
        super.onSaveInstanceState(outState);
    }


    private void selectFragment(MenuItem item) {
        Fragment fragment = null;
        switch (item.getItemId()) {
            case R.id.nav_home:
                fragment = MyAwesomeFragment.newInstance(getString(R.string.home));
                break;
            case R.id.nav_favourites:
                fragment = MyAwesomeFragment.newInstance(getString(R.string.favourites));
                break;
            case R.id.nav_search:
                fragment = MyAwesomeFragment.newInstance(getString(R.string.search));
                break;
        }

        mSelectedItem = item.getItemId();

        for (int i = 0; i< mButtomNavigationView.getMenu().size(); i++) {
            MenuItem menuItem = mButtomNavigationView.getMenu().getItem(i);
            menuItem.setChecked(false);
        }
        item.setChecked(true);


        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.container, fragment, fragment.getTag());
            ft.commit();
        }
    }

}