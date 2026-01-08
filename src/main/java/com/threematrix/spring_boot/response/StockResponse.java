package com.threematrix.spring_boot.response;

public class StockResponse{
    String symbol;
    double price;

    double change;

    public StockResponse(String symbol, double price, double change, double percentChange) {
        this.symbol = symbol;
        this.price = price;
        this.change = change;
        this.percentChange = percentChange;
    }

    double percentChange;

    public String getSymbol() {
        return symbol;
    }

    public double getPrice() {
        return price;
    }

    public double getChange() {
        return change;
    }

    public double getPercentChange() {
        return percentChange;
    }


}

