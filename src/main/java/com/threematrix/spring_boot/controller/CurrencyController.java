package com.threematrix.spring_boot.controller;


import com.threematrix.spring_boot.services.CurrencyService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/currency")
public class CurrencyController {

    private final CurrencyService currencyService;

    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @GetMapping("/convert")
    public Map<String, Object> convert(
            @RequestParam String from,
            @RequestParam  String to,
            @RequestParam  double amount) {

        return currencyService.convert(from.toUpperCase(), to.toUpperCase(), amount);
    }
}