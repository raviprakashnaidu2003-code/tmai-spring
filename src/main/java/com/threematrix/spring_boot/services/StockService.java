package com.threematrix.spring_boot.services;
import com.threematrix.spring_boot.response.StockResponse;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class StockService {

    private final RestTemplate restTemplate = new RestTemplate();

    public StockResponse getStockPrice(String symbol) {

        String url = "https://www.nseindia.com/api/quote-equity?symbol=" + symbol;

        HttpHeaders headers = new HttpHeaders();
        headers.set("User-Agent", "Mozilla/5.0");
        headers.set("Accept", "application/json");
        headers.set("Referer", "https://www.nseindia.com");

        HttpEntity<Void> entity = new HttpEntity<>(headers);

        ResponseEntity<Map> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                Map.class
        );

        Map<?, ?> body = response.getBody();
        Map<?, ?> priceInfo = (Map<?, ?>) body.get("priceInfo");

        return new StockResponse(
                symbol,
                toDouble(priceInfo.get("lastPrice")),
                toDouble(priceInfo.get("change")),
                toDouble(priceInfo.get("pChange"))
        );
    }

    private Double toDouble(Object value) {
        return value == null ? 0.0 : Double.parseDouble(value.toString());
    }
}
