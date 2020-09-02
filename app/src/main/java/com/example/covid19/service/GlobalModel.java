package com.example.covid19.service;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.math.BigInteger;

public class GlobalModel {

    @SerializedName("updated")
    @Expose
    private BigInteger updated;
    @SerializedName("cases")
    @Expose
    private BigInteger cases;
    @SerializedName("todayCases")
    @Expose
    private BigInteger todayCases;
    @SerializedName("deaths")
    @Expose
    private BigInteger deaths;
    @SerializedName("todayDeaths")
    @Expose
    private BigInteger todayDeaths;
    @SerializedName("recovered")
    @Expose
    private BigInteger recovered;
    @SerializedName("todayRecovered")
    @Expose
    private BigInteger todayRecovered;
    @SerializedName("active")
    @Expose
    private BigInteger active;
    @SerializedName("critical")
    @Expose
    private BigInteger critical;
    @SerializedName("casesPerOneMillion")
    @Expose
    private BigInteger casesPerOneMillion;
    @SerializedName("deathsPerOneMillion")
    @Expose
    private Float deathsPerOneMillion;
    @SerializedName("tests")
    @Expose
    private BigInteger tests;
    @SerializedName("testsPerOneMillion")
    @Expose
    private Float testsPerOneMillion;
    @SerializedName("population")
    @Expose
    private BigInteger population;
    @SerializedName("oneCasePerPeople")
    @Expose
    private BigInteger oneCasePerPeople;
    @SerializedName("oneDeathPerPeople")
    @Expose
    private BigInteger oneDeathPerPeople;
    @SerializedName("oneTestPerPeople")
    @Expose
    private BigInteger oneTestPerPeople;
    @SerializedName("activePerOneMillion")
    @Expose
    private Float activePerOneMillion;
    @SerializedName("recoveredPerOneMillion")
    @Expose
    private Float recoveredPerOneMillion;
    @SerializedName("criticalPerOneMillion")
    @Expose
    private Float criticalPerOneMillion;
    @SerializedName("affectedCountries")
    @Expose
    private BigInteger affectedCountries;


    public GlobalModel(BigInteger updated, BigInteger cases, BigInteger todayCases, BigInteger deaths, BigInteger todayDeaths, BigInteger recovered, BigInteger todayRecovered, BigInteger active, BigInteger critical, BigInteger casesPerOneMillion, Float deathsPerOneMillion, BigInteger tests, Float testsPerOneMillion, BigInteger population, BigInteger oneCasePerPeople, BigInteger oneDeathPerPeople, BigInteger oneTestPerPeople, Float activePerOneMillion, Float recoveredPerOneMillion, Float criticalPerOneMillion, BigInteger affectedCountries) {
        super();
        this.updated = updated;
        this.cases = cases;
        this.todayCases = todayCases;
        this.deaths = deaths;
        this.todayDeaths = todayDeaths;
        this.recovered = recovered;
        this.todayRecovered = todayRecovered;
        this.active = active;
        this.critical = critical;
        this.casesPerOneMillion = casesPerOneMillion;
        this.deathsPerOneMillion = deathsPerOneMillion;
        this.tests = tests;
        this.testsPerOneMillion = testsPerOneMillion;
        this.population = population;
        this.oneCasePerPeople = oneCasePerPeople;
        this.oneDeathPerPeople = oneDeathPerPeople;
        this.oneTestPerPeople = oneTestPerPeople;
        this.activePerOneMillion = activePerOneMillion;
        this.recoveredPerOneMillion = recoveredPerOneMillion;
        this.criticalPerOneMillion = criticalPerOneMillion;
        this.affectedCountries = affectedCountries;
    }


    public BigInteger getUpdated() {
        return updated;
    }

    public void setUpdated(BigInteger updated) {
        this.updated = updated;
    }

    public BigInteger getCases() {
        return cases;
    }

    public void setCases(BigInteger cases) {
        this.cases = cases;
    }

    public BigInteger getTodayCases() {
        return todayCases;
    }

    public void setTodayCases(BigInteger todayCases) {
        this.todayCases = todayCases;
    }

    public BigInteger getDeaths() {
        return deaths;
    }

    public void setDeaths(BigInteger deaths) {
        this.deaths = deaths;
    }

    public BigInteger getTodayDeaths() {
        return todayDeaths;
    }

    public void setTodayDeaths(BigInteger todayDeaths) {
        this.todayDeaths = todayDeaths;
    }

    public BigInteger getRecovered() {
        return recovered;
    }

    public void setRecovered(BigInteger recovered) {
        this.recovered = recovered;
    }

    public BigInteger getTodayRecovered() {
        return todayRecovered;
    }

    public void setTodayRecovered(BigInteger todayRecovered) {
        this.todayRecovered = todayRecovered;
    }

    public BigInteger getActive() {
        return active;
    }

    public void setActive(BigInteger active) {
        this.active = active;
    }

    public BigInteger getCritical() {
        return critical;
    }

    public void setCritical(BigInteger critical) {
        this.critical = critical;
    }

    public BigInteger getCasesPerOneMillion() {
        return casesPerOneMillion;
    }

    public void setCasesPerOneMillion(BigInteger casesPerOneMillion) {
        this.casesPerOneMillion = casesPerOneMillion;
    }

    public Float getDeathsPerOneMillion() {
        return deathsPerOneMillion;
    }

    public void setDeathsPerOneMillion(Float deathsPerOneMillion) {
        this.deathsPerOneMillion = deathsPerOneMillion;
    }

    public BigInteger getTests() {
        return tests;
    }

    public void setTests(BigInteger tests) {
        this.tests = tests;
    }

    public Float getTestsPerOneMillion() {
        return testsPerOneMillion;
    }

    public void setTestsPerOneMillion(Float testsPerOneMillion) {
        this.testsPerOneMillion = testsPerOneMillion;
    }

    public BigInteger getPopulation() {
        return population;
    }

    public void setPopulation(BigInteger population) {
        this.population = population;
    }

    public BigInteger getOneCasePerPeople() {
        return oneCasePerPeople;
    }

    public void setOneCasePerPeople(BigInteger oneCasePerPeople) {
        this.oneCasePerPeople = oneCasePerPeople;
    }

    public BigInteger getOneDeathPerPeople() {
        return oneDeathPerPeople;
    }

    public void setOneDeathPerPeople(BigInteger oneDeathPerPeople) {
        this.oneDeathPerPeople = oneDeathPerPeople;
    }

    public BigInteger getOneTestPerPeople() {
        return oneTestPerPeople;
    }

    public void setOneTestPerPeople(BigInteger oneTestPerPeople) {
        this.oneTestPerPeople = oneTestPerPeople;
    }

    public Float getActivePerOneMillion() {
        return activePerOneMillion;
    }

    public void setActivePerOneMillion(Float activePerOneMillion) {
        this.activePerOneMillion = activePerOneMillion;
    }

    public Float getRecoveredPerOneMillion() {
        return recoveredPerOneMillion;
    }

    public void setRecoveredPerOneMillion(Float recoveredPerOneMillion) {
        this.recoveredPerOneMillion = recoveredPerOneMillion;
    }

    public Float getCriticalPerOneMillion() {
        return criticalPerOneMillion;
    }

    public void setCriticalPerOneMillion(Float criticalPerOneMillion) {
        this.criticalPerOneMillion = criticalPerOneMillion;
    }

    public BigInteger getAffectedCountries() {
        return affectedCountries;
    }

    public void setAffectedCountries(BigInteger affectedCountries) {
        this.affectedCountries = affectedCountries;
    }

}