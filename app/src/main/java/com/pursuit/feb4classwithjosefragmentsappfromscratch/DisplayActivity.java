package com.pursuit.feb4classwithjosefragmentsappfromscratch;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.pursuit.feb4classwithjosefragmentsappfromscratch.controller.MyPlanetViewHolder;

public class DisplayActivity extends AppCompatActivity {
    private TextView nameTextView;
    private TextView numberTextView;
    private ImageView planetsUrl;
    private final String NAME ="name";
    private final String NUMBER = "number";
    private final String URL = "image";
    private String nameText;
    private String numText;
    private String imageText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        nameTextView = findViewById(R.id.name_text_view);

        Intent intent = getIntent();
        nameText = intent.getStringExtra(NAME);
        numText = intent.getStringExtra(NUMBER);
        imageText = intent.getStringExtra(URL);

        BlankFragment fragment = BlankFragment.newInstance(nameText, numText, imageText);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.container_for_fragment, fragment)
                .addToBackStack("next")
                .commit();
    }
}
