package com.example.covid19;

public class CountryModel {

    private String flag,counry,cases,newCases,deaths,newDeaths,recovered,active,critical;

    public CountryModel() {
    }

    public CountryModel(String flag, String counry, String cases, String newCases, String deaths, String newDeaths, String recovered, String active, String critical) {
        this.flag = flag;
        this.counry = counry;
        this.cases = cases;
        this.newCases = newCases;
        this.deaths = deaths;
        this.newDeaths = newDeaths;
        this.recovered = recovered;
        this.active = active;
        this.critical = critical;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getCounry() {
        return counry;
    }

    public void setCounry(String counry) {
        this.counry = counry;
    }

    public String getCases() {
        return cases;
    }

    public void setCases(String cases) {
        this.cases = cases;
    }

    public String getNewCases() {
        return newCases;
    }

    public void setNewCases(String newCases) {
        this.newCases = newCases;
    }

    public String getDeaths() {
        return deaths;
    }

    public void setDeaths(String deaths) {
        this.deaths = deaths;
    }

    public String getNewDeaths() {
        return newDeaths;
    }

    public void setNewDeaths(String newDeaths) {
        this.newDeaths = newDeaths;
    }

    public String getRecovered() {
        return recovered;
    }

    public void setRecovered(String recovered) {
        this.recovered = recovered;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getCritical() {
        return critical;
    }

    public void setCritical(String critical) {
        this.critical = critical;
    }
}
