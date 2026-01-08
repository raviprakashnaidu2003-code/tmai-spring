package com.threematrix.spring_boot.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

@Service
public class CurrencyService {

    private final RestTemplate restTemplate = new RestTemplate();

    public Map<String, Object> convert(String from, String to, double amount) {

        String url = "https://api.frankfurter.app/latest?from=" + from + "&to=" + to;
        Map response = restTemplate.getForObject(url, Map.class);

        Map<String, Object> rates = (Map<String, Object>) response.get("rates");
        double rate = (double) rates.get(to);

        BigDecimal converted = BigDecimal.valueOf(amount * rate)
                .setScale(2, RoundingMode.HALF_UP);

        return Map.of(
                "from", from,
                "to", to,
                "amount", amount,
                "rate", rate,
                "convertedAmount", converted
        );
    }
}
