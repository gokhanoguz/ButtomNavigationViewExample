package com.javatar.buttomnavigationviewexample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by gokhan on 23-Feb-17.
 */

public class MyAwesomeFragment extends Fragment {
    private static final String ARG_TEXT = "MyAwesomeFragment.ARG_TEXT";

    private TextView mTextView;

    public static Fragment newInstance(String text) {
        Fragment frag = new MyAwesomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_TEXT, text);
        frag.setArguments(args);
        return frag;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_awesome, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Bundle args = getArguments();
        String title = args.getString(ARG_TEXT);

        mTextView = (TextView) view.findViewById(R.id.title);
        mTextView.setText(title);
    }

}