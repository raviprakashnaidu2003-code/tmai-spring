package com.threematrix.spring_boot.controller;

import com.threematrix.spring_boot.response.WeatherResponseBean;
import com.threematrix.spring_boot.services.WeatherService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {
    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    // Example UI call:
    // http://localhost:8080/weather?lat=12.97&lon=77.59
    @GetMapping("/weather")
    public WeatherResponseBean getWeather(
        @RequestParam double lat,
        @RequestParam double lon) {
        return weatherService.fetchWeather(lat, lon);
    }

    @GetMapping("/weatherbefore")
    public WeatherResponseBean getWeatherBefore() {
        WeatherResponseBean wrb = new WeatherResponseBean(30.0D, 12.0D, "HOT");
        return wrb;
    }

}
