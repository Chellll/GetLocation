package com.example.getlocation.data.repository;

import com.example.getlocation.data.models.api.Explore;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FourSquareService {
    @GET("venues/explore/")
    Call<Explore> requestExplore(
            @Query("client_id") String client_id,
            @Query("client_secret") String client_secret,
            @Query("v") String v,
            @Query("ll") String ll,
            @Query("query") String query
    );
}
