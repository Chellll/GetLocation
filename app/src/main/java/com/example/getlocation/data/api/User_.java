
package com.example.getlocation.data.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User_ {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("firstName")
    @Expose
    private String firstName;
    @SerializedName("photo")
    @Expose
    private Photo photo;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("tips")
    @Expose
    private Tips tips;
    @SerializedName("lists")
    @Expose
    private Lists lists;
    @SerializedName("bio")
    @Expose
    private String bio;

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

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Tips getTips() {
        return tips;
    }

    public void setTips(Tips tips) {
        this.tips = tips;
    }

    public Lists getLists() {
        return lists;
    }

    public void setLists(Lists lists) {
        this.lists = lists;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

}
