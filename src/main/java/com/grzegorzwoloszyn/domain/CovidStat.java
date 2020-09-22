
package com.grzegorzwoloszyn.domain;

import java.util.List;

public class CovidStat {

    private String message;

    private Global global;

    private List<Country> countries = null;

    private String date;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Global getGlobal() {
        return global;
    }

    public void setGlobal(Global global) {
        this.global = global;
    }

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "CovidStat{" +
                "message='" + message + '\'' +
                ", global=" + global +
                ", countries=" + countries +
                ", date='" + date + '\'' +
                '}';
    }
}
