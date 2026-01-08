package com.threematrix.spring_boot.services;

import com.threematrix.spring_boot.response.WeatherResponseBean;

import org.springframework.stereotype.Service;

import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class WeatherService {

    private final RestTemplate restTemplate = new RestTemplate();

    public WeatherResponseBean fetchWeather(double lat, double lon) {

        String url = "https://api.open-meteo.com/v1/forecast"
            + "?latitude=" + lat
            + "&longitude=" + lon
            + "&current_weather=true";

        // Call public API
        Map response = restTemplate.getForObject(url, Map.class);

        Map<String, Object> current = (Map<String, Object>) response.get("current_weather");

        double temperature = (double) current.get("temperature");
        double windSpeed = (double) current.get("windspeed");

        // Simple manipulation
        String feeling = temperature > 30 ? "HOT" : "PLEASANT";

        return new WeatherResponseBean(temperature, windSpeed, feeling);
    }

}
