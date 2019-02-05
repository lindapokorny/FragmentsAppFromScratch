package com.pursuit.feb4classwithjosefragmentsappfromscratch;


import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {
    private static final String NAME ="name";
    private static final String NUMBER = "number";
    private static final String URL = "image";
    String planetName;
    String planetNumber;
    String planetUrl;
    TextView name;
    TextView number;
    ImageView url;
    View rootView;

    public static BlankFragment newInstance(String name, String num, String url){
        BlankFragment fragment = new BlankFragment();
        Bundle bundle = new Bundle();
        bundle.putString(NAME, name);
        bundle.putString(NUMBER, num);
        bundle.putString(URL, url);
        fragment.setArguments(bundle);

        return fragment;
    }


    public BlankFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null){
            planetName = getArguments().getString(NAME);
            planetNumber = getArguments().getString(NUMBER);
            planetUrl = getArguments().getString(URL);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

         rootView = inflater.inflate(R.layout.fragment_blank, container, false);
         name = rootView.findViewById(R.id.name_text_view);
         number = rootView.findViewById(R.id.number_text_view);
         url = rootView.findViewById(R.id.planets_url);

         name.setText(planetName);
         number.setText(planetNumber);
        Picasso.get().load(planetUrl).into(url);



        return rootView;
    }
}
