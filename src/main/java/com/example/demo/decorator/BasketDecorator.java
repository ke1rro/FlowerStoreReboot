package com.example.demo.decorator;

import com.example.demo.order.Item;

/**
 * Concrete decorator that adds a basket to an item.
 * Adds 4 to the base item price.
 */
public class BasketDecorator extends ItemDecorator {

    public BasketDecorator(Item item) {
        super(item);
    }

    @Override
    public double getPrice() {
        return 4 + item.getPrice();
    }

    @Override
    public String getDescription() {
        return item.getDescription() + " in a basket";
    }
}
