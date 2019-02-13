package com.yuriy.fedak.weather;

public class History_Data {

        private String temp;
        private String pressure;
        private String wind;
        private String humidity;

        public History_Data(String temp, String pressure, String wind, String humidity){

            this.temp = temp;
            this.pressure = pressure;
            this.wind = wind;
            this.humidity = humidity;
        }

        public String getTemp() {
            return this.temp;
        }

        public void setTemp(String temp) {
            this.temp = temp;
        }

        public String getPressure() {
        return this.pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }


    public String getWind() {
        return this.wind;
    }

    public void setWind(String wind) {
        this.humidity = humidity;
    }

    public String getHumidity() {
        return this.humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }
}

