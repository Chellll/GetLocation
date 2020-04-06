
package com.example.getlocation.data.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Response {

    @SerializedName("venue")
    @Expose
    private Venue_ venue;

    public Venue_ getVenue() {
        return venue;
    }

    public void setVenue(Venue_ venue) {
        this.venue = venue;
    }

}
