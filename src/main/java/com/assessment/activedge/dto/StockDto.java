package com.assessment.activedge.dto;

public class StockDto {
    private String name;
    private Double current_price;

    public StockDto(String name, Double current_price) {
        this.name = name;
        this.current_price = current_price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCurrent_price() {
        return current_price;
    }

    public void setCurrent_price(Double current_price) {
        this.current_price = current_price;
    }
}
