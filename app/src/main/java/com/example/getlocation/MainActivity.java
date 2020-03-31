package com.example.getlocation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements LocationListener {

    private static final String TAG=MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LocationManager lm =
                (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);

        Location location = new Location(lm);


    }

    @Override
    public void onLocationChanged(Location location)
    {
        if (location != null)
        {
            Log.d(TAG, "Широта="+location.getLatitude());
            Log.d(TAG, "Долгота="+location.getLongitude());
            Toast.makeText(this, String.valueOf(location.getLatitude()), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onProviderDisabled(String provider)
    {
    }

    @Override
    public void onProviderEnabled(String provider)
    {
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras)
    {
    }

}
