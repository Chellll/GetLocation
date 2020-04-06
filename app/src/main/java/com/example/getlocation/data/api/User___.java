
package com.example.getlocation.data.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User___ {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("firstName")
    @Expose
    private String firstName;
    @SerializedName("lastName")
    @Expose
    private String lastName;
    @SerializedName("photo")
    @Expose
    private Photo___ photo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Photo___ getPhoto() {
        return photo;
    }

    public void setPhoto(Photo___ photo) {
        this.photo = photo;
    }

}
