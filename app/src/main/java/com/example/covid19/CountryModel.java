package com.example.covid19;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.math.BigInteger;

public class CountryModel {

    @SerializedName("updated")
    @Expose
    public BigInteger updated;
    @SerializedName("country")
    @Expose
    public String country;
    @SerializedName("countryInfo")
    @Expose
    public CountryInfo countryInfo;
    @SerializedName("cases")
    @Expose
    public BigInteger cases;
    @SerializedName("todayCases")
    @Expose
    public BigInteger todayCases;
    @SerializedName("deaths")
    @Expose
    public BigInteger deaths;
    @SerializedName("todayDeaths")
    @Expose
    public BigInteger todayDeaths;
    @SerializedName("recovered")
    @Expose
    public BigInteger recovered;
    @SerializedName("todayRecovered")
    @Expose
    public BigInteger todayRecovered;
    @SerializedName("active")
    @Expose
    public BigInteger active;
    @SerializedName("critical")
    @Expose
    public BigInteger critical;
    @SerializedName("continent")
    @Expose
    public String continent;


    public CountryModel(BigInteger updated, String country, CountryInfo countryInfo, BigInteger cases, BigInteger todayCases, BigInteger deaths, BigInteger todayDeaths, BigInteger recovered, BigInteger todayRecovered, BigInteger active, BigInteger critical, String continent) {
        this.updated = updated;
        this.country = country;
        this.countryInfo = countryInfo;
        this.cases = cases;
        this.todayCases = todayCases;
        this.deaths = deaths;
        this.todayDeaths = todayDeaths;
        this.recovered = recovered;
        this.todayRecovered = todayRecovered;
        this.active = active;
        this.critical = critical;
        this.continent = continent;
    }


    public BigInteger getUpdated() {
        return updated;
    }

    public String getCountry() {
        return country;
    }

    public CountryInfo getCountryInfo() {
        return countryInfo;
    }

    public BigInteger getCases() {
        return cases;
    }

    public BigInteger getTodayCases() {
        return todayCases;
    }

    public BigInteger getDeaths() {
        return deaths;
    }

    public BigInteger getTodayDeaths() {
        return todayDeaths;
    }

    public BigInteger getRecovered() {
        return recovered;
    }

    public BigInteger getTodayRecovered() {
        return todayRecovered;
    }

    public BigInteger getActive() {
        return active;
    }

    public BigInteger getCritical() {
        return critical;
    }

    public String getContinent() {
        return continent;
    }
}
