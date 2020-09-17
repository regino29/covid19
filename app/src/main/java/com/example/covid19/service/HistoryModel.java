package com.example.covid19.service;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HistoryModel {

    @SerializedName("Country")
    @Expose
    public String country;
    @SerializedName("CountryCode")
    @Expose
    public String countryCode;
    @SerializedName("Province")
    @Expose
    public String province;
    @SerializedName("City")
    @Expose
    public String city;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public Integer getCases() {
        return cases;
    }

    public void setCases(Integer cases) {
        this.cases = cases;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @SerializedName("CityCode")
    @Expose
    public String cityCode;
    @SerializedName("Lat")
    @Expose
    public String lat;
    @SerializedName("Lon")
    @Expose
    public String lon;
    @SerializedName("Cases")
    @Expose
    public Integer cases;
    @SerializedName("Status")
    @Expose
    public String status;
    @SerializedName("Date")
    @Expose
    public String date;

}