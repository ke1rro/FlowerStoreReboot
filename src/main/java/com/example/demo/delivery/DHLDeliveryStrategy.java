package com.example.demo.delivery;

import java.util.List;

import com.example.demo.order.Item;

public class DHLDeliveryStrategy implements Delivery {

    @Override
    public String deliver(List<Item> items) {
        return "Courier DHL scheduled for " + items.size() + " items";
    }
}
