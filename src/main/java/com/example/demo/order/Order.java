package com.example.demo.order;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import com.example.demo.delivery.Delivery;
import com.example.demo.payment.Payment;

public class Order {
    private final List<Item> items = new ArrayList<>();
    private Payment paymentStrategy;
    private Delivery deliveryStrategy;

    public void setPaymentStrategy(Payment paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void setDeliveryStrategy(Delivery deliveryStrategy) {
        this.deliveryStrategy = deliveryStrategy;
    }

    public void addItem(Item item) {
        if (item != null) {
            items.add(item);
        }
    }

    public List<Item> getItems() {
        return Collections.unmodifiableList(items);
    }

    public double calculateTotalPrice() {
        return items.stream().mapToDouble(Item::getPrice).sum();
    }

    public String processOrder() {
        if (items.isEmpty()) {
            throw new IllegalStateException("Order must contain at least one item.");
        }
        Objects.requireNonNull(paymentStrategy, "Payment strategy not set.");
        Objects.requireNonNull(deliveryStrategy, "Delivery strategy not set.");

        double total = calculateTotalPrice();
        String paymentResult = paymentStrategy.pay(total);
        String deliveryResult = deliveryStrategy.deliver(getItems());
        return paymentResult + " | " + deliveryResult;
    }
}

