package com.example.demo.payment;

import java.text.DecimalFormat;

public class CreditCardPaymentStrategy implements Payment {
    private static final DecimalFormat MONEY = new DecimalFormat("#0.00");
    private final String cardNumber;
    private final String cardHolder;

    public CreditCardPaymentStrategy(String cardNumber, String cardHolder) {
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
    }

    @Override
    public String pay(double amount) {
        String maskedNumber = cardNumber.length() > 4
                ? "****" + cardNumber.substring(cardNumber.length() - 4)
                : cardNumber;
        return "Charged " + MONEY.format(amount) + " to card " + maskedNumber + " for " + cardHolder;
    }
}

