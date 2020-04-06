package com.example.getlocation.data.repository;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FourSquareRepository {

    private FourSquareService mFourSquareService;
    private static FourSquareRepository sFourSquareRepository;
    private Retrofit retrofit;

    private FourSquareRepository(){
        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.foursquare.com/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mFourSquareService = retrofit.create(FourSquareService.class);
    }

    public synchronized static FourSquareRepository getInstance() {
        if (sFourSquareRepository == null) {
            sFourSquareRepository = new FourSquareRepository();
        }
        return sFourSquareRepository;
    }

}
