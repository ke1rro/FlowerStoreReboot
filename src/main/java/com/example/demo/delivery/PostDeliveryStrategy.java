package com.example.demo.delivery;

import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.order.Item;

public class PostDeliveryStrategy implements Delivery {

    @Override
    public String deliver(List<Item> items) {
        String names = items.stream()
                .map(Item::getDescription)
                .collect(Collectors.joining(", "));
        return "Sent via National Post: " + names;
    }
}
