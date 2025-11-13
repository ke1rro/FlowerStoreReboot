package com.example.demo.decorator;

import com.example.demo.order.Item;

/**
 * Concrete decorator that adds a ribbon to an item.
 * Adds 40 to the base item price.
 */
public class RibbonDecorator extends ItemDecorator {

    public RibbonDecorator(Item item) {
        super(item);
    }

    @Override
    public double getPrice() {
        return 40 + item.getPrice();
    }

    @Override
    public String getDescription() {
        return item.getDescription() + " with ribbon";
    }
}
