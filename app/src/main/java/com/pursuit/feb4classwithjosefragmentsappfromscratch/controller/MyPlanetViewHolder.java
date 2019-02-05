package com.pursuit.feb4classwithjosefragmentsappfromscratch.controller;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.pursuit.feb4classwithjosefragmentsappfromscratch.R;
import com.pursuit.feb4classwithjosefragmentsappfromscratch.DisplayActivity;
import com.pursuit.feb4classwithjosefragmentsappfromscratch.model.Planet;

public class MyPlanetViewHolder extends RecyclerView.ViewHolder {
    private static final String TAG = "PlanetCall";
    private TextView nameTextView;

    private Intent intent;

    public MyPlanetViewHolder(@NonNull View itemView) {
        super(itemView);
        nameTextView = itemView.findViewById(R.id.name_text_view);
    }
    public void onBind(final Planet planets){
        nameTextView.setText(planets.getName());

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), DisplayActivity.class);
                intent.putExtra("name", planets.getName());
                intent.putExtra("number", planets.getNum());
                intent.putExtra("image", planets.getImage());
                v.getContext().startActivity(intent);

            }
        });
    }
}
