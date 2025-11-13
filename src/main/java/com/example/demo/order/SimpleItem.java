package com.example.demo.order;

public class SimpleItem extends Item {
    private final double price;

    public SimpleItem(String description, double price) {
        super(description);
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }
}

