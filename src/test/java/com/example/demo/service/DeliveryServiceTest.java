package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.example.demo.delivery.DeliveryType;
import com.example.demo.order.SimpleItem;

class DeliveryServiceTest {

    private final DeliveryService deliveryService = new DeliveryService();
    private final List<SimpleItem> sampleItems = List.of(
            new SimpleItem("Red Rose", 12.0),
            new SimpleItem("Blue Tulip", 8.0));

    @Test
    void postDeliveryListsItems() {
        String result = deliveryService.scheduleDelivery(DeliveryType.POST, List.copyOf(sampleItems));
        assertTrue(result.contains("Red Rose") && result.contains("Blue Tulip"), () -> "Result should mention each item: " + result);
    }

    @Test
    void dhlDeliveryMentionsItemCount() {
        String result = deliveryService.scheduleDelivery(DeliveryType.DHL, List.copyOf(sampleItems));
        assertTrue(result.contains("2 items"), () -> "Result should mention number of items, got: " + result);
    }
}

