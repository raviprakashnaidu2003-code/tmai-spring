package com.threematrix.spring_boot.response;

public class WeatherResponseBean {
    private double temperature;
    private double windSpeed;
    private String feeling;

    public WeatherResponseBean(double temperature, double windSpeed, String feeling) {
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.feeling = feeling;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public String getFeeling() {
        return feeling;
    }
}