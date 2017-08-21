package com.example.eve.demobmw.api;

import com.example.eve.demobmw.model.LocationModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


public interface ApiInterface {

    @GET("api/Locations")
    Call<List<LocationModel>> getProductData();
}
