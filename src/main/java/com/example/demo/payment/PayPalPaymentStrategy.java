package com.example.demo.payment;

import java.text.DecimalFormat;

public class PayPalPaymentStrategy implements Payment {
    private static final DecimalFormat MONEY = new DecimalFormat("#0.00");
    private final String accountEmail;

    public PayPalPaymentStrategy(String accountEmail) {
        this.accountEmail = accountEmail;
    }

    @Override
    public String pay(double amount) {
        return "Paid " + MONEY.format(amount) + " via PayPal account " + accountEmail;
    }
}

