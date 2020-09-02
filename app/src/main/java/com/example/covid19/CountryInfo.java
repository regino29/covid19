package com.example.covid19;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.math.BigInteger;

public class CountryInfo {

    @SerializedName("_id")
    @Expose
    public BigInteger id;

    @SerializedName("flag")
    @Expose
    public String flag;


    /**
     * @param flag
     */
    public CountryInfo(BigInteger id, String flag) {
        super();
        this.id = id;
        this.flag = flag;
    }

    public String getFlag() {
        return flag;
    }
}
