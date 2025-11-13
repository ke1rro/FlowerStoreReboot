package com.example.demo.decorator;

import com.example.demo.order.Item;

/**
 * Concrete decorator that adds paper wrapping to an item.
 * Adds 13 to the base item price.
 */
public class PaperDecorator extends ItemDecorator {

    public PaperDecorator(Item item) {
        super(item);
    }

    @Override
    public double getPrice() {
        return 13 + item.getPrice();
    }

    @Override
    public String getDescription() {
        return item.getDescription() + " wrapped in paper";
    }
}
