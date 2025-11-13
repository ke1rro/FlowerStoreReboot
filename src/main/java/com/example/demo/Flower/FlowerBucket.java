package com.example.demo.Flower;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.example.demo.order.Item;

public class FlowerBucket extends Item {
    private final List<Item> flowers = new ArrayList<>();

    public FlowerBucket() {
        super("Flower bucket");
    }

    public void addFlower(Item flower) {
        if (flower != null) {
            flowers.add(flower);
        }
    }

    public void addFlowers(List<? extends Item> items) {
        if (items != null) {
            items.stream().filter(java.util.Objects::nonNull).forEach(flowers::add);
        }
    }

    public boolean searchFlowers(FlowerSpecs specs) {
        return flowers.stream()
                .filter(Flower.class::isInstance)
                .map(Flower.class::cast)
                .anyMatch(flower -> flower.getSpecs().isMatch(specs));
    }

    public List<Item> getFlowers() {
        return Collections.unmodifiableList(flowers);
    }

    @Override
    public double getPrice() {
        return flowers.stream().mapToDouble(Item::getPrice).sum();
    }
}
