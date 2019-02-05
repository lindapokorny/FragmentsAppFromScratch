package com.pursuit.feb4classwithjosefragmentsappfromscratch.network;

import com.pursuit.feb4classwithjosefragmentsappfromscratch.model.PlanetList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PlanetService {
    @GET("JDVila/storybook/master/planets.json")
    Call<PlanetList>getPlanets();
}
