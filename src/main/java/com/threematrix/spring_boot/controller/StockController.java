package com.threematrix.spring_boot.controller;

import com.threematrix.spring_boot.response.StockResponse;
import com.threematrix.spring_boot.services.StockService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/stocks")
public class StockController {

    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping
    public ResponseEntity<StockResponse> getStock(
            @RequestParam String symbol) {

        return ResponseEntity.ok(stockService.getStockPrice(symbol));
    }
}
