package com.pursuit.feb4classwithjosefragmentsappfromscratch.controller;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pursuit.feb4classwithjosefragmentsappfromscratch.R;
import com.pursuit.feb4classwithjosefragmentsappfromscratch.model.Planet;
import com.pursuit.feb4classwithjosefragmentsappfromscratch.model.PlanetList;

import java.util.List;

public class PlanetAdapter extends RecyclerView.Adapter<MyPlanetViewHolder> {
    private List<Planet> planetList;

    public PlanetAdapter(List<Planet> planetList){
        this.planetList = planetList;
    }

    @NonNull
    @Override
    public MyPlanetViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View childView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.planet_item_view, viewGroup, false);
        return new MyPlanetViewHolder(childView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyPlanetViewHolder myPlanetViewHolder, int i) {
        myPlanetViewHolder.onBind(planetList.get(i));

    }

    @Override
    public int getItemCount() {
        return planetList.size();
    }

}
