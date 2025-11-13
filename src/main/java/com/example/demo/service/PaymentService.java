package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.payment.CreditCardPaymentStrategy;
import com.example.demo.payment.PayPalPaymentStrategy;
import com.example.demo.payment.Payment;
import com.example.demo.payment.PaymentType;

@Service
public class PaymentService {

    public String processPayment(PaymentType type, double amount) {
        Payment strategy = switch (type) {
            case CREDIT_CARD -> new CreditCardPaymentStrategy("4111111111111111", "Demo Customer");
            case PAYPAL -> new PayPalPaymentStrategy("demo@flower.store");
        };
        return strategy.pay(amount);
    }
}

