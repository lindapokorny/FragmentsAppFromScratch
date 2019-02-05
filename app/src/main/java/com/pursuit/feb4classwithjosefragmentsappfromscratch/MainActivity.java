package com.pursuit.feb4classwithjosefragmentsappfromscratch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.LinearLayout;

import com.pursuit.feb4classwithjosefragmentsappfromscratch.controller.PlanetAdapter;
import com.pursuit.feb4classwithjosefragmentsappfromscratch.model.Planet;
import com.pursuit.feb4classwithjosefragmentsappfromscratch.model.PlanetList;
import com.pursuit.feb4classwithjosefragmentsappfromscratch.network.PlanetService;
import com.pursuit.feb4classwithjosefragmentsappfromscratch.network.RetrofitSingleton;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    public final String TAG = "Main Activity";
    //private PlanetService planetService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Retrofit retrofit = RetrofitSingleton.getInstance();
        recyclerView = findViewById(R.id.recycler_view);

        Call<PlanetList> call = retrofit.create(PlanetService.class).getPlanets();
        call.enqueue(new Callback<PlanetList>() {
            @Override
            public void onResponse(Call<PlanetList> call, Response<PlanetList> response) {
                Log.d(TAG, "This Retrofit call works- Linda");
                //List<Planet> planetList = response.body().getPlanets();
                recyclerView.setAdapter(new PlanetAdapter(response.body().getPlanets()));
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

            }

            @Override
            public void onFailure(Call<PlanetList> call, Throwable t) {

            }
        });
    }
}