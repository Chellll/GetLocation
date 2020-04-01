package com.example.getlocation;

import android.location.Address;
import android.location.Geocoder;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class Location  {

    LocationManager mLocationManager;
    double lat;
    double lng;

    public Location() {
        this.lat = 0;
        this.lng = 0;
    }

   // @Override
    public void onLocationChanged(android.location.Location location) {
        if (location != null) {
            lat = location.getLatitude();
            lng = location.getLongitude();

//            //Geocoder geocoder = new Geocoder(getClass(), Locale.getDefault());
//
//            try {
//               // List<Address> addresses = geocoder.getFromLocation(lat, lng, 1);
//
//                if (addresses != null) {
//                    Address returnedAddress = addresses.get(0);
//                    StringBuilder strReturnedAddress = new StringBuilder(
//                            "Адрес:\n");
//                    for (int i = 0; i < returnedAddress.getMaxAddressLineIndex(); i++) {
//                        strReturnedAddress
//                                .append(returnedAddress.getAddressLine(i)).append(
//                                "\n");
//                    }
//                    mLatitudeTextView.setText(returnedAddress.toString());
//                    //myAddress.setText(strReturnedAddress.toString());
//                } else {
//                    //myAddress.setText("Нет адресов!");
//                }
//            } catch (IOException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//                //myAddress.setText("Не могу получить адрес!");
//            }
//        }
        }
//
//    public double getLat() {
//        return lat;
//    }
//
//    public double getLng() {
//        return lng;
//    }
//
//    @Override
//    public void onStatusChanged(String provider, int status, Bundle extras) {
//
//    }
//
//    @Override
//    public void onProviderEnabled(String provider) {
//
//    }
//
//    @Override
//    public void onProviderDisabled(String provider) {
//
//    }
    }
}
