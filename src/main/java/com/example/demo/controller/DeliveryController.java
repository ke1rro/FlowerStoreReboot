package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.delivery.DeliveryType;
import com.example.demo.order.Item;
import com.example.demo.service.DeliveryService;
import com.example.demo.service.FlowerService;

@RestController
@RequestMapping("/api/delivery")
public class DeliveryController {

    private final DeliveryService deliveryService;
    private final FlowerService flowerService;

    public DeliveryController(DeliveryService deliveryService, FlowerService flowerService) {
        this.deliveryService = deliveryService;
        this.flowerService = flowerService;
    }

    @GetMapping
    public String deliver(@RequestParam DeliveryType type, @RequestParam(defaultValue = "2") int items) {
        List<Item> sampleItems = flowerService.findAll().stream()
                .limit(Math.max(items, 1))
                .map(Item.class::cast)
                .toList();
        return deliveryService.scheduleDelivery(type, sampleItems);
    }
}
