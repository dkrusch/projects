package com.example.backup.dev_portfolio.views;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.backup.dev_portfolio.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class EducationFragment extends Fragment {


    public EducationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View educationView = inflater.inflate(R.layout.fragment_education, container, false);
        // Inflate the layout for this fragment
        return educationView;
    }

}
