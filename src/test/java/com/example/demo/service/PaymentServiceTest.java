package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.example.demo.payment.PaymentType;

class PaymentServiceTest {

    private final PaymentService paymentService = new PaymentService();

    @Test
    void creditCardStrategyMasksCardNumber() {
        String result = paymentService.processPayment(PaymentType.CREDIT_CARD, 50.0);
        assertTrue(result.contains("****1111"), () -> "Result should mask card number, got: " + result);
    }

    @Test
    void payPalStrategyUsesConfiguredAccount() {
        String result = paymentService.processPayment(PaymentType.PAYPAL, 25.5);
        assertTrue(result.contains("demo@flower.store"), () -> "Result should reference PayPal account, got: " + result);
    }
}

