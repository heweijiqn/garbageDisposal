package com.gcms.utils;
import java.util.List;

public class JsonRootBean {


    private String name;
    private List<City> city;
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setCity(List<City> city) {
        this.city = city;
    }
    public List<City> getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "JsonRootBean{" +
                "name='" + name + '\'' +
                ", city=" + city +
                '}';
    }
}
