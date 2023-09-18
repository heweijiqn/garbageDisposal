package com.gcms.utils;

import java.util.List;

public class City {

    private String name;
    private List<String> area;
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setArea(List<String> area) {
        this.area = area;
    }
    public List<String> getArea() {
        return area;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", area=" + area +
                '}';
    }
}
