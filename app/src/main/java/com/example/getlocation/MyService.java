package com.example.getlocation;

import android.app.Service;
import android.content.Intent;
import android.location.Location;
import android.os.IBinder;

import androidx.annotation.NonNull;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class MyService extends Service {

    FusedLocationProviderClient mFusedLocationClient;

    public MyService() {

        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(getBaseContext());
         mFusedLocationClient.getLastLocation().addOnCompleteListener(getMainExecutor(), new OnCompleteListener<Location>() {
             @Override
             public void onComplete(@NonNull Task<Location> task) {

             }
         });

    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
