package com.pinakabarato.BudgetWise.entity;

import com.google.cloud.Timestamp;


public class Expense {
    private String name;
    private double price;
    private String timestamp;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", timestamp=" + timestamp +
                '}';
    }
}
