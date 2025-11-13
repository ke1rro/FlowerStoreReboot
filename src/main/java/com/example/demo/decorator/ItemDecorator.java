package com.example.demo.decorator;

import com.example.demo.order.Item;

/**
 * Abstract base decorator that implements basic decorator behavior.
 * This follows the Decorator Pattern by wrapping an Item and delegating
 * the basic description behavior while allowing subclasses to add
 * additional functionality.
 */
public abstract class ItemDecorator extends Item {
    protected final Item item;

    protected ItemDecorator(Item item) {
        super(item.getDescription());
        this.item = item;
    }

    @Override
    public abstract String getDescription();
}
