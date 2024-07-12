package com.example.tour_guide.models;


import com.google.gson.annotations.SerializedName;

public class FoodDrinks {

    @SerializedName("images")
    String images;

    @SerializedName("id")
    String id;

    @SerializedName("place_name")
    String placeName;

    @SerializedName("description")
    String description;

    @SerializedName("lattitude")
    String lattitude;

    @SerializedName("longtitude")
    String longtitude;

    @SerializedName("website")
    String website;

    @SerializedName("address")
    String address;

    @SerializedName("contact")
    String contact;

    @SerializedName("status")
    String status;


    public void setImages(String images) {
        this.images = images;
    }

    public String getImages() {
        return images;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setLattitude(String lattitude) {
        this.lattitude = lattitude;
    }

    public String getLattitude() {
        return lattitude;
    }

    public void setLongtitude(String longtitude) {
        this.longtitude = longtitude;
    }

    public String getLongtitude() {
        return longtitude;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getWebsite() {
        return website;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getContact() {
        return contact;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

}