package com.example.getlocation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Observable;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
//
import com.example.getlocation.Model.Category;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.SettingsClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import com.example.getlocation.Model.Explore;
import com.example.getlocation.Model.Item_;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity{

    EditText etGeolocation, etQuery;
    Button btnSearch, btn_getLocation;
    ListView listView;
    String Client_ID = "VIEQ0QX5GAJ1XLDJABA5WBS54XCVTNWLNY2NLAZVNB2ZDUYM";
    String Client_Secret = "COARL4531NXUEZTWDE21201TRAZXPEFIQKXFY4AJKHWHDXOT";
    String apiVersion = "20161010";
    String geoLocation = "55.808806,49.185879";
    String query = "";

    List<Item_> item_list = new ArrayList<>();

    private LocationCallback mLocationCallback;

    /**
     * Represents a geographical location.
     */
    protected Location mLastLocation;

    int REQUEST_PERMISSIONS_REQUEST_CODE = 1001;

    FusedLocationProviderClient mFusedLocationClient;


    double lat = 57.9989369;
    double lng = 56.2853801;

    @SuppressLint("MissingPermission")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.listivew);
        btn_getLocation = (Button) findViewById(R.id.getLocation);


        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);


        btn_getLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!checkPermissions()) {
                    requestPermissions();
                } else {
                    getLastLocation();
                }

                ExploreAsyncTask exploreAsyncTask = new ExploreAsyncTask();
                exploreAsyncTask.execute();

            }
        });

    }

    private boolean checkPermissions() {
        int permissionState = ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION);
        return permissionState == PackageManager.PERMISSION_GRANTED;
    }


    //получение координат
    @SuppressWarnings("MissingPermission")
    private void getLastLocation() {

        SettingsClient client = LocationServices.getSettingsClient(this);

        mLocationCallback = new LocationCallback(){
            @Override
            public void onLocationResult(LocationResult locationResult) {
                super.onLocationResult(locationResult);

                Location mCurrentLocation = locationResult.getLocations().get(0);
                geoLocation = String.valueOf(mCurrentLocation.getLatitude()) + "," + String.valueOf(mCurrentLocation.getLongitude());
            }
        };


    }

    public void showMessage(String message) {
        if (message == null || message.length() == 0)
            return;

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }


    private void requestPermissions() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            getLastLocation();
        } else {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_PERMISSIONS_REQUEST_CODE);
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {

        if (requestCode == REQUEST_PERMISSIONS_REQUEST_CODE) {
            if (grantResults.length <= 0) {

            } else if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission granted.
                getLastLocation();
            } else {
                Intent intent = new Intent();
                intent.setAction(
                        Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                Uri uri = Uri.fromParts("package",
                        BuildConfig.APPLICATION_ID, null);
                intent.setData(uri);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        }

    }



    public class ExploreAsyncTask extends AsyncTask<Void,Void,List<Item_>> {

        List<Category> mCategories = new ArrayList<>();

        public ExploreAsyncTask() {
            super();
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected List<Item_> doInBackground(Void... voids) {
            FourSquareService fourSquareService = FourSquareService.retrofit.create(FourSquareService.class);
            final Call<Explore> call = fourSquareService.requestExplore(Client_ID, Client_Secret, apiVersion, geoLocation, query);

            try {
                Explore explore =  call.execute().body();
                item_list = explore.getResponse().getGroups().get(0).getItems();


            } catch (IOException e) {
                e.printStackTrace();
            }
            return item_list;
        }

        @Override
        protected void onPostExecute(List<Item_> item_s) {
            super.onPostExecute(item_s);
            ExploreListAdapter exploreListAdapter = new ExploreListAdapter(getApplicationContext(), R.layout.item_list, item_s);
            listView.setAdapter(exploreListAdapter);
        }
    }


            }

