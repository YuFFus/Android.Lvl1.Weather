package com.yuriy.fedak.weather;

import java.io.Serializable;

public final class Parsel implements Serializable {

    private String cityName;

    Parsel (String cityName) {
        this.cityName = cityName;
    }
    String getCityName() {return cityName;}
}
