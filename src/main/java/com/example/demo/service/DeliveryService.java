package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.delivery.DHLDeliveryStrategy;
import com.example.demo.delivery.Delivery;
import com.example.demo.delivery.DeliveryType;
import com.example.demo.delivery.PostDeliveryStrategy;
import com.example.demo.order.Item;

@Service
public class DeliveryService {

    public String scheduleDelivery(DeliveryType type, List<Item> items) {
        Delivery delivery = switch (type) {
            case DHL -> new DHLDeliveryStrategy();
            case POST -> new PostDeliveryStrategy();
        };
        return delivery.deliver(items);
    }
}

